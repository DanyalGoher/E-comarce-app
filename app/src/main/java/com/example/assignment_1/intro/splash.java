package com.example.assignment_1.intro;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;
import com.example.assignment_1.R;
import com.example.assignment_1.databinding.ActivitySplashBinding;
import com.example.assignment_1.otherAtivities.home;
import java.util.Timer;
import java.util.TimerTask;

public class splash extends AppCompatActivity {
    private View decorView;
    Timer timer;
    VideoView Video;
    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Video = findViewById(R.id.Video);
        Video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.splash));
        Video.start();

        Video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0)
                    decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            }
        });


        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               openNewActivity();
            }
        }, 4000);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus){
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    }

    public void openNewActivity(){
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }

    @Override
    protected void onPostResume() {
        Video.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart() {
        Video.start();
        super.onRestart();
    }

    @Override
    protected void onPause() {
        Video.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Video.stopPlayback();
        super.onDestroy();
    }
}