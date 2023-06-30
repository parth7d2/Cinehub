package com.example.cinehub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.material.slider.Slider;

public class PlayerAcivity extends AppCompatActivity {

    LinearLayout ll_unmute, ll_speed;

    Boolean isFullScreen = false;
    Boolean isLockScreen = false;

    Boolean isMute = false;

    int t = 1;

    ImageView bt_fullscreen;
    ImageView bt_lockscreen;

    ImageView img_Speaker_UnMute;

    TextView bright_no, txt_Mute_UnMute, txt_speed;

    ExoPlayer simpleExoPlayer;

    PlaybackParameters playbackParameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        // Hide the status bar and navigation bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
        // Keep the screen on
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


//********************************************* Find View *********************************************

        PlayerView playerView = findViewById(R.id.player);
        View playerControlView = playerView.findViewById(R.id.rl_custom_controller);
        ProgressBar progressBar = findViewById(R.id.prograssBar);
        bt_fullscreen = playerControlView.findViewById(R.id.bt_fullscreen);
        bt_lockscreen = playerControlView.findViewById(R.id.exo_lock);
        ll_unmute = playerControlView.findViewById(R.id.ll_Unmute);
        txt_Mute_UnMute = playerControlView.findViewById(R.id.txt_Mute_UnMute);
        img_Speaker_UnMute = playerControlView.findViewById(R.id.img_Speaker_UnMute);
        ll_speed = playerControlView.findViewById(R.id.ll_speed);
        txt_speed = playerControlView.findViewById(R.id.txt_speed);
        bright_no = playerControlView.findViewById(R.id.brt_number);
        LinearLayout llbackplayer = playerControlView.findViewById(R.id.llbackplayer);
        llbackplayer.setOnClickListener(v -> onBackPressed());

//********************************************* Video Path and Set Video Player *********************************************

//        String vPath = "android.resource://"+getPackageName()+"/raw/yellow_warble";
        String vPath = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4";
        Uri videoURI = Uri.parse(vPath);
        MediaItem mediaItem = MediaItem.fromUri(videoURI);
        simpleExoPlayer = new ExoPlayer.Builder(this)
                .setSeekBackIncrementMs(10000)
                .setSeekForwardIncrementMs(10000)
                .build();
        playerView.setPlayer(simpleExoPlayer);
        playerView.setKeepScreenOn(true);

        simpleExoPlayer.setMediaItem(mediaItem);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 1000);

//********************************************* Full Screen *********************************************

        if (getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
            bt_fullscreen.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.arrow_up_left_and_arrow_down_right_circle));
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            bt_fullscreen.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.arrow_down_right_and_arrow_up_left_circle__5_));
        }

        bt_fullscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
                    bt_fullscreen.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.arrow_down_right_and_arrow_up_left_circle__5_));
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
                } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    bt_fullscreen.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.arrow_up_left_and_arrow_down_right_circle));
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
                }
                isFullScreen = !isFullScreen;

            }
        });

//********************************************* Volume Mute/UnMute *********************************************

        simpleExoPlayer.setVolume(1);
        float volume = simpleExoPlayer.getVolume();
        if (volume == 0) {
            img_Speaker_UnMute.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.speaker_slash_fill__1_));
            txt_Mute_UnMute.setText(R.string.unmute);
        } else {
            img_Speaker_UnMute.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.speaker_wave_2_fill));
            txt_Mute_UnMute.setText(R.string.mute);
        }

        ll_unmute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isMute) {
                    img_Speaker_UnMute.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.speaker_slash_fill__1_));
                    txt_Mute_UnMute.setText(R.string.unmute);
                    simpleExoPlayer.setVolume(0);
                } else {
                    img_Speaker_UnMute.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.speaker_wave_2_fill));
                    txt_Mute_UnMute.setText(R.string.mute);
                    simpleExoPlayer.setVolume(volume);
                }
                isMute = !isMute;
            }
        });

