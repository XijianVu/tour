package com.example.frag.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.frag.R;
import com.example.frag.model.Tour;

import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class TourDetails extends AppCompatActivity {
    private ViewPager2 mviewPager2;
    private CircleIndicator3 mcircleIndicator3;
    private List<Tour> mlistPhoto;



    private ImageView viewPagerdetails;
    private TextView tvTourName;
    private TextView placeTour;
    private TextView timeTour;
    private TextView placeStart;
    private TextView tourtrend, tvPrice;
    private Button btnTimTour;
    private Tour itemDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_details);

        initViews();

        Bundle bundle = getIntent().getExtras();
        int image = bundle.getInt("image");
        String name = bundle.getString("name");
        String time = bundle.getString("timeTour");
        String place = bundle.getString("placeTour");
        String startPlace = bundle.getString("placeStart");
        String price = bundle.getString("price");
        String about = bundle.getString("about");



        viewPagerdetails.setImageResource(image);
        tvTourName.setText(name);
        timeTour.setText(time);
        placeTour.setText(place);
        placeStart.setText(startPlace);
        tvPrice.setText(price);
        tourtrend.setText(about);

        btnTimTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TourDetails.this, Tour_FindTour.class);
                intent.putExtra("name", name);
                intent.putExtra("price", price);
                startActivity(intent);
            }
        });

    }

    private void initViews() {
        viewPagerdetails = findViewById(R.id.viewPagerdetails);
        tvTourName = findViewById(R.id.tvTourName);
        tvPrice = findViewById(R.id.tvPrice);
        tourtrend = findViewById(R.id.tourtrend);
        timeTour = findViewById(R.id.timeTour);
        placeTour = findViewById(R.id.placeTour);
        placeStart = findViewById(R.id.placeStart);
        btnTimTour = findViewById(R.id.btnTimTour);
    }


}