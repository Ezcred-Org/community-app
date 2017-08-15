package com.mifos.api;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.annotation.Nullable;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.functions.Func1;

// refer http://bytes.babbel.com/en/articles/2016-03-16-retrofit2-rxjava-error-handling.html
public class MifosErrorHandlingCallAdapterFactory extends CallAdapter.Factory {
  private final RxJavaCallAdapterFactory original;

  public static CallAdapter.Factory create() {
    return new MifosErrorHandlingCallAdapterFactory();
  }

  public MifosErrorHandlingCallAdapterFactory() {
    this.original = RxJavaCallAdapterFactory.create();
  }

  @Nullable
  @Override
  public CallAdapter<?, ?> get(Type type, Annotation[] annotations, Retrofit retrofit) {
    return new RxCallAdapterWrapper(retrofit, original.get(type, annotations, retrofit));
  }

  private static class RxCallAdapterWrapper implements CallAdapter {
    private final Retrofit retrofit;
    private final CallAdapter wrapped;

    public RxCallAdapterWrapper(Retrofit retrofit, CallAdapter<?, ?> callAdapter) {

      this.retrofit = retrofit;
      this.wrapped = callAdapter;
    }

    @Override
    public Type responseType() {
      return wrapped.responseType();
    }

    @Override
    public Object adapt(final Call call) {
      return ((Observable) wrapped.adapt(call)).onErrorResumeNext(new Func1<Throwable, Observable>() {
        @Override
        public Observable call(Throwable throwable) {
          return Observable.error(asRetrofitException(throwable, call));
        }
      });
    }

    private RetrofitException asRetrofitException(Throwable throwable, Call call) {
      // We had non-200 http error
      if (throwable instanceof HttpException) {
        HttpException httpException = (HttpException) throwable;
        Response response = httpException.response();
        return RetrofitException.httpError(response.raw().request().url().toString(), call.request(), response, retrofit);
      }
      // A network error happened
      if (throwable instanceof IOException) {
        return RetrofitException.networkError((IOException) throwable);
      }

      // We don't know what happened. We need to simply convert to an unknown error

      return RetrofitException.unexpectedError(throwable);
    }
  }
}
