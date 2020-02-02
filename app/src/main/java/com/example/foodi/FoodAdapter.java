package com.example.foodi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private Context context;
    private int resID;
    private ArrayList<Food> fs;
    private String[]description = {"Fresh and delicious", "Stale but still good to consume","You really should not eat it"};
    public FoodAdapter(Context context, int resource, ArrayList<Food> fs) {
        this.context = context;
        this.resID = resource;
        this.fs = fs;
    }

    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(resID, parent, false);
        FoodAdapter.ViewHolder viewHolder = new FoodAdapter.ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder holder, int position) {
        TextView nameTextView = holder.nameTextView;
        TextView descriptionTextView = holder.descriptionTextView;
        CircleImageView foodImageView = holder.foodImageView;
        TextView timeTextView = holder.timeTextView;

        final Food f = fs.get(position);
        nameTextView.setText(f.getName());
        Picasso.with(context).load(f.getResID()).resize(90, 90)
                .into(foodImageView);
        descriptionTextView.setText(description[position%3]);
        timeTextView.setText(f.getTime());
    }

    @Override
    public int getItemCount() {
        return fs.size();
    }

    public void addFood(Food f)
    {
        fs.add(0,f);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView descriptionTextView;
        public CircleImageView foodImageView;
        public TextView timeTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            foodImageView = itemView.findViewById(R.id.foodImageView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
        }
    }
}