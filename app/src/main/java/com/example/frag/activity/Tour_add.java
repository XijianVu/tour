package com.example.frag.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.frag.R;
import com.example.frag.model.Tour;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Tour_add extends AppCompatActivity {

    EditText edit_about;
    EditText edit_name;
    EditText edit_placeStart;
    EditText edit_placeTour;
    EditText edit_priceChild;
    EditText edit_pricePeople;
    EditText edit_resourceId;
    EditText edit_timeTour;
    EditText edit_sdt;

    private DatabaseReference ref1;
    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_add);

        edit_about = findViewById(R.id.tour_edit_about);
        edit_name = findViewById(R.id.tour_edit_name);
        edit_placeStart = findViewById(R.id.tour_edit_placeStart);
        edit_placeTour = findViewById(R.id.tour_edit_placeTour);
        edit_priceChild = findViewById(R.id.tour_edit_priceChild);
        edit_pricePeople = findViewById(R.id.tour_edit_pricePeople);
        edit_resourceId = findViewById(R.id.tour_edit_resourceId);
        edit_timeTour = findViewById(R.id.tour_edit_timeTour);
        edit_sdt = findViewById(R.id.tour_edit_sdt);

        Button btnPushTour = findViewById(R.id.btn_push_tour);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref1 = database.getReference();

        btnPushTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String about = edit_about.getText().toString();
                String name = edit_name.getText().toString();
                String placeStart = edit_placeStart.getText().toString();
                String placeTour = edit_placeTour.getText().toString();
                String priceChild = edit_priceChild.getText().toString();
                String pricePeople = edit_pricePeople.getText().toString();
                String resourceId = edit_resourceId.getText().toString();
                String timeTour = edit_timeTour.getText().toString();
                String sdt   = edit_sdt.getText().toString();


                Tour tour = new Tour(about,name,placeStart,placeTour,priceChild,pricePeople,resourceId,timeTour,sdt);
                ref1.child("tour").child(String.valueOf(tour.getName())).setValue(tour);

            }
        });
    }
}