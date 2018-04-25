package com.yeho.movies.ui.episodes;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.yeho.movies.R;
import com.yeho.movies.adapters.RvEpisodesAdapter;
import com.yeho.movies.data.Constants;
import com.yeho.movies.data.source.remote.model.Episode;
import com.yeho.movies.ui.BaseFragment;
import java.util.List;

/**
 * @author yeho
 * fecha: 24/04/2018
 */

public class EpisodesFragment extends BaseFragment<EpisodesContractor.EpisodesPresenter> implements EpisodesContractor.EpisodesView, View.OnClickListener {

  private final String LOG_TAG = "EpisodesFragment";
  Context context;
  long seasonNumber = 0;
  private RecyclerView rvEpisodes;
  private RvEpisodesAdapter adapter;

  public static EpisodesFragment newInstance() {
    return new EpisodesFragment();
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.episodes_fragment, container, false);

    context = getActivity().getApplicationContext();

    seasonNumber = getArguments().getLong(Constants.SEASON);

    rvEpisodes = rootView.findViewById(R.id.rvEpisodes);

    return rootView;
  }

  @Override public void updateUI(List<Episode> episodesList) {
    adapter = new RvEpisodesAdapter(context);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
    rvEpisodes.setLayoutManager(layoutManager);
    adapter.setEpisodesData(episodesList);
    rvEpisodes.setAdapter(adapter);
  }

  @Override public void onResume() {
    super.onResume();
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    if (mPresenter == null) mPresenter = new EpisodesPresenter();
    super.onViewCreated(view, savedInstanceState);
    mPresenter.showEpisodes(seasonNumber);
  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }

  @Override public void onClick(View view) {
    Log.wtf("YEHO", "onclick");
  }

  @Override public void setProgressIndicator(boolean active) {

  }
}


