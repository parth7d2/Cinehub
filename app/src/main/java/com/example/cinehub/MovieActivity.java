package com.example.cinehub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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


        RelativeLayout rr_MoviePlay = findViewById(R.id.rr_MoviePlay);
        Button btn_WatchMovie = findViewById(R.id.btn_WatchMovie);

        ImageView imagePoster = findViewById(R.id.imgMoviePoster);
        TextView textTitle = findViewById(R.id.txtMovieTitle);
        TextView textSubTitle = findViewById(R.id.txtMovieSubTitle);
        TextView textDesc = findViewById(R.id.txtMovieDescription);

        if (getIntent().getExtras().getString("title") != null) {
            String imgPoster = getIntent().getExtras().getString("poster");
//            imagePoster.setImageResource(imgPoster);
            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w500" + imgPoster)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imagePoster);
            textTitle.setText(getIntent().getExtras().getString("title"));
            textSubTitle.setText(getIntent().getExtras().getString("subtitle"));
            textDesc.setText(getIntent().getExtras().getString("desc"));
        } else {
            String imgPoster = getIntent().getExtras().getString("posterV");
            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w500" + imgPoster)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imagePoster);
            textTitle.setText(getIntent().getExtras().getString("titleV"));
            textSubTitle.setText(getIntent().getExtras().getString("subtitleV"));
            textDesc.setText(getIntent().getExtras().getString("descV"));
        }

        Intent intent = new Intent(MovieActivity.this, PlayerAcivity.class);

        rr_MoviePlay.setOnClickListener(v -> new Handler().postDelayed(() -> startActivity(intent), 1000));

        btn_WatchMovie.setOnClickListener(v -> new Handler().postDelayed(() -> startActivity(intent), 1000));

        LinearLayout llback = findViewById(R.id.llback);
        llback.setOnClickListener(v -> onBackPressed());

    }
}