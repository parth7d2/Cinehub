package com.example.cinehub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class MovieActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        View view = getWindow().getDecorView();
        view.setSystemUiVisibility(view.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        LinearLayout llback = findViewById(R.id.llback);
        llback.setOnClickListener(v -> onBackPressed());

        ImageView imagePoster = findViewById(R.id.imgMoviePoster);
        TextView textTitle = findViewById(R.id.txtMovieTitle);
        TextView textSubTitle = findViewById(R.id.txtMovieSubTitle);
        TextView textDesc = findViewById(R.id.txtMovieDescription);

        if(getIntent().getExtras().getString("title")!= null) {
            String imgPoster = getIntent().getExtras().getString("poster");
//            imagePoster.setImageResource(imgPoster);
            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w500" +imgPoster)
                    .placeholder( R.drawable.ic_launcher_background)
                    .into(imagePoster);
            textTitle.setText(getIntent().getExtras().getString("title"));
            textSubTitle.setText(getIntent().getExtras().getString("subtitle"));
            textDesc.setText(getIntent().getExtras().getString("desc"));
        }
        else{
            String imgPoster = getIntent().getExtras().getString("posterV");
            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w500" +imgPoster)
                    .placeholder( R.drawable.ic_launcher_background)
                    .into(imagePoster);
            textTitle.setText(getIntent().getExtras().getString("titleV"));
            textSubTitle.setText(getIntent().getExtras().getString("subtitleV"));
            textDesc.setText(getIntent().getExtras().getString("descV"));
        }
    }
}