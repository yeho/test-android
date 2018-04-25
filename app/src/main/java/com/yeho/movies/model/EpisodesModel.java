package com.yeho.movies.model;

import com.yeho.movies.ui.episodes.EpisodesContractor;

/**
 * Created by yeho on 24/04/18.
 */

public class EpisodesModel implements EpisodesContractor.EpisodesModel {

  private static final String TAG = "SeasonsModel";
  private EpisodesContractor.EpisodesPresenter presenter;

  public EpisodesModel(EpisodesContractor.EpisodesPresenter presenter) {
    this.presenter = presenter;
  }

}
