package com.yeho.movies.data.source.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yeho on 24/04/18.
 */

public class Rating {

  @SerializedName("rating") private double rating;

  public double getRating() {
    return this.rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }
}

