package com.example.frag.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.frag.R;
import com.example.frag.model.Trend_ItemList;

public class BlogDetail extends AppCompatActivity {
    private ImageView imgItemDetail;
    private TextView tvTitleDetail;
    private TextView tvDescripcionDetail;
    private Trend_ItemList itemDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trend_detail);

        initViews();

        Bundle bundle = getIntent().getExtras();
        int image = bundle.getInt("image");
        String title = bundle.getString("title");
        String des = bundle.getString("des");

        imgItemDetail.setImageResource(image);
        tvTitleDetail.setText(title);
        tvDescripcionDetail.setText(des);

        /*Toast.makeText(this, "image : " +image , Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "title : " +title , Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "des : " +des , Toast.LENGTH_SHORT).show();*/
    }
    private void initViews() {
        imgItemDetail = findViewById(R.id.imgItemDetail);
        tvTitleDetail = findViewById(R.id.tvTitleDetail);
        tvDescripcionDetail = findViewById(R.id.tvDescripcionDetail);
    }
}