package com.example.cinehub;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder> {

    Context context;

    ArrayList<MovieModel> trendingModelArrayList;

    public TrendingAdapter(Context context, ArrayList<MovieModel> trendingModelArrayList){
        this.context = context;
        this.trendingModelArrayList = trendingModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.trending_home_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.imgTrending_poster.setImageResource(trendingModelArrayList.get(position).img);
//        holder.txtTrending_title.setText(trendingModelArrayList.get(position).title);
//        holder.txtTrending_subTitle.setText(trendingModelArrayList.get(position).subtitle);

        holder.txtTrending_title.setText(trendingModelArrayList.get(position).getOriginal_title());
//        holder.txt_SubTitleMovie.setText(trendingModelArrayList.get(position).getOverview());
        Picasso.get().load("https://image.tmdb.org/t/p/w500/" + trendingModelArrayList.get(position).getPoster_path()).into(holder.imgTrending_poster);
        holder.txtTrending_subTitle.setText(trendingModelArrayList.get(position).getRelease_date() + " " + String.valueOf(trendingModelArrayList.get(position).getVote_average()));
        holder.vv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent movieIntent = new Intent(context, MovieActivity.class);
                movieIntent.putExtra("poster", trendingModelArrayList.get(position).getPoster_path());
                movieIntent.putExtra("title", trendingModelArrayList.get(position).getOriginal_title());
                movieIntent.putExtra("subtitle", trendingModelArrayList.get(position).getRelease_date() + " " + String.valueOf(trendingModelArrayList.get(position).getVote_average()));
                movieIntent.putExtra("desc", trendingModelArrayList.get(position).getOverview());
                v.getContext().startActivity(movieIntent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return trendingModelArrayList.size();
//        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTrending_title, txtTrending_subTitle;
        ImageView imgTrending_poster;

        View vv;

        public ViewHolder(View itemView){
            super(itemView);
            imgTrending_poster = itemView.findViewById(R.id.imgTrending_poster);
            txtTrending_title = itemView.findViewById(R.id.txtTrending_title);
            txtTrending_subTitle = itemView.findViewById(R.id.txtTrending_subTitle);
            vv = itemView;
        }
    }
}
