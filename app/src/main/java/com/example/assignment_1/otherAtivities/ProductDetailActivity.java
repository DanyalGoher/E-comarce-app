package com.example.assignment_1.otherAtivities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.assignment_1.R;
import com.example.assignment_1.bag.bag;
import com.example.assignment_1.bag.bag2;

public class ProductDetailActivity extends AppCompatActivity {

    ImageView img;
    ImageButton img1;
    ImageButton img2;
    ImageButton img3;
    Button button;
    ImageButton Cart;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        Cart = (ImageButton)findViewById(R.id.Cart);
        Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCart();
            }
        });

        img = (ImageView)findViewById(R.id.img);
        img1 = (ImageButton) findViewById(R.id.img1);
        img2 = (ImageButton) findViewById(R.id.img2);
        img3 = (ImageButton) findViewById(R.id.img3);
        button = (Button) findViewById(R.id.addToCartBtn);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setImageResource(R.drawable.maxpulse);
                
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                img.setImageResource(R.drawable.witness6);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setImageResource(R.drawable.impact4);
                }
                });

    }

    public void openCart(){
        Intent intent = new Intent(this, bag.class);
        startActivity(intent);
    }
}