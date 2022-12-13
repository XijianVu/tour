package com.example.frag.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.frag.R;
import com.example.frag.model.Blog;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Blog_edit extends AppCompatActivity {

    EditText blog_edit_descripcion;
    EditText blog_edit_purl;
    EditText blog_edit_titulo;

    private DatabaseReference ref;
    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_add);

        blog_edit_descripcion = findViewById(R.id.blog_edit_descripcion);
        blog_edit_purl = findViewById(R.id.blog_edit_purl);
        blog_edit_titulo = findViewById(R.id.blog_edit_titulo);

        Button btnPushBlog = findViewById(R.id.btn_push_blog);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference();

//        btnPushBlog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String descripcion = edit_descripcion.getText().toString();
//                String purl =edit_purl.getText().toString();
//                String titulo = edit_titulo.getText().toString();
//
//                Blog blog = new Blog(descripcion,purl,titulo);
//                ref.child("blog").child(String.valueOf(blog.getTitulo())).setValue(blog);
//
//            }
//        });
    }
}