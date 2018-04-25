package com.yeho.movies.data.source.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yeho on 24/04/18.
 */

public class Episode {

  @SerializedName("season") public final long season;

  @SerializedName("number") public final long number;

  @SerializedName("title") public final String title;

  @SerializedName("ids") public final Ids ids;

  public Episode(long season, long number, String title, Ids ids) {
    this.season = season;
    this.number = number;
    this.title = title;
    this.ids = ids;
  }

  public long getSeason() {
    return season;
  }

  public long getNumber() {
    return number;
  }

  public String getTitle() {
    return title;
  }

  public Ids getIds() {
    return ids;
  }
}

