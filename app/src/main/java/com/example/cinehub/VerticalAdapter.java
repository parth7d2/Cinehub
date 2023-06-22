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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.ViewHolder> {

    Context context;

    ArrayList<MovieModel> recentlyModelArrayList;

    public VerticalAdapter(Context context, ArrayList<MovieModel> recentlyModelArrayList){
        this.context = context;
        this.recentlyModelArrayList = recentlyModelArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vertical_home_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load("https://image.tmdb.org/t/p/w500/" + recentlyModelArrayList.get(position).getPoster_path()).into(holder.imgRecently_poster);
        holder.txtRecently_title.setText(recentlyModelArrayList.get(position).getOriginal_title());
        holder.txtRecently_subTitle.setText(recentlyModelArrayList.get(position).getRelease_date() + " " + String.valueOf(recentlyModelArrayList.get(position).getVote_average()));

        holder.vv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMovie = new Intent(context, MovieActivity.class);
                intentMovie.putExtra("posterV", recentlyModelArrayList.get(position).getPoster_path());
                intentMovie.putExtra("titleV", recentlyModelArrayList.get(position).getOriginal_title());
                intentMovie.putExtra("subtitleV", recentlyModelArrayList.get(position).getRelease_date() + " " + String.valueOf(recentlyModelArrayList.get(position).getVote_average()));
                intentMovie.putExtra("descV", recentlyModelArrayList.get(position).getOverview());
                v.getContext().startActivity(intentMovie);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recentlyModelArrayList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgRecently_poster;
        TextView txtRecently_title, txtRecently_subTitle;

        View vv;

        public ViewHolder (View itemView){
            super(itemView);

            imgRecently_poster = itemView.findViewById(R.id.imgRecently_poster);
            txtRecently_title = itemView.findViewById(R.id.txtRecently_title);
            txtRecently_subTitle = itemView.findViewById(R.id.txtRecently_subTitle);
            vv = itemView;
        }
    }
}
