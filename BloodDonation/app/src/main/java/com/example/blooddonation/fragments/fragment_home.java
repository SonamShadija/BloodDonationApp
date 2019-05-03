package com.example.blooddonation.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.blooddonation.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class fragment_home extends Fragment {
    DatabaseReference databaseReference;
    String eMail="";
    public fragment_home()
    {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        eMail = getArguments().getString("email");
        return  inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView tAddress = view.findViewById(R.id.textView_Address1);
        final TextView tname = view.findViewById(R.id.textView_Fullname);
        final TextView pinCode = view.findViewById(R.id.textView_pincode2);
        final TextView bloodGrp = view.findViewById(R.id.textView_blood_group1);
        final TextView tfname = view.findViewById(R.id.text_view_name);

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        Query mQuery = databaseReference.orderByChild("email").equalTo(eMail);
        mQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot ds,  String s) {
                String name="";
                name = ds.child("name").getValue(String.class);
                String address = ds.child("address").getValue(String.class);
                String bloodType = ds.child("bloodGroup").getValue(String.class);
                Long pincode = ds.child("pincode").getValue(Long.class);

                tfname.setText(name);
                tname.setText(name);
                tAddress.setText(address);
                bloodGrp.setText(bloodType);
                pinCode.setText(pincode.toString());
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
