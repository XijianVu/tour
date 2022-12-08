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
import androidx.recyclerview.widget.RecyclerView;

import com.example.frag.R;
import com.example.frag.activity.TourDetails;
import com.example.frag.model.Tour;

import java.util.ArrayList;

public class BestSaleAdapter extends  RecyclerView.Adapter<BestSaleAdapter.UserViewHolder> {

    Context context;
    ArrayList<Tour> arrayList;


    public BestSaleAdapter(Context context, ArrayList<Tour> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_photo, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Tour user = arrayList.get(position);
        if (user == null) {
            return;
        }
        holder.imgResource.setImageResource(user.getResourceId());
        holder.name.setText(user.getName());
        holder.price.setText(user.getPrice());
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imgResource;
        private TextView name, timeTour, placeTour, placeStart;
        private TextView price;
        private TextView about;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            imgResource = itemView.findViewById(R.id.img_slider);
            name = itemView.findViewById(R.id.name);
            timeTour = itemView.findViewById(R.id.timeTour);
            placeTour = itemView.findViewById(R.id.placeTour);
            placeStart = itemView.findViewById(R.id.placeStart);
            price = itemView.findViewById(R.id.price);
            about = itemView.findViewById(R.id.tourtrend);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int postion = getAdapterPosition();
            Toast.makeText(context, "postion" + postion, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, TourDetails.class);
            intent.putExtra("image", arrayList.get(postion).getResourceId());
            intent.putExtra("name", arrayList.get(postion).getName());
            intent.putExtra("timeTour", arrayList.get(postion).getTimeTour());
            intent.putExtra("placeTour", arrayList.get(postion).getPlaceTour());
            intent.putExtra("placeStart", arrayList.get(postion).getPlaceStart());
            intent.putExtra("price", arrayList.get(postion).getPrice());
            intent.putExtra("about", arrayList.get(postion).getAbout());

            context.startActivity(intent);
        }
    }
}
