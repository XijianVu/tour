package com.example.frag.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frag.R;
import com.example.frag.adapter.BestSaleAdapter;
import com.example.frag.fragment.itemTab1.Photo2Adapter;
import com.example.frag.fragment.itemTab1.Photo3Adapter;
import com.example.frag.fragment.itemTab1.Photo4Adapter;
import com.example.frag.model.Tour;
import com.example.frag.model.Tour2;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    private View mView;
    private List<Tour> listitem;
    private BestSaleAdapter photo1Adapter;
    private Photo2Adapter photo2Adapter;
    private Photo3Adapter photo3Adapter;
    private Photo4Adapter photo4Adapter;
    private TabLayout tabLayout;

    private ArrayList<Tour> arrayList;
    private RecyclerView home1_viewpager1,home1_viewpager2;


    FirebaseRecyclerAdapter<Tour, BestSaleAdapter.TourViewHolder> adapter;


    private DatabaseReference ref;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        home1_viewpager1=(RecyclerView)view.findViewById(R.id.home1_viewpager1);
        home1_viewpager1.setLayoutManager(new GridLayoutManager(this.getContext(),2));

        FirebaseRecyclerOptions<Tour> optionBestSale =
                new FirebaseRecyclerOptions.Builder<Tour>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("tour"), Tour.class)
                        .build();


        adapter=new BestSaleAdapter(optionBestSale);
        home1_viewpager1.setAdapter(adapter);

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ref = FirebaseDatabase.getInstance().getReference();
        listitem=new ArrayList<>();

    }

}
