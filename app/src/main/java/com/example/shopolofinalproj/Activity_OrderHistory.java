package com.example.shopolofinalproj;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Activity_OrderHistory extends AppCompatActivity {


    ArrayList<String> ordersArr = new ArrayList<>();
    private MaterialTextView[] orders = new MaterialTextView[9];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);


        orders[0] = findViewById(R.id.list_LBL_orders1);
        orders[1] = findViewById(R.id.list_LBL_orders2);
        orders[2] = findViewById(R.id.list_LBL_orders3);
        orders[3] = findViewById(R.id.list_LBL_orders4);
        orders[4] = findViewById(R.id.list_LBL_orders5);
        orders[5] = findViewById(R.id.list_LBL_orders6);
        orders[6] = findViewById(R.id.list_LBL_orders7);
        orders[7] = findViewById(R.id.list_LBL_orders8);
        orders[8] = findViewById(R.id.list_LBL_orders9);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("order");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ordersArr.clear();
                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    ordersArr.add(snapshot1.getValue().toString());
                }

                for (int i = 0; i < ordersArr.size(); i++) {
                    orders[i].setText(ordersArr.get(i).toString());
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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
