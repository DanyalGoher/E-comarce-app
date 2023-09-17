package com.example.assignment_1.otherAtivities;

import androidx.activity.result.ActivityResult;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment_1.R;
import com.example.assignment_1.databinding.ActivityOrderBinding;
import com.example.assignment_1.databinding.ActivitySignupBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import papaya.in.sendmail.SendMail;

public class order extends AppCompatActivity {

    FusedLocationProviderClient fusedLocationProviderClient;
    TextView Location;
    public View locationBTN;
    private final static int REQUEST_CODE=100;
    ActivityOrderBinding binding;
    ImageButton button;
    Button button1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SendMail mail = new SendMail("danyalgoher753@gmail.com", "personalacount",
                binding.EmailAddress.getText().toString(),
                "Testing Email Sending",
                "Yes, it's working well\nI will use it always.");

        button1 = findViewById(R.id.bag);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendone();
                mail.execute();
            }
        });

        button = findViewById(R.id.OpenMap);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:47.492,19.013"));
                Intent chooser = Intent.createChooser(intent,"Open Map");
                startActivity(chooser);
            }
        });

        Location = findViewById(R.id.location);
        locationBTN = findViewById(R.id.locationBTN);

        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this);

        locationBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getLastLocation();
            }
        });

    }
    public void opendone(){
        String email = binding.EmailAddress.getText().toString();
        String phone= binding.editTextPhone.getText().toString();
        String Address= binding.location.getText().toString();
        if (phone.equals("") || email.equals("") || Address.equals("")) {
            Toast.makeText(order.this, "please fill all fields", Toast.LENGTH_SHORT).show();
        }
        else {
                Toast.makeText(order.this, "Your Order is Placed Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), orderDone.class);
                intent.putExtra("phoneNumber", binding.editTextPhone.getText().toString());
                startActivity(intent);
            }
    }

    private void getLastLocation() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){

            fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if(location != null){
                                Geocoder geocoder = new Geocoder(order.this, Locale.getDefault());

                                try {
                                    List<Address> addresses=geocoder.getFromLocation(location.getLatitude(), location.getLongitude(),1);
                                    Location.setText(addresses.get(0).getAddressLine(0));
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    });
        }
        else {
            AskPermission();
        }
    }

    private void AskPermission() {
        ActivityCompat.requestPermissions(order.this, new String[]
                {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode==REQUEST_CODE){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getLastLocation();
            }
            else {
                Toast.makeText(this,"Required permission", Toast.LENGTH_SHORT)
                        .show();
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}