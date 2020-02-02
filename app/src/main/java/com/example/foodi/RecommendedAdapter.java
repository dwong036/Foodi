package com.example.foodi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {

    private Context context;
    private int resID;
    private ArrayList<Category> recs;

    public RecommendedAdapter(Context context, int resource, ArrayList<Category> recs) {
        this.context = context;
        this.resID = resource;
        this.recs = recs;
    }

    @NonNull
    @Override
    public RecommendedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(resID, parent, false);
        RecommendedAdapter.ViewHolder viewHolder = new RecommendedAdapter.ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedAdapter.ViewHolder holder, int position) {
        TextView nameTextView = holder.nameTextView;
        CircleImageView foodImageView = holder.foodImageView;

        final Category cat = recs.get(position);
        nameTextView.setText(cat.getName());
        Picasso.with(context).load(cat.getResId()).resize(90,90)
                .into(foodImageView);
    }

    @Override
    public int getItemCount() {
        return recs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public CircleImageView foodImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            foodImageView = itemView.findViewById(R.id.foodImageView);
        }
    }
}