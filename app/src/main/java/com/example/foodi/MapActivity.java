package com.example.foodi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity {
    BottomSheetBehavior bs;

    RecyclerView recRecyclerView;
    RecommendedAdapter recRecyclerViewAdapter;
    RecyclerView.LayoutManager recRecyclerViewManager;
    ArrayList<Category> recs;

    ArrayList<Food> fs;
    FoodAdapter foodAdapter;
    RecyclerView fRecyclerView;

    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


        bs = BottomSheetBehavior.from(findViewById(R.id.bs));

        recRecyclerView = findViewById(R.id.recRecyclerView);
        fRecyclerView = findViewById(R.id.fRecyclerView);

        // Access a Cloud Firestore instance from your Activity
        db = FirebaseFirestore.getInstance();

        recs = new ArrayList<>();
        recs.add(new Category("Chowder","Hot soup in the cold. Why not!",R.drawable.chowder));
        recs.add(new Category("Popcorn Chicken","Hear that sound? Yeah, it's your stomach",R.drawable.popcorn_chicken));
        recs.add(new Category("Ravioli","Want some Italian food?",R.drawable.ravioli));
        recs.add(new Category("Ramen","Hot soup in the cold. Why not!",R.drawable.ramen));

        recRecyclerViewAdapter = new RecommendedAdapter(this,R.layout.recommend_one_item,recs);
        recRecyclerViewManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recRecyclerView.setLayoutManager(recRecyclerViewManager);
        recRecyclerView.setAdapter(recRecyclerViewAdapter);

        fs = new ArrayList<>();
        fs.add(new Food("Banh Mi",R.drawable.banhmi,"19:19"));
        fs.add(new Food("Cookies",R.drawable.cookies,"11:40"));
        fs.add(new Food("Banh Mi",R.drawable.banhmi,"08:40"));
        fs.add(new Food("Banh Mi",R.drawable.banhmi,"05:05"));

        foodAdapter = new FoodAdapter(this,R.layout.food_one_item,fs);
        fRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        fRecyclerView.setAdapter(foodAdapter);

    }

    public void refresh(View v)
    {
//        db.collection("detections")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
////                            for (QueryDocumentSnapshot document : task.getResult()) {
////                            {
//                                QueryDocumentSnapshot document = (QueryDocumentSnapshot)task.getResult().getDocuments().get(0);
//                                Toast.makeText(MapActivity.this, document.getId() + " => " + document.getData(), Toast.LENGTH_SHORT).show();
//
//                        } else {
//                            Toast.makeText(MapActivity.this, "Error getting documents.", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
        DocumentReference docRef = db.collection("detections").document("ayGqwKHLJAS3xf6pJlhY");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Toast.makeText(MapActivity.this, "\"DocumentSnapshot data: \" + document.getData()", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MapActivity.this, "No such document", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MapActivity.this, "get failed with", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
