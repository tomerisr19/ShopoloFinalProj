package com.example.shopolofinalproj;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

public class Activity_CartActivity extends AppCompatActivity {

    Button payBtn;
    Button cartHistoryBtn;
    EditText dateBtn;
    String date;
    Order order = new Order();

    ArrayList<String> cartArrList = new ArrayList<>();
    private MaterialTextView[] products = new MaterialTextView[10];
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_current_order);
        dateBtn = findViewById(R.id.date_EDT);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference orderRef = database.getReference("order");

        cartHistoryBtn = findViewById(R.id.cart_BTN_history);
        cartHistoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Activity_ShopMenu.super.onBackPressed();
                startActivity(new Intent(Activity_CartActivity.this, Activity_OrderHistory.class));
            }
        });

        payBtn = findViewById(R.id.pay_orders_BTN);
        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date = dateBtn.getText().toString();
                order.setDate(date);
                order.setOrderList(cartArrList);
                orderRef.child(String.valueOf(Calendar.getInstance().getTime())).setValue(order);
                Toast.makeText(Activity_CartActivity.this, "הזמנתך נקלטה במערכת - התשלום יתבצע במזומן" ,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Activity_CartActivity.this, MainActivity.class));
            }
        });

        cartArrList = getIntent().getStringArrayListExtra("cartList");
        products[0] = findViewById(R.id.list_LBL_product1);
        products[1] = findViewById(R.id.list_LBL_product2);
        products[2] = findViewById(R.id.list_LBL_product3);
        products[3] = findViewById(R.id.list_LBL_product4);
        products[4] = findViewById(R.id.list_LBL_product5);
        products[5] = findViewById(R.id.list_LBL_product6);
        products[6] = findViewById(R.id.list_LBL_product7);
        products[7] = findViewById(R.id.list_LBL_product8);
        products[8] = findViewById(R.id.list_LBL_product9);


        for (int i = 0; i < cartArrList.size(); i++) {
            products[i].setText(cartArrList.get(i));
        }

        dateBtn.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DATE);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    String curDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                    dateBtn.setText(curDate);
                }
            }, year, month, day);
            datePickerDialog.show();
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