//********************************************* Speed *********************************************

        ll_speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t == 1) {
                    playbackParameters = new PlaybackParameters(1.5f);
                    simpleExoPlayer.setPlaybackParameters(playbackParameters);
                    txt_speed.setText(R.string.speed1_5);
                    t = -1;
                } else if (t == -1) {
                    playbackParameters = new PlaybackParameters(0.5f);
                    simpleExoPlayer.setPlaybackParameters(playbackParameters);
                    txt_speed.setText(R.string.speed0_5);
                    t = 0;
                } else {
                    playbackParameters = PlaybackParameters.DEFAULT;
                    simpleExoPlayer.setPlaybackParameters(playbackParameters);
                    txt_speed.setText(R.string.speed1);
                    t = 1;
                }
            }
        });


//********************************************* Brightness Slider *********************************************

        Slider brightnessSlider = playerControlView.findViewById(R.id.brt_seekbar);
        brightnessSlider.setValueFrom(0f);
        brightnessSlider.setValueTo(300f);
        int currentBrightness = getCurrentBrightness();
        bright_no.setText((int) (currentBrightness / 300f * 100) + " ");
        brightnessSlider.setValue(currentBrightness);
        brightnessSlider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                Context context = getApplicationContext();
                boolean canWrite = Settings.System.canWrite(context);
                if (canWrite) {
                    setBrightness(getApplicationContext(), (int) value);

                } else {
                    Toast.makeText(context, "Enable write settings for brightness control", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                    intent.setData(Uri.parse("package:" + getPackageName()));
                    startActivityForResult(intent, 0);
                }
            }


        });

//********************************************* Lock / Unlock *********************************************

        bt_lockscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLockScreen) {
                    bt_lockscreen.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.lock));

                } else {
                    bt_lockscreen.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.lock_open__2_));
                }
                isLockScreen = !isLockScreen;
                lockScreen(isLockScreen);
            }
        });


//********************************************* ProgressBar *********************************************

        simpleExoPlayer.addListener(new Player.Listener() {
            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                Player.Listener.super.onPlayerStateChanged(playWhenReady, playbackState);
                if (playbackState == Player.STATE_BUFFERING) {
                    progressBar.setVisibility(View.VISIBLE);
                } else if (playbackState != Player.STATE_BUFFERING) {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

        simpleExoPlayer.prepare();
        simpleExoPlayer.play();


    }

    private void setBrightness(Context applicationContext, int value) {
        ContentResolver contentResolver = applicationContext.getContentResolver();
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, value);
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.screenBrightness = value / 300f;
        getWindow().setAttributes(layoutParams);
        float screenBrightnessNo = ((int) value / 300f * 100);
        bright_no.setText((int) screenBrightnessNo + " ");
    }

    private int getCurrentBrightness() {
        int currentBrightness = 0;
        try {
            currentBrightness = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return currentBrightness;
    }

    private void lockScreen(Boolean isLockScreen) {
        LinearLayout sec_mid = findViewById(R.id.sec_controlvid1);
        LinearLayout sec_bottom = findViewById(R.id.sec_controlvid2);
        RelativeLayout rl_slider = findViewById(R.id.rl_Slider);
        RelativeLayout rl_sliderElement = findViewById(R.id.rl_sliderElement);
        if (isLockScreen) {
            sec_mid.setVisibility(View.INVISIBLE);
            sec_bottom.setVisibility(View.INVISIBLE);
            rl_slider.setVisibility(View.INVISIBLE);
            rl_sliderElement.setVisibility(View.INVISIBLE);
        } else {
            sec_mid.setVisibility(View.VISIBLE);
            sec_bottom.setVisibility(View.VISIBLE);
            rl_slider.setVisibility(View.VISIBLE);
            rl_sliderElement.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        if (isLockScreen) return;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            bt_fullscreen.performClick();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        simpleExoPlayer.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        simpleExoPlayer.release();
    }

    @Override
    protected void onPause() {
        super.onPause();
        simpleExoPlayer.pause();
    }
}