package com.example.frag.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.frag.R;
import com.example.frag.model.Ticket;
import com.example.frag.model.item;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class MyTourAdapter extends FirebaseRecyclerAdapter<Ticket,MyTourAdapter.TourViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MyTourAdapter(@NonNull FirebaseRecyclerOptions<Ticket> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyTourAdapter.TourViewHolder holder, int position, @NonNull Ticket model) {

        holder.tvTourName.setText(model.getNameTour());
        holder.tvtimeTour.setText(model.getTimeTour());
        holder.placeTour.setText(model.getPlaceTour());
        holder.tvPrice.setText(model.getPriceChild());



    }

    @NonNull
    @Override
    public MyTourAdapter.TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.savetour, parent, false);
        return new MyTourAdapter.TourViewHolder(view);
    }

    public class TourViewHolder extends RecyclerView.ViewHolder {

        ImageView imgItem;
        TextView tvTourName, tvtimeTour, placeTour, tvPrice, pricePeople, priceChild, time;
        TextView nameCustom, phoneCustom, emailCustom, people_amount, child_amount, placeStart;
        public TourViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
            tvTourName = itemView.findViewById(R.id.tvTourName);
            tvtimeTour = itemView.findViewById(R.id.tvtimeTour);
            placeTour = itemView.findViewById(R.id.placeTour);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            pricePeople = itemView.findViewById(R.id.pricePeople);
            priceChild = itemView.findViewById(R.id.priceChild);

            people_amount = itemView.findViewById(R.id.people_amount);
            child_amount = itemView.findViewById(R.id.child_amount);
            placeStart = itemView.findViewById(R.id.placeStart);




        }
    }




    /*

    @NonNull
    @Override
    public MyTourAdapter.MyTourRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.savetour,parent,false);

        return new MyTourRecyclerHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyTourAdapter.MyTourRecyclerHolder holder, int position) {
        Ticket item1 = mListItem.get(position);
        if(item1 == null){
            return;
        }
        holder.imgtab1.setImageResource(item1.getResourceId());
        holder.nametab1.setText(item1.getNametab1());
        holder.infortab1.setText(item1.getInfortab1());
    }

    @Override
    public int getItemCount() {
        return mListItem.size();
    }

    public class MyTourRecyclerHolder extends RecyclerView.ViewHolder {
        private ImageView imgtab1;
        private TextView nametab1;
        private TextView infortab1;

        public MyTourRecyclerHolder(@NonNull View itemView) {
            super(itemView);

            imgtab1 = itemView.findViewById(R.id.imgItem);
            nametab1 = itemView.findViewById(R.id.tvTourName);
            infortab1 = itemView.findViewById(R.id.tvLocation);
        }
    }
    */

}
