package com.yeho.movies.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.yeho.movies.R;
import com.yeho.movies.data.source.remote.model.Episode;
import java.util.List;

/**
 * Created by yeho on 24/04/18.
 */

public class RvEpisodesAdapter extends RecyclerView.Adapter<RvEpisodesAdapter.SeasonViewHolder> {

  Context context;
  private List<Episode> episodeList;

  public RvEpisodesAdapter(Context context) {
    this.context = context;
  }

  @Override public SeasonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_episode, parent, false);
    SeasonViewHolder pvh = new SeasonViewHolder(v);
    return pvh;
  }

  @Override public void onBindViewHolder(SeasonViewHolder holder, final int position) {
    holder.tvEpisodeNumber.setText(String.valueOf("E" +episodeList.get(position).getNumber() ));
    holder.tvEpisodeName.setText(String.valueOf(episodeList.get(position).getTitle()));
  }

  @Override public int getItemCount() {
    if (null == episodeList) return 0;
    return episodeList.size();
  }

  @Override public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
  }

  @Override public long getItemId(int position) {
    return position;
  }

  @Override public int getItemViewType(int position) {
    return position;
  }

  public void setEpisodesData(List<Episode> episodeList) {
    this.episodeList = episodeList;
    notifyDataSetChanged();
  }

  public class SeasonViewHolder extends RecyclerView.ViewHolder {
    TextView tvEpisodeNumber;
    TextView tvEpisodeName;

    SeasonViewHolder(View itemView) {
      super(itemView);
      tvEpisodeNumber = itemView.findViewById(R.id.tvEpisodeNumber);
      tvEpisodeName = itemView.findViewById(R.id.tvEpisodeName);
    }
  }
}


