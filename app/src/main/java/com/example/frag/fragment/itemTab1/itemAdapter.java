package com.example.frag.fragment.itemTab1;

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

import java.util.List;

public class itemAdapter extends  RecyclerView.Adapter<itemAdapter.UserViewHolder>{

    private Context mContext;
    private List<item> mListUser;

    public itemAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<item> list){
        this.mListUser = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemtab1,parent,false);

        return new UserViewHolder(view);
    }

    @Override
    public int getItemCount() {
        if (mListUser != null){
            return mListUser.size();
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        item user = mListUser.get(position);
        if(user == null){
            return;
        }
        holder.imgtab1.setImageResource(user.getResourceId());
        holder.nametab1.setText(user.getNametab1());
        holder.infortab1.setText(user.getInfortab1());
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgtab1;
        private TextView nametab1;
        private TextView infortab1;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            imgtab1 = itemView.findViewById(R.id.imgtab1);
            nametab1 = itemView.findViewById(R.id.nametab1);
            infortab1 = itemView.findViewById(R.id.infortab1);
        }
    }
}
