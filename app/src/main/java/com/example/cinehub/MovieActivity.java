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
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class MovieActivity extends AppCompatActivity {


    boolean countlike = true;
    boolean countbookmark = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        View view = getWindow().getDecorView();
        view.setSystemUiVisibility(view.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


        RelativeLayout rr_MoviePlay = findViewById(R.id.rr_MoviePlay);
        Button btn_WatchMovie = findViewById(R.id.btn_WatchMovie);

        ImageView imagePoster = findViewById(R.id.imgMoviePoster);
        TextView textTitle = findViewById(R.id.txtMovieTitle);
        TextView textSubTitle = findViewById(R.id.txtMovieSubTitle);
        TextView textDesc = findViewById(R.id.txtMovieDescription);
        ImageView imgLike = findViewById(R.id.img_thumb_likes);
        TextView txtLike = findViewById(R.id.txt_thumb_likes);
        ImageView imgSave = findViewById(R.id.imgSaved);
        TextView txtSaved = findViewById(R.id.txtSaved);

        if (getIntent().getExtras().getString("title") != null) {
            String imgPoster = getIntent().getExtras().getString("poster");
//            imagePoster.setImageResource(imgPoster);
            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w500" + imgPoster)
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.progress_animation)
                    .into(imagePoster);
            textTitle.setText(getIntent().getExtras().getString("title"));
            textSubTitle.setText("Release Date:  " + getIntent().getExtras().getString("subtitle") + "\n\nRate:  " + getIntent().getExtras().getString("rate"));
            textDesc.setText(getIntent().getExtras().getString("desc"));
        } else {
            String imgPoster = getIntent().getExtras().getString("posterV");
            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w500" + imgPoster)
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.progress_animation)
                    .into(imagePoster);
            textTitle.setText(getIntent().getExtras().getString("titleV"));
            textSubTitle.setText("Release Date:  " +  getIntent().getExtras().getString("subtitleV") + "\n\nRate:  " + getIntent().getExtras().getString("rateV"));
            textDesc.setText(getIntent().getExtras().getString("descV"));
        }


        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent intent = new Intent(MovieActivity.this, PlayerAcivity.class);

        rr_MoviePlay.setOnClickListener(v -> new Handler().postDelayed(() -> startActivity(intent), 1000));

        btn_WatchMovie.setOnClickListener(v -> new Handler().postDelayed(() -> startActivity(intent), 1000));

        LinearLayout llback = findViewById(R.id.llback);
        llback.setOnClickListener(v -> onBackPressed());

        imgLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(countlike) {
                    imgLike.setImageResource(R.drawable.hand_thumbsup_fill);
                    txtLike.setText(R.string.liked);
                    countlike = false;
                }
                else {
                    imgLike.setImageResource(R.drawable.like_thumb);
                    txtLike.setText(R.string.like);
                    countlike = true;
                }

            }
        });

        imgSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(countbookmark){
                    imgSave.setImageResource(R.drawable.bookmark_fill);
                    txtSaved.setText(R.string.saved);
                    Toast.makeText(MovieActivity.this, "Added to saved", Toast.LENGTH_SHORT).show();
                    countbookmark = false;
                }
                else{
                    imgSave.setImageResource(R.drawable.bookmark);
                    txtSaved.setText(R.string.save);
                    countbookmark = true;
                }
            }
        });

    }
}