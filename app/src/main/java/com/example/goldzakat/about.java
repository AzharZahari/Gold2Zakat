package com.example.goldzakat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class about extends AppCompatActivity {

    ImageView  whatsapp, githublink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        whatsapp = findViewById(R.id.ws);
        githublink = findViewById(R.id.link);




        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://wa.me/60194474485");
            }
        });

        githublink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://github.com/AzharZahari/Gold2Zakat");
            }
        });

    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}