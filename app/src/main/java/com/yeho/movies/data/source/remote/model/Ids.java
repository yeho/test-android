package com.yeho.movies.data.source.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yeho on 24/04/18.
 */

public class Ids {

  @SerializedName("trakt") private int trakt;

  @SerializedName("tvdb") private int tvdb;

  @SerializedName("imdb") private String imdb;

  @SerializedName("tmdb") private int tmdb;

  @SerializedName("tvrage") private int tvrage;

  public Ids(Integer trakt, Integer tvdb, String imdb, Integer tmdb, Integer tvrage) {
    this.trakt = trakt;
    this.tvdb = tvdb;
    this.imdb = imdb;
    this.tmdb = tmdb;
    this.tvrage = tvrage;
  }

  public int getTvrage() {
    return this.tvrage;
  }

  public void setTvrage(int tvrage) {
    this.tvrage = tvrage;
  }

  public int getTmdb() {
    return this.tmdb;
  }

  public void setTmdb(int tmdb) {
    this.tmdb = tmdb;
  }

  public String getImdb() {
    return this.imdb;
  }

  public void setImdb(String imdb) {
    this.imdb = imdb;
  }

  public int getTvdb() {
    return this.tvdb;
  }

  public void setTvdb(int tvdb) {
    this.tvdb = tvdb;
  }

  public int getTrakt() {
    return this.trakt;
  }

  public void setTrakt(int trakt) {
    this.trakt = trakt;
  }
}
