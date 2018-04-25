package com.yeho.movies.model;

import com.yeho.movies.data.Constants;
import com.yeho.movies.data.UserData;
import com.yeho.movies.data.source.remote.ApiClient;
import com.yeho.movies.data.source.remote.ApiManager;
import com.yeho.movies.data.source.remote.model.Rating;
import com.yeho.movies.data.source.remote.model.Season;
import com.yeho.movies.ui.seasons.SeasonsContractor;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author yeho
 * fecha: 24/04/2018
 */

public class SeasonsModel implements SeasonsContractor.SeasonsModel {

  private static final String TAG = "SeasonsModel";
  private SeasonsContractor.SeasonsPresenter presenter;

  public SeasonsModel(SeasonsContractor.SeasonsPresenter presenter) {
    this.presenter = presenter;
  }

  @Override public void getSeasons() {
    ApiClient service = ApiManager.createService(ApiClient.class);
    Call<List<Season>> call = service.getSeasons(Constants.API_KEY, Constants.PAGE_NUMBER, Constants.LIMIT_NUMBER, Constants.EPISODES);
    call.enqueue(new Callback<List<Season>>() {
      @Override public void onResponse(Call<List<Season>> call, Response<List<Season>> response) {

        UserData.getInstance().setSeasonList(response.body());
        callRatings();
        presenter.updateUI();
      }

      @Override public void onFailure(Call<List<Season>> call, Throwable t) {
        presenter.showMessage("Something went wrong...Please try later!");
      }
    });
  }

  @Override public void callRatings() {

    ApiClient service = ApiManager.createService(ApiClient.class);
    String id = null;
    for (int i = 0; i < UserData.getInstance().getSeasonList().size(); i++) {
      id = String.valueOf(UserData.getInstance().getSeasonList().get(i).getNumber());

      Call<Rating> call = service.getRatingBySeason(Constants.API_KEY, id);
      final String finalId = id;
      call.enqueue(new Callback<Rating>() {
        @Override public void onResponse(Call<Rating> call, Response<Rating> response) {

          Rating rating = response.body();
          UserData.getInstance().getSeasonList().get(Integer.parseInt(finalId)).setRating(rating);
          presenter.updateUI();
        }

        @Override public void onFailure(Call<Rating> call, Throwable t) {
          presenter.showMessage("Something went wrong...Please try later!");
        }
      });
    }
  }
}
