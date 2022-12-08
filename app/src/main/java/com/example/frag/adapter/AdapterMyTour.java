package com.example.frag.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frag.R;
import com.example.frag.model.item;

import java.util.ArrayList;

public class AdapterMyTour extends RecyclerView.Adapter<AdapterMyTour.MyTourRecyclerHolder>{
    private Context mContext;
    private ArrayList<item> mListItem;
    RecyclerItemClick itemClick;

    public interface RecyclerItemClick {
        void itemClick(item mitem);
    }

    public AdapterMyTour(Context mContext, ArrayList<item> mListItem) {
        this.mContext = mContext;
        this.mListItem = mListItem;
        this.itemClick = itemClick;
    }

    public AdapterMyTour(Context mContext) {
        this.mContext = mContext;
    }

    public void setmListUser(ArrayList<item> mListItem) {
        this.mListItem = mListItem;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterMyTour.MyTourRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.savetour,parent,false);

        return new MyTourRecyclerHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMyTour.MyTourRecyclerHolder holder, int position) {
        item item1 = mListItem.get(position);
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
}
