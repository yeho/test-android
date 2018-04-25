package com.yeho.movies.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.yeho.movies.R;
import com.yeho.movies.data.source.remote.model.Season;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yeho on 24/04/18.
 */

public class RvSeasonsAdapter extends RecyclerView.Adapter<RvSeasonsAdapter.SeasonViewHolder> {

  private final SeasonsAdapterOnClickHandler mClickHandler;
  Context context;
  ;
  private List<Season> seasons;
  private HashMap<Integer, Integer> episodesBySeason = new java.util.HashMap<>();

  public RvSeasonsAdapter(SeasonsAdapterOnClickHandler mClickHandler, Context context) {
    this.mClickHandler = mClickHandler;
    this.context = context;
  }

  @Override public SeasonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_season, parent, false);
    SeasonViewHolder pvh = new SeasonViewHolder(v);
    return pvh;
  }

  @Override public void onBindViewHolder(SeasonViewHolder holder, final int position) {
    holder.tvSeasonTitle.setText("Season: " + String.valueOf(seasons.get(position).getNumber()));
    holder.tvEpisodeNumber.setText(String.valueOf(seasons.get(position).getEpisodes().length));
    if (seasons.get(position).getRating() != null) {
      holder.tvRating.setText(String.valueOf(new DecimalFormat("#.##").format(seasons.get(position).getRating().getRating())));
    }
  }

  @Override public int getItemCount() {
    if (null == seasons) return 0;
    return seasons.size();
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

  //public void setSeasonsData(List<Season> seasons, HashMap<Integer, Integer> episodesBySeason) {
  public void setSeasonsData(List<Season> seasons) {
    this.seasons = seasons;
    //    this.episodesBySeason = episodesBySeason;
    notifyDataSetChanged();
  }

  public interface SeasonsAdapterOnClickHandler {
    void onClick(Season season);
  }

  public class SeasonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView tvRating;
    TextView tvEpisodeNumber;
    TextView tvSeasonTitle;
    private ImageView ivSeasonPicture;

    SeasonViewHolder(View itemView) {
      super(itemView);
      tvRating = itemView.findViewById(R.id.tvRating);
      tvEpisodeNumber = itemView.findViewById(R.id.tvEpisodeNumber);
      tvSeasonTitle = itemView.findViewById(R.id.tvSeasonTitle);
      ivSeasonPicture = itemView.findViewById(R.id.ivSeasonPicture);

      itemView.setOnClickListener(this);
    }

    @Override public void onClick(View view) {
      int adapterPosition = getAdapterPosition();
      Season seasonClicked = seasons.get(adapterPosition);
      mClickHandler.onClick(seasonClicked);
    }
  }
}


