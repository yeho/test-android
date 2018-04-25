package com.yeho.movies.data.source.remote;

import java.util.concurrent.TimeUnit;

/**
 * Created by yeho on 24/04/18.
 */

public class ApiConfiguration {
  //Time out
  public static final int TIME_OUT = 15;
  public static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

  //Base URLs
  public static final String BASE_URL_PROD = "https://api.trakt.tv/shows/the-big-bang-theory/";
  public static final String BASE_URL_DEBUG = "https://api.trakt.tv/shows/the-big-bang-theory/";


  //API URLs
  public static final String URL_GET_SEASONS =  "seasons";
  public static final String URL_GET_RATING_BY_SEASON =  "seasons/{id}/ratings";

}