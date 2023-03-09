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

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.ViewHolder> {

    Context context;

    ArrayList<PosterModel> recentlyModelArrayList;

    public VerticalAdapter(Context context, ArrayList<PosterModel> recentlyModelArrayList){
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
        holder.imgRecently_poster.setImageResource(recentlyModelArrayList.get(position).img);
        holder.txtRecently_title.setText(recentlyModelArrayList.get(position).title);
        holder.txtRecently_subTitle.setText(recentlyModelArrayList.get(position).subtitle);

    }

    @Override
    public int getItemCount() {
        return recentlyModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgRecently_poster;
        TextView txtRecently_title, txtRecently_subTitle;

        public ViewHolder (View itemView){
            super(itemView);

            imgRecently_poster = itemView.findViewById(R.id.imgRecently_poster);
            txtRecently_title = itemView.findViewById(R.id.txtRecently_title);
            txtRecently_subTitle = itemView.findViewById(R.id.txtRecently_subTitle);
        }
    }
}
