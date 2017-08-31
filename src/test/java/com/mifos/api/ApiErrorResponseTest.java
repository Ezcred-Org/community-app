package com.mifos.api;

import com.google.gson.Gson;
import com.mifos.objects.ApiErrorResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ApiErrorResponseTest {

  private  Gson gson;
  private static final String API_ERROR_JSON = "{\"developerMessage\":\"Invalid authentication details were passed in api request.\",\"httpStatusCode\":\"401\",\"defaultUserMessage\":\"Unauthenticated. Please login.\",\"userMessageGlobalisationCode\":\"error.msg.not.authenticated\",\"errors\":[]}";
  private static final String API_ERROR_JSON2 = "{\"errors\":[\"username is mandatory\", \"password is mandatory\"]}";
  @Before
  public void setUp() throws Exception {
    gson = new Gson();
  }

  @Test
  public void testParse() throws Exception {
    ApiErrorResponse apiErrorResponse = gson.fromJson(API_ERROR_JSON, ApiErrorResponse.class);
    Assert.assertNotNull(apiErrorResponse);
  }

  @Test
  public void testParseErrors() throws Exception {
    ApiErrorResponse apiErrorResponse = gson.fromJson(API_ERROR_JSON2, ApiErrorResponse.class);
    Assert.assertNotNull(apiErrorResponse);
  }
}