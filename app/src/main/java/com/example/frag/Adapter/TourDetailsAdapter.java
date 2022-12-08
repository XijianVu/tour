package com.example.frag.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frag.R;
import com.example.frag.model.TourPhoto;
import com.example.frag.model.Tour;

import java.util.ArrayList;
import java.util.List;

public class TourDetailsAdapter extends RecyclerView.Adapter<TourDetailsAdapter.PhotoViewHoder> {
    private List<TourPhoto> mlistPhoto;

    Context context;
    ArrayList<Tour> arrayList;

    public TourDetailsAdapter(List<TourPhoto> mlistPhoto) {
        this.mlistPhoto = mlistPhoto;
    }

    @NonNull
    @Override
    public PhotoViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tourdetails,parent,false);


        return new PhotoViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHoder holder, int position) {
        TourPhoto tourPhoto = mlistPhoto.get(position);
        if(tourPhoto == null){
            return;
        }
        holder.imgPhoto.setImageResource(tourPhoto.getResourceID());
    }

    @Override
    public int getItemCount() {
        if(mlistPhoto != null){
            return mlistPhoto.size();
        }
        return 0;
    }

    public class PhotoViewHoder extends RecyclerView.ViewHolder {

        private ImageView imgPhoto;

        public PhotoViewHoder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.imgTourDetails);
        }
    }
}
