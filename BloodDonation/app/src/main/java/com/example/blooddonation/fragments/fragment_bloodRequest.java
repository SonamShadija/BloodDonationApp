package com.example.blooddonation.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.blooddonation.R;
import com.example.blooddonation.create_request;

public class fragment_bloodRequest extends Fragment {
    public fragment_bloodRequest() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blood_request,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        replaceFragment(new fragment_nearby());
        BottomNavigationView navigation = (BottomNavigationView) getView().findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = new fragment_nearby();
            switch (item.getItemId()) {
                case R.id.navigation_nearBy:
                    fragment = new fragment_nearby();
                    replaceFragment(fragment);
                    return true;
                case R.id.navigation_dashboard:
                    fragment = new fragment_myRequest();
                    replaceFragment(fragment);
                    return true;
                case R.id.navigation_notifications:
                    fragment = new create_request();
                    replaceFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        /*FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();*/
        transaction.replace(R.id.place_holder, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
