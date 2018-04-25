package com.yeho.movies.data.source.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yeho on 24/04/18.
 */

public class Season {

  @SerializedName("number") public final long number;

  @SerializedName("ids") public final Ids ids;

  @SerializedName("episodes") public final Episode episodes[];

  @SerializedName("rating") public Rating rating;

  public Season(long number, Ids ids, Episode[] episodes, Rating rating) {
    this.number = number;
    this.ids = ids;
    this.episodes = episodes;
    this.rating = rating;
  }

  public long getNumber() {
    return number;
  }

  public Ids getIds() {
    return ids;
  }

  public Episode[] getEpisodes() {
    return episodes;
  }

  public Rating getRating() {
    return rating;
  }

  public void setRating(Rating rating) {
    this.rating = rating;
  }
}
