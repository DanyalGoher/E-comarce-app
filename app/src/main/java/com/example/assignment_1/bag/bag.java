package com.example.assignment_1.bag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.assignment_1.R;
import com.example.assignment_1.otherAtivities.home;
import com.example.assignment_1.otherAtivities.order;

import java.util.ArrayList;
import java.util.List;

public class bag extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<model>bagList;
    Adapter adapter;
    public View show;
    public View delete;
    public View text1;
    public View fees;
    public View total;
    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag);


        initData();
        initRecyclerView();
        text1 = findViewById(R.id.text1);
        fees = findViewById(R.id.fees);
        total = findViewById(R.id.total);

        button = findViewById(R.id.bag);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOrder();
            }
        });

        delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                show = findViewById(R.id.RecyclerView);
                show.setVisibility(View.INVISIBLE);
                text1.setVisibility(View.INVISIBLE);
                fees.setVisibility(View.INVISIBLE);
                total.setVisibility(View.INVISIBLE);
            }
        });



    }
        private void initRecyclerView() {
        recyclerView =findViewById(R.id.RecyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter(bagList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
    private void initData() {
        bagList = new ArrayList<>();

        bagList.add(new com.example.assignment_1.bag.model(R.drawable.metcon8,"Air Max Pulse","$150","1212","---------------"));

    }

    public void openOrder(){
        Intent intent = new Intent(this, order.class);
        startActivity(intent);
    }
}