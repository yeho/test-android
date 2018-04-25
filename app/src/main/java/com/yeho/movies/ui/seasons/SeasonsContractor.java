package com.yeho.movies.ui.seasons;

import com.yeho.movies.common.MvpPresenter;
import com.yeho.movies.common.MvpView;

/**
 * @author yeho
 *      fecha: 24/04/2018
 */

public interface SeasonsContractor {

    interface SeasonsPresenter<View> extends MvpPresenter<View> {
      void getSeasons();
      void updateUI();
      void showMessage(String messageToShow);
    }

    interface SeasonsView extends MvpView {

      void updateUI();
      void showMessage(String messageToShow);
    }

    interface SeasonsModel {
      void getSeasons();
      void callRatings();
    }


}
