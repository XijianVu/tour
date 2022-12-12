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

import com.bumptech.glide.Glide;
import com.example.frag.R;
import com.example.frag.activity.BlogDetail;
import com.example.frag.activity.TourDetails;
import com.example.frag.model.Blog;
import com.example.frag.model.Tour;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class BestSaleAdapter extends FirebaseRecyclerAdapter<Tour,BestSaleAdapter.TourViewHolder> {

    public BestSaleAdapter(@NonNull FirebaseRecyclerOptions<Tour> options) {
        super(options);
    }



    @NonNull
    @Override
    public BestSaleAdapter.TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_photo,parent,false);
        return new BestSaleAdapter.TourViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull BestSaleAdapter.TourViewHolder holder, int position, @NonNull Tour model) {
        holder.about.setText(model.getAbout());
        holder.name.setText(model.getName());
        holder.placeStart.setText(model.getPlaceStart());
        holder.placeTour.setText(model.getPlaceTour());
        holder.priceChild.setText(model.getPriceChild());
        holder.pricePeople.setText(model.getPricePeople());
        holder.timeTour.setText(model.getTimeTour());

        Glide.with(holder.resourceId.getContext()).load(model.getResourceId()).into(holder.resourceId);

        holder.resourceId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, TourDetails.class);
                intent.putExtra("name", model.getName());
                intent.putExtra("about", model.getAbout());
                intent.putExtra("image", model.getResourceId());
                intent.putExtra("placeStart", model.getPlaceStart());
                intent.putExtra("placeTour", model.getPlaceTour());
                intent.putExtra("timeTour", model.getTimeTour());
                intent.putExtra("pricePeople", model.getPricePeople());
                intent.putExtra("priceChild", model.getPriceChild());
                Toast.makeText(context,  model.getName(), Toast.LENGTH_SHORT).show();

                context.startActivity(intent);
            }
        });
    }

    public class TourViewHolder extends RecyclerView.ViewHolder
    {
        ImageView resourceId;
        TextView about,name,placeStart,placeTour,priceChild,pricePeople,timeTour;

        public TourViewHolder(@NonNull View itemView) {
            super(itemView);

            about=itemView.findViewById(R.id.about);
            name=itemView.findViewById(R.id.name);
            placeStart=itemView.findViewById(R.id.placeStart);
            placeTour=itemView.findViewById(R.id.placeTour);
            priceChild=itemView.findViewById(R.id.priceChild);
            pricePeople=itemView.findViewById(R.id.pricePeople);
            resourceId=itemView.findViewById(R.id.img_slider);
            timeTour=itemView.findViewById(R.id.timeTour);

        }
    }

/*
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
        holder.price.setText(user.getPricePeople());
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
            intent.putExtra("price", arrayList.get(postion).getPricePeople());
            intent.putExtra("about", arrayList.get(postion).getAbout());

            context.startActivity(intent);
        }
    }

 */
}
