package com.example.blooddonation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.blooddonation.adapters.NearBy_Adapter;
import com.example.blooddonation.models.NearBY;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class test extends Fragment {

    TextView hname,hadd,hno;

    public test() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hname=view.findViewById(R.id.tvhospname);
        hadd= view.findViewById(R.id.tvhospadd);
        hno =view.findViewById(R.id.tvhospno);

            Bundle bundle=getArguments();
            hname.setText(String.valueOf(bundle.getString("hospname")));
            hadd.setText(String.valueOf(bundle.getString("hospadd")));
            hno.setText(String.valueOf(bundle.getString("hospno")));
    }
}



