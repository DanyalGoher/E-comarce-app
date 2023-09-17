package com.example.assignment_1.find;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_1.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass>userList;
    Adapter adapter;
    private SearchView searchView;

    public View show;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.SearchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fileList(newText);
                return true;
            }
        });
        initData();
        initRecyclerView();
    }

    private void fileList(String text) {
        List<ModelClass> filteredList = new ArrayList<>();
        for (ModelClass item : userList){
            if (item.getTextview1().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }

        if (filteredList.isEmpty()){
            Toast.makeText(this,"No data Found", Toast.LENGTH_SHORT).show();
            show = findViewById(R.id.RecyclerView);
            show.setVisibility(View.INVISIBLE);
        }
        else {
            adapter.setFilteredlist(filteredList);
            show = findViewById(R.id.RecyclerView);
            show.setVisibility(View.VISIBLE);
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private void initRecyclerView() {
        recyclerView =findViewById(R.id.RecyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter(userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
    private void initData() {
        userList = new ArrayList<>();

        userList.add(new ModelClass(R.drawable.maxpulse,"Air Max Pulse","$150","10:45 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.metcon8,"Air Jordan 1 Mid SE","$135","15:08 pm","_______________________________________"));

        userList.add(new ModelClass(R.drawable.low,"Air Jordan 1 Low","$110","1:02 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.witness7,"LeBron Witness 7","$58.97","12:55 pm","_______________________________________"));

        userList.add(new ModelClass(R.drawable.witness6,"LeBron Witness 6","$73.97","13:50 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.lebron,"LeBron XX","$210","1:08 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.immortality,"Giannis Immortality","$59.97","4:02 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.precision6,"Precision 6","$63.97","11:55 pm","_______________________________________"));

        userList.add(new ModelClass(R.drawable.impact4,"Impact 4","$76.97","10:45 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.xxxii,"Air Jordan XXXVII","$70.97","15:08 pm","_______________________________________"));

        userList.add(new ModelClass(R.drawable.ja,"Ja 1","$110","1:02 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.pg6,"PG 6","$120","12:55 pm","_______________________________________"));

        userList.add(new ModelClass(R.drawable.retro6g,"Jordan Retro 6 G","$220","13:50 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.premium,"Air Zoom GP Turbo Osaka Premium","$160","1:08 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.tr12,"Renew In-Season TR 12","$54.97","4:02 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.metcon8,"Metcon 8 FlyEase","$97.97","11:55 pm","_______________________________________"));




    }


}