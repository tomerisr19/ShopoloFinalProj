package com.example.shopolofinalproj;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    private MaterialTextView[] products = new MaterialTextView[10];
    private  View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;

    }

    public void initViews(ArrayList<String> arrayList) {
        findViews(view);


    }

    private void findViews(View view) {
        products[0] = view.findViewById(R.id.list_LBL_product1);
        products[1] = view.findViewById(R.id.list_LBL_product2);
        products[2] = view.findViewById(R.id.list_LBL_product3);
        products[3] = view.findViewById(R.id.list_LBL_product4);
        products[4] = view.findViewById(R.id.list_LBL_product5);
        products[5] = view.findViewById(R.id.list_LBL_product6);
        products[6] = view.findViewById(R.id.list_LBL_product7);
        products[7] = view.findViewById(R.id.list_LBL_product8);
        products[8] = view.findViewById(R.id.list_LBL_product9);

    }


}