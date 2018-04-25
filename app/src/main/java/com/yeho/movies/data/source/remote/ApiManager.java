package com.yeho.movies.data.source.remote;

import com.yeho.movies.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author yeho
 * fecha: 24/04/2018
 * Useful class for handling the Retrofit connections. With this class we can do:
 * - Custom logs.
 * - Custom connection, read and write time outs.
 * - Change the base URL (for different languages).
 */

public class ApiManager {
  private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder().connectTimeout(ApiConfiguration.TIME_OUT, ApiConfiguration.TIME_UNIT)
      .readTimeout(ApiConfiguration.TIME_OUT, ApiConfiguration.TIME_UNIT)
      .writeTimeout(ApiConfiguration.TIME_OUT, ApiConfiguration.TIME_UNIT)
      .addInterceptor(getLogs());
  private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(ApiConfiguration.BASE_URL_DEBUG).addConverterFactory(GsonConverterFactory.create());

  private static HttpLoggingInterceptor getLogs() {
    if (BuildConfig.DEBUG) {
      return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    } else {
      return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE);
    }
  }

  public static <S> S createService(Class<S> serviceClass) {
    return builder.client(httpClient.build()).build().create(serviceClass);
  }
}