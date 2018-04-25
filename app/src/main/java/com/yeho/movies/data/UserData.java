package com.yeho.movies.data;

import com.yeho.movies.data.source.remote.model.Season;
import java.util.List;

/**
 * Created by yeho on 21/03/16.
 */
public class UserData {

    private static UserData instance;
    private List<Season> seasonList;

    private UserData() {
    }

    public static synchronized UserData getInstance() {
        if (instance == null) {
            instance = new UserData();
        }
        return instance;
    }

    public UserData getNewInstance() {
        instance = null;
        instance = new UserData();
        return instance;
    }

  public void clearInstance() {
    instance = null;
  }

  public List<Season> getSeasonList() {
    return seasonList;
  }

  public void setSeasonList(List<Season> seasonList) {
    this.seasonList = seasonList;
  }
}
