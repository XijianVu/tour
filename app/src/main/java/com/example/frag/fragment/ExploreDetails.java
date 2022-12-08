package com.example.frag.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.frag.Adapter.ExploreDetailsAdapter;
import com.example.frag.model.TourPhoto;
import com.example.frag.R;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class ExploreDetails extends AppCompatActivity {
    private ViewPager2 mviewPager2;
    private CircleIndicator3 mcircleIndicator3;
    private List<TourPhoto> mlistPhoto;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_details);

        mviewPager2 = findViewById(R.id.viewPagerexplore);
        mcircleIndicator3 = findViewById(R.id.cicleIddetails2);

        mlistPhoto = getListPhoto();
        ExploreDetailsAdapter adapter = new ExploreDetailsAdapter(mlistPhoto);
        mviewPager2.setAdapter(adapter);

        mcircleIndicator3.setViewPager(mviewPager2);

    }

    private List<TourPhoto> getListPhoto(){
        List<TourPhoto> list = new ArrayList<>();
        list.add(new TourPhoto(R.drawable.a5));
        list.add(new TourPhoto(R.drawable.a5));
        list.add(new TourPhoto(R.drawable.a6));
        list.add(new TourPhoto(R.drawable.a1));
        list.add(new TourPhoto(R.drawable.a3));
        return list;
    }
}