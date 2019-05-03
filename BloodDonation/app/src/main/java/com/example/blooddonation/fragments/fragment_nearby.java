package com.example.blooddonation.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.blooddonation.R;
import com.example.blooddonation.adapters.NearBy_Adapter;
import com.example.blooddonation.models.NearBY;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class fragment_nearby extends Fragment {

    private RecyclerView recyclerView;
    private List<NearBY> nearBYList;
    private NearBy_Adapter nearBy_adapter;
    private DatabaseReference databaseReference;


    public fragment_nearby() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nearby, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_nearby);
        recyclerView.setHasFixedSize(true);
        nearBYList = new ArrayList<>();
        nearBy_adapter = new NearBy_Adapter(getActivity(),nearBYList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(nearBy_adapter);

        final String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference("bloodRequest");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists())
                {
                    for(DataSnapshot ds : dataSnapshot.getChildren()) {
                        String ckey = ds.getKey();
                        if(ds.getKey().equals(uid)){
                            continue;
                        }
                        for(DataSnapshot ds1 :ds.getChildren()) {
                            String name = ds1.child("name").getValue(String.class);
                            String address = ds1.child("address").getValue(String.class);
                            String bloodType = ds1.child("bloodGroup").getValue(String.class);
                            String phone = ds1.child("no").getValue(String.class);
                            Long capacity = ds1.child("bloodUnit").getValue(Long.class);

                            NearBY nearBY = new NearBY(name, address, bloodType, capacity, phone);

                            nearBYList.add(nearBY);

                            nearBy_adapter.notifyDataSetChanged();
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
