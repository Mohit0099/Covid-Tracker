package com.example.covidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        ImageView gif = findViewById(R.id.gif);
        Glide.with(this).asGif().load(R.raw.gif).into(gif);
        Thread thread = new Thread(){
            public  void run(){
                try{
                    sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();

                }finally {
                    Intent intent = new Intent(Splashscreen.this , MainActivity.class);
                    startActivity(intent);

                }
            }
        };thread.start();
    }


}