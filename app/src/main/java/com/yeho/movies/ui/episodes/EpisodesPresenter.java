package com.yeho.movies.ui.episodes;

import com.yeho.movies.data.UserData;
import com.yeho.movies.data.source.remote.model.Episode;
import com.yeho.movies.data.source.remote.model.Season;
import com.yeho.movies.model.EpisodesModel;
import java.util.Arrays;
import java.util.List;

/**
 * @author yeho
 * fecha: 24/04/2018
 */

public class EpisodesPresenter implements EpisodesContractor.EpisodesPresenter<EpisodesContractor.EpisodesView> {

  private EpisodesContractor.EpisodesView EpisodesView;
  private EpisodesContractor.EpisodesModel model;

  @Override public void attachView(EpisodesContractor.EpisodesView view) {
    this.EpisodesView = view;
    model = new EpisodesModel(this);
  }

  @Override public void detachView() {
    EpisodesView = null;
  }

  @Override public void showEpisodes(long seasonNumber) {
    List<Episode> episodesList = null;
    List<Season> seasonList = UserData.getInstance().getSeasonList();

    for (int i = 0; i < seasonList.size(); i++) {
      if (seasonNumber == seasonList.get(i).getNumber()) {
        episodesList = Arrays.asList(seasonList.get(i).getEpisodes());
        break;
      }
    }

    EpisodesView.updateUI(episodesList);
  }
}
