package com.example.frag.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.frag.R;

public class Tour_findtour extends AppCompatActivity {
    private TextView tvTitle;
    private TextView tvTourName, people_amount, child_amount;
    private  ImageButton btnDate;
    private Button  btnFillInfo;
    private static int _counter_people = 0 ;
    private static int _counter_child = 0 ;
    private ImageButton people_minus, people_add, child_minus, child_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_findtour);

        initViews();

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");

        tvTitle.setText(name);
        tvTourName.setText(name);

        people_amount = (TextView)findViewById(R.id.people_amount);
        _counter_people = Integer.valueOf(people_amount.getText().toString());


        people_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _counter_people++;

                people_amount.setText("" + _counter_people);

            }
        });

        people_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_counter_people < 0){
                    _counter_people =  0;
                    people_amount.setText(_counter_people+ "");
                }
                if (_counter_people > 0) {
                    _counter_people = _counter_people - 1;
                    people_amount.setText(_counter_people+ "");
                }

            }
        });

        child_amount = (TextView)findViewById(R.id.child_amount);
        _counter_child = Integer.valueOf(people_amount.getText().toString());


        child_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _counter_child++;

                child_amount.setText(_counter_child+ "");

            }
        });

        child_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_counter_child < 0){
                    _counter_child =  0;
                    child_amount.setText(_counter_child+ "");
                }
                if (_counter_child > 0) {
                    _counter_child = _counter_child - 1;
                    child_amount.setText(_counter_child+ "");
                }

            }
        });

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnFillInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tour_findtour.this, Tour_fillinfo.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        tvTitle = findViewById(R.id.tvTitle);
        tvTourName = findViewById(R.id.tvTourName);
        btnDate = findViewById(R.id.btnDate);
        btnFillInfo = findViewById(R.id.btnFillInfo);

        people_minus = findViewById(R.id.people_minus);
        people_add = findViewById(R.id.people_add);

        child_minus = findViewById(R.id.child_minus);
        child_add = findViewById(R.id.child_add);
    }
}