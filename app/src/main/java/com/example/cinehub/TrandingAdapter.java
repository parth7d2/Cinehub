package com.example.cinehub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrandingAdapter extends RecyclerView.Adapter<TrandingAdapter.ViewHolder> {

    Context context;

    ArrayList<TrandingModel> trandingModelArrayList;

    public TrandingAdapter(Context context, ArrayList<TrandingModel> trandingModelArrayList){
        this.context = context;
        this.trandingModelArrayList = trandingModelArrayList;
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
        holder.trending_poster.setImageResource(trandingModelArrayList.get(position).img);
        holder.trending_title.setText(trandingModelArrayList.get(position).title);
        holder.trending_subTitle.setText(trandingModelArrayList.get(position).subtitle);
    }

    @Override
    public int getItemCount() {
        return trandingModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView trending_title, trending_subTitle;
        ImageView trending_poster;

        public ViewHolder(View itemView){
            super(itemView);
            trending_poster = itemView.findViewById(R.id.trending_poster);
            trending_title = itemView.findViewById(R.id.trending_title);
            trending_subTitle = itemView.findViewById(R.id.trending_subTitle);
        }
    }
}
