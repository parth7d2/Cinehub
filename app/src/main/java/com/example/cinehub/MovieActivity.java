package com.example.cinehub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


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

        if(getIntent().getExtras().getString("title")!= null) {
            int imgPoster = getIntent().getIntExtra("poster", R.drawable.ic_launcher_background);
            imagePoster.setImageResource(imgPoster);
            textTitle.setText(getIntent().getExtras().getString("title"));
            textSubTitle.setText(getIntent().getExtras().getString("subtitle"));
        }

        else{
            int imgPoster = getIntent().getIntExtra("posterV", R.drawable.ic_launcher_background);
            imagePoster.setImageResource(imgPoster);
            textTitle.setText(getIntent().getExtras().getString("titleV"));
            textSubTitle.setText(getIntent().getExtras().getString("subtitleV"));
        }
    }
}