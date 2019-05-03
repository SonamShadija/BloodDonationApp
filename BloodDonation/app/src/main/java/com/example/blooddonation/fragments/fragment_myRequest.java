package com.example.blooddonation.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.blooddonation.R;
import com.example.blooddonation.adapters.NearBy_Adapter;
import com.example.blooddonation.models.NearBY;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;


public class fragment_myRequest extends Fragment {

    private RecyclerView recyclerView;
    private List<NearBY> nearBYList;
    private NearBy_Adapter nearBy_adapter;
    private DatabaseReference databaseReference;


    public fragment_myRequest() {
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
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference("bloodRequest");


        Query mQuery = databaseReference.child(uid);
        mQuery.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot ds,  String s) {
                    if (ds.exists())
                    {
                            Log.d("Aman",ds.toString());
                            String name = ds.child("name").getValue(String.class);

                            String address = ds.child("address").getValue(String.class);
                            String bloodType = ds.child("bloodGroup").getValue(String.class);
                            String phone = ds.child("no").getValue(String.class);
                            Long capacity = ds.child("bloodUnit").getValue(Long.class);

                            NearBY nearBY = new NearBY(name,address,bloodType,capacity,phone);

                            nearBYList.add(nearBY);

                        nearBy_adapter.notifyDataSetChanged();
                    }
                }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
