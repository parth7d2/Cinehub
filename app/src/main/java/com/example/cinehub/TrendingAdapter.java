package com.example.cinehub;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder> {

    Context context;

    ArrayList<PosterModel> trendingModelArrayList;

    public TrendingAdapter(Context context, ArrayList<PosterModel> trendingModelArrayList){
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
        holder.imgTrending_poster.setImageResource(trendingModelArrayList.get(position).img);
        holder.txtTrending_title.setText(trendingModelArrayList.get(position).title);
        holder.txtTrending_subTitle.setText(trendingModelArrayList.get(position).subtitle);
        holder.vv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(context, MovieActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return trendingModelArrayList.size();
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
