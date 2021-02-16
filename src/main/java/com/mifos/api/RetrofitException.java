package com.mifos.api;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.mifos.utils.Constants;
import java.io.IOException;
import java.lang.annotation.Annotation;

import lombok.Builder;
import lombok.Data;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitException extends RuntimeException {
  static RetrofitException httpError(String url, Request request, Response response, Retrofit retrofit) {
    String message = response.code() + " " + response.message();

    if (TextUtils.isEmpty(response.message())) {
      try {
        ErrorWithDescription errorWithDescription =
            getErrorBodyAs(response, retrofit, ErrorWithDescription.class);

        if (errorWithDescription != null) {
          String errorCodeWithError = response.code() + "." + errorWithDescription.getError();

          if (Constants.GLOBAL_ERROR_MAP.get(errorCodeWithError) != null) {
            message = Constants.GLOBAL_ERROR_MAP.get(errorCodeWithError);
          } else {
            message = response.code() + " " + errorWithDescription.getErrorDescription();
          }
        }

      } catch (IOException ignore) {

      }
    }

    return new RetrofitException(message, url, request, response, Kind.HTTP, null, retrofit);
  }

  static RetrofitException networkError(IOException exception) {
    return new RetrofitException(exception.getMessage(), null, null, null, Kind.NETWORK, exception, null);
  }

  static RetrofitException unexpectedError(Throwable exception) {
    return new RetrofitException(exception.getMessage(), null, null, null, Kind.UNEXPECTED, exception, null);
  }

  /** Identifies the event kind which triggered a {@link RetrofitException}. */
  public enum Kind {
    /** An {@link IOException} occurred while communicating to the server. */
    NETWORK,
    /** A non-200 HTTP status code was received from the server. */
    HTTP,
    /**
     * An internal error occurred while attempting to execute a request. It is best practice to
     * re-throw this exception so your application crashes.
     */
    UNEXPECTED
  }

  private final String url;
  private final Response response;
  private final Request request;
  private final Kind kind;
  private final Retrofit retrofit;

  private RetrofitException(String message, String url, Request request, Response response, Kind kind, Throwable exception, Retrofit retrofit) {
    super(message, exception);
    this.url = url;
    this.request = request;
    this.response = response;
    this.kind = kind;
    this.retrofit = retrofit;
  }

  public Request getRequest() {
    return request;
  }

  /** The request URL which produced the error. */
  public String getUrl() {
    return url;
  }

  /** Response object containing status code, headers, body, etc. */
  public Response getResponse() {
    return response;
  }

  /** The event kind which triggered this error. */
  public Kind getKind() {
    return kind;
  }

  /** The Retrofit this request was executed on */
  public Retrofit getRetrofit() {
    return retrofit;
  }

  /**
   * HTTP response body converted to specified {@code type}. {@code null} if there is no
   * response.
   *
   * @throws IOException if unable to convert the body to the specified {@code type}.
   */
  public <T> T getErrorBodyAs(Class<T> type) throws IOException {
    if (response == null || response.errorBody() == null) {
      return null;
    }
    Converter<ResponseBody, T> converter = retrofit.responseBodyConverter(type, new Annotation[0]);
    return converter.convert(response.errorBody());
  }

  /**
   * HTTP response body converted to specified {@code type}. {@code null} if there is no response.
   *
   * @throws IOException if unable to convert the body to the specified {@code type}.
   */
  public static <T> T getErrorBodyAs(Response response, Retrofit retrofit, Class<T> type) throws IOException {
    if (response == null || response.errorBody() == null || retrofit == null) {
      return null;
    }
    Converter<ResponseBody, T> converter = retrofit.responseBodyConverter(type, new Annotation[0]);
    return converter.convert(response.errorBody());
  }

  @Data
  @Builder(toBuilder = true)
  public static class ErrorWithDescription {

    @SerializedName("error")
    private final String error;

    @SerializedName("error_description")
    private final String errorDescription;
  }
}
