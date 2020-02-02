package com.example.foodi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {
    ArrayList<Category> cats = new ArrayList<>();
    RecyclerView catRecyclerView;
    CategoryAdapter catRecyclerViewAdapter;
    RecyclerView.LayoutManager catRecyclerViewManager;
    Button doneButton;

    ArrayList<Category> chosenCats = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        catRecyclerView = findViewById(R.id.catRecyclerView);
        doneButton = findViewById(R.id.doneButton);

        cats.add(new Category("Banh Mi", "Traditional Vietnamese food that everyone loves.", R.drawable.banhmi ));
        cats.add(new Category("Dumplings", "Traditional Chinese food stuffed with meat.", R.drawable.dumplings ));
        cats.add(new Category("Cookies", "Crunchy! Crunchy! Crunchy!", R.drawable.cookies ));
        cats.add(new Category("Bananas", "Want some potassium? ", R.drawable.bananas ));
        cats.add(new Category("Banh Mi", "Traditional Vietnamese food that everyone loves.", R.drawable.banhmi ));
        cats.add(new Category("Dumplings", "Traditional Chinese food stuffed with meat.", R.drawable.dumplings ));
        cats.add(new Category("Cookies", "Crunchy! Crunchy! Crunchy!", R.drawable.cookies ));
        cats.add(new Category("Bananas", "Want some potassium? ", R.drawable.bananas ));


        catRecyclerViewAdapter = new CategoryAdapter(this,R.layout.category_one_item,cats);
        catRecyclerViewManager = new LinearLayoutManager(this);
        catRecyclerView.setAdapter(catRecyclerViewAdapter);
        catRecyclerView.setLayoutManager(catRecyclerViewManager);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chosenCats = catRecyclerViewAdapter.getChosenCats();
                startActivity(new Intent(CategoryActivity.this,MapActivity.class));
            }
        });
    }
}
