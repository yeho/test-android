package com.yeho.movies.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.yeho.movies.R;
import com.yeho.movies.data.Constants;
import com.yeho.movies.ui.episodes.EpisodesFragment;
import com.yeho.movies.ui.seasons.SeasonsFragment;

public class MainActivity extends AppCompatActivity{


  SeasonsFragment seasonsFragment = null;
  EpisodesFragment episodesFragment = null;
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    showSeasonsFragment();
  }

  private void showSeasonsFragment() {
    seasonsFragment = new SeasonsFragment();
    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.replace(R.id.content, seasonsFragment, "Seasons Fragment");
    transaction.commit();
  }

  public void showEpisodesFragment(long season) {

    Bundle bundle = new Bundle();
    bundle.putLong(Constants.SEASON, season);
    episodesFragment = new EpisodesFragment();
    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    episodesFragment.setArguments(bundle);
    transaction.add(R.id.content, episodesFragment, "Episodes Fragment").addToBackStack(null);
    transaction.commit();

  }

  @Override
  public void onBackPressed(){
    FragmentManager fm = getFragmentManager();
    if (fm.getBackStackEntryCount() > 0) {
      fm.popBackStack();
    } else {
      super.onBackPressed();
    }
  }



}
