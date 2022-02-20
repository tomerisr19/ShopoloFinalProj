package com.example.shopolofinalproj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity_ShopMenu extends AppCompatActivity {

    ImageView backBtn;
    ImageView meshekFridman;
    ImageView dorLeDor;
    ImageView aviMarket;
    ImageView bergerFarm;
    ImageView cohenFamily;
    ImageView dodMoshe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_menu);


        backBtn = findViewById(R.id.back_parssed);
        meshekFridman = findViewById(R.id.meshekfridman);
        dorLeDor = findViewById(R.id.dorLeDor);
        aviMarket = findViewById(R.id.aviMarket);
        bergerFarm = findViewById(R.id.bergerFarm);
        cohenFamily = findViewById(R.id.cohenFamily);
        dodMoshe = findViewById(R.id.dodMoshe);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Activity_ShopMenu.super.onBackPressed();
                startActivity(new Intent(Activity_ShopMenu.this, MainActivity.class));
            }
        });

        meshekFridman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Activity_ShopMenu.super.onBackPressed();
                startActivity(new Intent(Activity_ShopMenu.this, Activity_ShopManager.class));
            }
        });

        dorLeDor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Activity_ShopMenu.super.onBackPressed();
                startActivity(new Intent(Activity_ShopMenu.this, Activity_ShopManager.class));
            }
        });

        aviMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Activity_ShopMenu.super.onBackPressed();
                startActivity(new Intent(Activity_ShopMenu.this, Activity_ShopManager.class));
            }
        });

        bergerFarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Activity_ShopMenu.super.onBackPressed();
                startActivity(new Intent(Activity_ShopMenu.this, Activity_ShopManager.class));
            }
        });

        cohenFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Activity_ShopMenu.super.onBackPressed();
                startActivity(new Intent(Activity_ShopMenu.this, Activity_ShopManager.class));
            }
        });

        dodMoshe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Activity_ShopMenu.super.onBackPressed();
                startActivity(new Intent(Activity_ShopMenu.this, Activity_ShopManager.class));
            }
        });

        hideSystemUI();

    }

    public void hideSystemUI() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
}
