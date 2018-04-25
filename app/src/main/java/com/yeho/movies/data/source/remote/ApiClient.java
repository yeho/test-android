package com.yeho.movies.data.source.remote;

import com.yeho.movies.data.Constants;
import com.yeho.movies.data.source.remote.model.Rating;
import com.yeho.movies.data.source.remote.model.Season;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author yeho
 * fecha: 24/04/2018
 * Interface which contains the whole API connections.
 */

public interface ApiClient {

  /**
   * Get Seasons
   */
  @Headers({
      "Content-Type: application/json", "trakt-api-version: 2"
  }) @GET(ApiConfiguration.URL_GET_SEASONS) Call<List<Season>> getSeasons(@Header("trakt-api-key") String APIKey, @Query(Constants.PAGE) String page,
      @Query(Constants.LIMIT) String limit, @Query(Constants.EXTENDED) String extended);

  /**
   * Get Rating By Seasons
   */
  @Headers({
      "Content-Type: application/json", "trakt-api-version: 2"
  }) @GET(ApiConfiguration.URL_GET_RATING_BY_SEASON) Call<Rating> getRatingBySeason(@Header("trakt-api-key") String APIKey, @Path("id") String id);
}