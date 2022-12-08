package com.example.frag.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.frag.R;

public class Tour_FillInfo extends AppCompatActivity {
    private Button btnPay;
    private TextView tvTitle;
    private TextView tvTourName, tvPeople_amount, tvChild_amount, tvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_fillinfo);

        initViews();

        Bundle bundle = getIntent().getExtras();

        String name = bundle.getString("name");
        String price = bundle.getString("price");
        int b=Integer.parseInt(price);

        int people_amount = bundle.getInt("_counter_people");
        int child_amount = bundle.getInt("_counter_child");
        Toast.makeText(Tour_FillInfo.this, "_counter_people"+people_amount + "_counter_child"+child_amount ,Toast.LENGTH_LONG).show();

        tvTitle.setText(name);
        tvTourName.setText(name);
        tvPrice.setText(String.valueOf(people_amount*b+child_amount*b));
        tvPeople_amount.setText(String.valueOf(people_amount));
        tvChild_amount.setText(String.valueOf(child_amount));


        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tour_FillInfo.this, Tour_PaySuccess.class);

                startActivity(intent);
            }
        });
    }

    private void initViews() {
        tvTitle = findViewById(R.id.tvTitle);
        tvTourName = findViewById(R.id.tvTourName);
        btnPay = findViewById(R.id.btnPay);

        tvPeople_amount = findViewById(R.id.tvPeople_amount);
        tvChild_amount = findViewById(R.id.tvChild_amount);
        tvPrice = findViewById(R.id.tvPrice);


    }
}