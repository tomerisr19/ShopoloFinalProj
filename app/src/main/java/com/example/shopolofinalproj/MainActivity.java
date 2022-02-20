package com.example.shopolofinalproj;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    View signOutBtn;
    View ourFarmsBtn;
    View ordersHistory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signOutBtn = findViewById(R.id.signOut);
        ourFarmsBtn = findViewById(R.id.ourFarms);
        ordersHistory = findViewById(R.id.order_history);

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Activity_ShopMenu.super.onBackPressed();
                startActivity(new Intent(MainActivity.this, Activity_CartActivity.class));
            }
        });

        signOutBtn.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, Activity_Login.class);
            intent.putExtra("signout", true);
            startActivity(intent);
        });

        ourFarmsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Activity_ShopMenu.super.onBackPressed();
                startActivity(new Intent(MainActivity.this, Activity_ShopMenu.class));
            }
        });

        ordersHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Activity_ShopMenu.super.onBackPressed();
                startActivity(new Intent(MainActivity.this, Activity_OrderHistory.class));
            }
        });


}


}

