package com.example.elzatona;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Main_Page extends AppCompatActivity implements View.OnClickListener {


    Button chemistry, physics, history, psychology, georaphyic, rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__page);

        chemistry = findViewById(R.id.chemistry);
        history = findViewById(R.id.history);
        psychology = findViewById(R.id.psychology);
        georaphyic = findViewById(R.id.georaphryic);
        physics = findViewById(R.id.physics);
        rate = findViewById(R.id.rate);
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_Page.this, Rate.class);
                startActivity(intent);
            }
        });

        chemistry.setOnClickListener(this);
        physics.setOnClickListener(this);
        history.setOnClickListener(this);
        georaphyic.setOnClickListener(this);
        psychology.setOnClickListener(this);
        rate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.chemistry:
                Intent a = new Intent(Main_Page.this, Chemistry.class);
                startActivity(a);
                break;

            case R.id.physics:
                Intent i = new Intent(Main_Page.this, Physics.class);
                startActivity(i);
                break;

            case R.id.history:
                Intent j = new Intent(Main_Page.this, History.class);
                startActivity(j);
                break;

            case R.id.georaphryic:
                Intent k = new Intent(Main_Page.this, Geographic.class);
                startActivity(k);
                break;

            case R.id.psychology:
                Intent l = new Intent(Main_Page.this, Psychology.class);
                startActivity(l);
                break;
            case R.id.rate:
                try {
                    Uri uril = Uri.parse("market://details?id=" + getPackageName());
                    Intent goTomarket = new Intent(Intent.ACTION_VIEW, uril);
                    startActivity(goTomarket);
                    break;
                } catch (ActivityNotFoundException e) {
                    Uri uril = Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName());
                    Intent goTomarket = new Intent(Intent.ACTION_VIEW, uril);
                    startActivity(goTomarket);
                    break;

                }


        }
    }
}
