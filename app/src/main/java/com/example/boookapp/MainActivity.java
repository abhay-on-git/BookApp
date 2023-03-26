package com.example.boookapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ArrayList<bookModel> Book_list = new ArrayList<bookModel>();
    RecyclerView BookApp_recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BookApp_recyclerView = findViewById(R.id.BookApp_recyclerView);
        Objects.requireNonNull(getSupportActionBar()).hide();

        BookApp_recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL));
        FirebaseDatabase.getInstance().getReference().child("books").addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Book_list.clear();
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        bookModel model = snapshot1.getValue(bookModel.class);
                        Book_list.add(model);
                    }
                    Bookadapter adapter = new Bookadapter(MainActivity.this, Book_list);
                    BookApp_recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w("Failed", "Failed to read value.", error.toException());
            }
        });
    }
}