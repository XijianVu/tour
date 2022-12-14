package com.example.frag.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frag.R;
import com.example.frag.model.TourPhoto;
import com.example.frag.model.Tour;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

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
        if(arrayList != null){
            return arrayList.size();
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
