package com.yeho.movies.ui.seasons;

import com.yeho.movies.model.SeasonsModel;

/**
 * @author yeho
 *      fecha: 24/04/2018
 */

public class SeasonsPresenter implements SeasonsContractor.SeasonsPresenter<SeasonsContractor.SeasonsView> {

    private SeasonsContractor.SeasonsView seasonsView;
    private SeasonsContractor.SeasonsModel model;


    @Override public void attachView(SeasonsContractor.SeasonsView view) {
        this.seasonsView =view;
        model = new SeasonsModel(this);
    }

    @Override
    public void detachView() {
        seasonsView = null;
    }



  @Override public void getSeasons() {
      model.getSeasons();

  }

  @Override public void updateUI() {
    seasonsView.updateUI();
  }

  @Override public void showMessage(String messageToShow) {
    seasonsView.showMessage(messageToShow);
  }
}
