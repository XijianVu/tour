package com.example.frag.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.frag.R;
import com.example.frag.activity.BlogDetail;
import com.example.frag.model.item;
import com.example.frag.model.Blog;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class BlogAdapter extends FirebaseRecyclerAdapter<Blog,BlogAdapter.BlogViewHolder>{


    public BlogAdapter(@NonNull FirebaseRecyclerOptions<Blog> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull BlogViewHolder holder, int position, @NonNull final Blog model) {
        holder.tvTitulo.setText(model.getTitulo());
        holder.tvDescripcion.setText(model.getDescripcion());

        Glide.with(holder.imgItem.getContext()).load(model.getPurl()).into(holder.imgItem);

        holder.imgItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, BlogDetail.class);
                intent.putExtra("title", model.getTitulo());
                intent.putExtra("des", model.getDescripcion());
                intent.putExtra("image", model.getPurl());
                context.startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.trend_item_list_view,parent,false);
        return new BlogViewHolder(view);
    }

    public class BlogViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgItem;
        TextView tvTitulo,tvDescripcion,emailtext;

        public BlogViewHolder(@NonNull View itemView) {
            super(itemView);

            imgItem=itemView.findViewById(R.id.imgItem);
            tvTitulo=itemView.findViewById(R.id.tvTitulo);
            tvDescripcion=itemView.findViewById(R.id.tvDescripcion);

        }
    }
}
