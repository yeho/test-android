package com.yeho.movies.ui.seasons;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.yeho.movies.R;
import com.yeho.movies.adapters.RvSeasonsAdapter;
import com.yeho.movies.data.UserData;
import com.yeho.movies.data.source.remote.model.Season;
import com.yeho.movies.ui.BaseFragment;
import com.yeho.movies.ui.MainActivity;
import com.yeho.movies.utils.Utils;

/**
 * @author yeho
 * fecha: 24/04/2018
 */

public class SeasonsFragment extends BaseFragment<SeasonsContractor.SeasonsPresenter>
    implements SeasonsContractor.SeasonsView, View.OnClickListener, RvSeasonsAdapter.SeasonsAdapterOnClickHandler {

  private final String LOG_TAG = "SeasonsFragment";
  Context context;
  AlertDialog alertDialog;
  private RvSeasonsAdapter adapter;
  private RecyclerView rvSeasons;
  private GridLayoutManager mGridLayoutManager;

  public static SeasonsFragment newInstance() {
    return new SeasonsFragment();
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.seasons_fragment, container, false);

    context = getActivity().getApplicationContext();

    rvSeasons = rootView.findViewById(R.id.rvSeasons);
    return rootView;
  }

  private void checkInternetConnection() {
    if (Utils.isNetworkAvailable(context)) {
      showMessage(getActivity().getString(R.string.loading));
    } else {
      Utils.showDialogOK(getActivity(), getActivity().getString(R.string.app_name), getActivity().getString(R.string.no_internet));
    }
  }

  @Override public void updateUI() {
    if (alertDialog != null) alertDialog.dismiss();
    mGridLayoutManager = new GridLayoutManager(getActivity(), 2);
    adapter = new RvSeasonsAdapter(this, context);
    RecyclerView.LayoutManager layoutManager = mGridLayoutManager;
    rvSeasons.setLayoutManager(layoutManager);
    adapter.setSeasonsData(UserData.getInstance().getSeasonList());
    rvSeasons.setAdapter(adapter);
  }

  @Override public void showMessage(String messageToShow) {
    Toast.makeText(context, messageToShow, Toast.LENGTH_LONG).show();
  }

  @Override public void onResume() {
    super.onResume();
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    if (mPresenter == null) mPresenter = new SeasonsPresenter();
    super.onViewCreated(view, savedInstanceState);
    checkInternetConnection();
    mPresenter.getSeasons();
  }

  public void muestraDialogoGettingData(boolean isVisible) {
    if (isVisible) {
      getActivity().runOnUiThread(new Runnable() {
        @Override public void run() {
          alertDialog.show();
        }
      });
    } else {
      getActivity().runOnUiThread(new Runnable() {
        @Override public void run() {
          alertDialog.dismiss();
        }
      });
    }
  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }

  @Override public void onClick(View view) {
    Log.wtf("YEHO", "onclick");
  }

  @Override public void setProgressIndicator(boolean active) {

  }

  @Override public void onClick(Season season) {
    openStockFragment(season.number);
  }

  private void openStockFragment(long number) {
    ((MainActivity) getActivity()).showEpisodesFragment(number);
  }
}


