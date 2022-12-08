package com.example.frag.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.frag.MainActivity;
import com.example.frag.R;
import com.example.frag.fragment.HomeFragment;

public class Tour_paysuccess extends AppCompatActivity {
    private TextView btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_paysuccess);

        initViews();
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tour_paysuccess.this, MainActivity.class);

                startActivity(intent);
            }
        });


    }

    private void initViews() {
        btnHome = findViewById(R.id.btnHome);
    }
}