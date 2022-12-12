package com.example.frag.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.frag.R;
import com.google.android.material.textfield.TextInputLayout;

public class Tour_FillInfo extends AppCompatActivity {
    private Button btnPay;
    private TextView tvTitle;
    private TextView tvTourName, tvPeople_amount, tvChild_amount, tvPriceTotal;
    private TextView tvNameCustomer;
    private EditText edNameCustomer;
    private TextView tvAmountTicketChild, tvAmountTicketPeople, tvPricePeople, tvPriceChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_fillinfo);

        initViews();

        Bundle bundle = getIntent().getExtras();

        String name = bundle.getString("name");
        String pricePeople = bundle.getString("pricePeople");
        String priceChild = bundle.getString("priceChild");
        int people=Integer.parseInt(pricePeople);
        int child=Integer.parseInt(priceChild);

        int people_amount = bundle.getInt("_counter_people");
        int child_amount = bundle.getInt("_counter_child");
        Toast.makeText(Tour_FillInfo.this, "_counter_people"+people_amount + "_counter_child"+child_amount ,Toast.LENGTH_LONG).show();


        tvTourName.setText(name);
        tvPriceTotal.setText(String.valueOf(people_amount*people+child_amount*child));
        tvPeople_amount.setText(String.valueOf(people_amount));
        tvChild_amount.setText(String.valueOf(child_amount));

        tvAmountTicketPeople.setText("("+String.valueOf(people_amount)+"x)");
        tvAmountTicketChild.setText("("+String.valueOf(child_amount)+"x)");

        tvPricePeople.setText(String.valueOf(people_amount*people));
        tvPriceChild.setText(String.valueOf(child_amount*child));

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tour_FillInfo.this, Tour_PaySuccess.class);

                startActivity(intent);
            }
        });
        final TextInputLayout floatingUsernameLabel = (TextInputLayout) findViewById(R.id.name_text_input_layout);
        floatingUsernameLabel.getEditText().addTextChangedListener(new TextWatcher() {
            // ...
            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() > 0 && text.length() <= 4) {
                    floatingUsernameLabel.setError(getString(R.string.username_required));
                    floatingUsernameLabel.setErrorEnabled(true);
                } else {
                    floatingUsernameLabel.setErrorEnabled(false);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initViews() {
        tvTitle = findViewById(R.id.tvTitle);
        tvTourName = findViewById(R.id.tvTourName);

        edNameCustomer = findViewById(R.id.edNameCustomer);
        btnPay = findViewById(R.id.btnPay);

        tvPeople_amount = findViewById(R.id.tvPeople_amount);
        tvChild_amount = findViewById(R.id.tvChild_amount);
        tvPriceTotal = findViewById(R.id.tvPriceTotal);

        tvAmountTicketChild = findViewById(R.id.tvAmountTicketChild);
        tvAmountTicketPeople = findViewById(R.id.tvAmountTicketPeople);
        tvPricePeople = findViewById(R.id.tvPricePeople);
        tvPriceChild = findViewById(R.id.tvPriceChild);




    }
}