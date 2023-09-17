package com.example.assignment_1.otherAtivities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.VideoView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.assignment_1.R;
import com.example.assignment_1.bag.bag;
import com.example.assignment_1.bag.bag2;
import com.example.assignment_1.database.LoginActivity;
import com.example.assignment_1.databinding.ActivityHomeBinding;
import com.example.assignment_1.find.MainActivity;

import java.util.ArrayList;

public class home extends AppCompatActivity {

    VideoView Video;
    ActivityHomeBinding binding;
    ImageButton optionsMenu;
    ImageButton Cart;
    ImageButton search;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       //...............VideoView................//

        Video = findViewById(R.id.VideoView);
        Video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.ad3));
        Video.start();
        Video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        //...............VideoView End................//

        binding.saler1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProduct();
            }
        });

        Cart = (ImageButton)findViewById(R.id.Cart);
        Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCart();
            }
        });

        search = (ImageButton)findViewById(R.id.Search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSearch();
            }
        });

        binding.indoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openindoor();
            }
        });

        //.............Create an instance of ImageSlider............//

        ImageSlider imageSlider = findViewById(R.id.image_slider);

        //..........Create a list to hold the SlideModel objects.................//

        ArrayList<SlideModel> imageList = new ArrayList<>();

        //..........Add SlideModel objects to the imageList...........//

        imageList.add(new SlideModel("https://tse2.mm.bing.net/th?id=OIP.bu0FU4BJmZn2VneL1egfqQHaC0&pid=Api&P=0&h=180", ScaleTypes.FIT)); // for one image
        imageList.add(new SlideModel("https://tse4.mm.bing.net/th?id=OIP._njBVoXk8cjBIlCblBz1zQHaDd&pid=Api&P=0&h=180", ScaleTypes.FIT)); // you can include title
        imageList.add(new SlideModel("https://tse4.mm.bing.net/th?id=OIP.eAj49mlY5TXESmG20aaMHQHaDt&pid=Api&P=0&h=180", ScaleTypes.FIT)); // for one image
        imageList.add(new SlideModel("https://tse4.mm.bing.net/th?id=OIP.5wImt-_b8yWOg_2YFQJjywHaCZ&pid=Api&P=0&h=180", ScaleTypes.FIT)); // you can include title
        imageList.add(new SlideModel("https://tse3.mm.bing.net/th?id=OIP.J58XG2IouTgIr7PcGOldKgHaDr&pid=Api&P=0&h=180", ScaleTypes.FIT)); // you can include title
        imageList.add(new SlideModel("https://tse3.mm.bing.net/th?id=OIP.btewfKF3Z1WeCv4hGYpCPAHaD3&pid=Api&P=0&h=180", ScaleTypes.FIT)); // for one image

        //.............Set the imageList and ScaleType for all images in the ImageSlider............//

        imageSlider.setImageList(imageList, ScaleTypes.FIT);

        //.............ImageSlider End............//

        optionsMenu = (ImageButton)findViewById(R.id.optionMenu);
        optionsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OptionManu();
            }
        });
    }
    public void OptionManu(){
        Intent intent = new Intent(this, options.class);
        startActivity(intent);
    }
    public void openProduct(){
        Intent intent = new Intent(this, ProductDetailActivity.class);
        startActivity(intent);
    }
    public void openCart(){
        Intent intent = new Intent(this, bag2.class);
        startActivity(intent);
    }
    public void OpenSearch(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openindoor(){
        Intent intent = new Intent(this, Indoor.class);
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