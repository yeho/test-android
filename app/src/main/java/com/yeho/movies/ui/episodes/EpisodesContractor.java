package com.yeho.movies.ui.episodes;

import com.yeho.movies.common.MvpPresenter;
import com.yeho.movies.common.MvpView;
import com.yeho.movies.data.source.remote.model.Episode;
import java.util.List;

/**
 * @author yeho
 *      fecha: 24/04/2018
 */

public interface EpisodesContractor {

    interface EpisodesPresenter<View> extends MvpPresenter<View> {
      void showEpisodes(long seasonNumber);

    }

    interface EpisodesView extends MvpView {
      void updateUI(List<Episode> episodesList);
    }

    interface EpisodesModel {
    }


}
