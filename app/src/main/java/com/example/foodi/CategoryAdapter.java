package com.example.foodi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Context context;
    private int resID;
    private ArrayList<Category> cats;
    private ArrayList<Category> chosen;
    public CategoryAdapter(Context context, int resource, ArrayList<Category> cats) {
        this.context = context;
        this.resID = resource;
        this.cats = cats;
        chosen = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(resID, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView nameTextView = holder.nameTextView;
        TextView descriptionTextView = holder.descriptionTextView;
        CheckBox chosenCheckBox = holder.chosenCheckBox;
        CircleImageView foodImageView = holder.foodImageView;
        LinearLayoutCompat catLinearLayout = holder.catLinearLayout;

        final Category cat = cats.get(position);
        nameTextView.setText(cat.getName());
        descriptionTextView.setText(cat.getDescription());
        foodImageView.setImageResource(cat.getResId());

        chosenCheckBox.setChecked(cat.isPicked());
        chosenCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    chosen.add(cat);
                else
                    if(chosen.contains(cat))
                        chosen.remove(cat);
            }
        });
    }

    public ArrayList<Category> getChosenCats() {
        return chosen;
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView descriptionTextView;
        public CheckBox chosenCheckBox;
        public CircleImageView foodImageView;
        public LinearLayoutCompat catLinearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            chosenCheckBox = itemView.findViewById(R.id.chosenCheckBox);
            foodImageView = itemView.findViewById(R.id.foodImageView);
            catLinearLayout = itemView.findViewById(R.id.catLinearlayout);
        }
    }
}
