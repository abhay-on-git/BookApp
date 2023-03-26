package com.example.boookapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import android.app.ActionBar;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import java.net.URI;
import java.util.Objects;

public class ReadBookActivity extends AppCompatActivity {

    Toolbar toolbar;
    String url ;

    @SuppressLint({"MissingInflatedId", "SetJavaScriptEnabled"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_book);
        toolbar = findViewById(R.id.custom_toolbar);
        //Step 1
        setSupportActionBar(toolbar);
        //Step 2
        if (getSupportActionBar()!=null){
           getSupportActionBar().setDisplayHomeAsUpEnabled(true);
           getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24);
        }
        url = Uri.encode(getIntent().getStringExtra("pdfUrl"));



        WebView webView = findViewById(R.id.WebView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("http://docs.google.com/gview?embedded=true&url="+ url);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
         getMenuInflater().inflate(R.menu.opt_menu,menu);
        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int item_id = item.getItemId();
        if(item_id == R.id.opt_shareApp){
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT,"Download This Fantastic App and Share with Your Friends.\n\n https://play.google.com/store/apps/details?id="+getPackageName());
            startActivity(Intent.createChooser(intent,"Choose one"));
        } else if (item_id == R.id.opt_aboutUs) {
            Toast.makeText(this , "Developed By Abhay Agnihotri" ,Toast.LENGTH_SHORT).show();
        } else if (item_id == R.id.opt_app_info) {
            Toast.makeText(this , "It's a Book Summary App" ,Toast.LENGTH_SHORT).show();
        }else{
            super.onBackPressed();
        }
        return true;
    }
}