package com.example.boookapp;

import static com.bumptech.glide.load.engine.DiskCacheStrategy.ALL;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Bookadapter extends RecyclerView.Adapter<Bookadapter.ViewHolder> {

    Context context;
    ArrayList<bookModel> Book_list;
    public Bookadapter (Context context ,  ArrayList<bookModel> Book_list){
        this.context = context;
        this.Book_list = Book_list ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bookapp_layout ,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        bookModel model = Book_list.get(position);
        Glide.with(context).load(model.getImage()).into(holder.book_img);

        holder.book_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , ReadBookActivity.class );
                intent.putExtra("pdfUrl" , model.getPdfUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Book_list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
         ImageView book_img;
         public ViewHolder (@NonNull View itemView){
             super(itemView);
             book_img = itemView.findViewById(R.id.book_1);
         }
    }
}
