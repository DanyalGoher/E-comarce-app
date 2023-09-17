package com.example.assignment_1.otherAtivities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import com.example.assignment_1.R;
import com.example.assignment_1.database.LoginActivity;
import com.example.assignment_1.database.SignupActivity;
import com.example.assignment_1.databinding.ActivityMobileNumberBinding;
import com.example.assignment_1.databinding.ActivityOrderDoneBinding;

public class orderDone extends AppCompatActivity {

    ActivityOrderDoneBinding binding;
    VideoView Video;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderDoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String phoneNumber = getIntent().getStringExtra("phoneNumber");
        binding.number.setText(phoneNumber);

        binding.home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(orderDone.this, home.class);
                startActivity(intent);
            }
        });

        Video = findViewById(R.id.videoView);
        Video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.orderdone));
        Video.start();
        Video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });


    }
}