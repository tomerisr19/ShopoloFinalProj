package com.example.shopolofinalproj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity_ShopManager extends AppCompatActivity {

    Button cucumberBtn;
    Button tomatoBtn;
    Button carrotBtn;
    Button onionBtn;
    Button lettuceBtn;

    ImageView cartBtn;
    ArrayList<String> cartList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_row);

        cucumberBtn = findViewById(R.id.addToCartCucumber);
        tomatoBtn = findViewById(R.id.addToCartTomato);
        carrotBtn = findViewById(R.id.addToCartCarrot);
        lettuceBtn = findViewById(R.id.addToCartLatuce);
        onionBtn = findViewById(R.id.addToCartOnion);
        cartBtn = findViewById(R.id.cart_pressed);

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_ShopManager.this, Activity_CartActivity.class);
                intent.putExtra("cartList", cartList);
                startActivity(intent);

            }
        });

        cucumberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               cartList.add("מלפפון");
                Toast.makeText(Activity_ShopManager.this, "מוצר התווסף לעגלה" ,Toast.LENGTH_SHORT).show();
            }
        });
        tomatoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartList.add("עגבניה");
                Toast.makeText(Activity_ShopManager.this, "מוצר התווסף לעגלה" ,Toast.LENGTH_SHORT).show();
            }
        });
        carrotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartList.add("גזר");
                Toast.makeText(Activity_ShopManager.this, "מוצר התווסף לעגלה" ,Toast.LENGTH_SHORT).show();
            }
        });
        lettuceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartList.add("חסה");
                Toast.makeText(Activity_ShopManager.this, "מוצר התווסף לעגלה" ,Toast.LENGTH_SHORT).show();
            }
        });
        onionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartList.add("בצל");
                Toast.makeText(Activity_ShopManager.this, "מוצר התווסף לעגלה" ,Toast.LENGTH_SHORT).show();
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
