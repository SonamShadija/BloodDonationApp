package com.example.blooddonation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.blooddonation.fragments.fragment_home;
import com.example.blooddonation.fragments.fragment_nearby;


public class bloodbank extends Fragment {


    public bloodbank() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_bloodbank, container, false);

        final String[] menuItems = new String[]{"Kem Hospital Blood Bank", "Pune Blood Bank", "Deenanath Mangeshkar Hospital",
                "T B Hospital Aundh","Shivam Blood Bank","Chakan Blood Bank","Saswat Blood Bank","Inlaks and Budhrani Hospital"};

        ListView listView = view.findViewById(R.id.list);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, menuItems);
        listView.setAdapter(listViewAdapter);
        //return view;

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (position == 0)
                {


                    String hname = "Kem Hospital Blood Bank";
                    String hadd = "1st Floor Asha Wing Dr Banoo Soyaji Building, Main Road, Rasta Peth, Pune - 411011, Near MSEB Board ";
                    String hno = "020 66037300";
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    Fragment fragment = new test();

                    Bundle bundle = new Bundle();
                    bundle.putString("hospname", hname);
                    bundle.putString("hospadd", hadd);
                    bundle.putString("hospno", hno);


                    fragment.setArguments(bundle); //data being send to SecondFragment
                    transaction.replace(R.id.bloodBank_container, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

                }
                if(position == 1)
                {
                    String hname = "Pune Blood Bank";
                    String hadd = "Ground Floor, Orient Villa, Hadapsar, Pune - 411028, Near Sanjeevani Hospital and PMT Building Gadital ";
                    String hno = "+91 8208555090";
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    Fragment fragment = new test();

                    Bundle bundle = new Bundle();
                    bundle.putString("hospname", hname);
                    bundle.putString("hospadd", hadd);
                    bundle.putString("hospno", hno);


                    fragment.setArguments(bundle); //data being send to SecondFragment
                    transaction.replace(R.id.bloodBank_container, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

                }

                  if (position == 2)
                {


                    String hname = "Deenanath Mangeshkar Hospital";
                    String hadd = "Erandwane, Pune - 411004, Near Mhatre Bridge";
                    String hno = "020 66023000";
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    Fragment fragment = new test();

                    Bundle bundle = new Bundle();
                    bundle.putString("hospname", hname);
                    bundle.putString("hospadd", hadd);
                    bundle.putString("hospno", hno);


                    fragment.setArguments(bundle); //data being send to SecondFragment
                    transaction.replace(R.id.bloodBank_container, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

                }
                 if(position == 3)
                {
                    String hname = "T B Hospital Aundh";
                    String hadd = "Erandwane, Pune - 411004, Near Mhatre Bridge";
                    String hno = "+91 8769856754";
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    Fragment fragment = new test();

                    Bundle bundle = new Bundle();
                    bundle.putString("hospname", hname);
                    bundle.putString("hospadd", hadd);
                    bundle.putString("hospno", hno);


                    fragment.setArguments(bundle); //data being send to SecondFragment
                    transaction.replace(R.id.bloodBank_container, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

                }
                if (position == 4)
                {


                    String hname = "Shivam Blood Bank";
                    String hadd = "Pune Solapur Road, Loni Kalbhor, Pune - 412201, Near Kawadi Pat Toll Naka, Next To Dsk Supinfocom College,Pposite Manali Resort, Fursung";
                    String hno = "+91 9370108108";
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    Fragment fragment = new test();

                    Bundle bundle = new Bundle();
                    bundle.putString("hospname", hname);
                    bundle.putString("hospadd", hadd);
                    bundle.putString("hospno", hno);


                    fragment.setArguments(bundle); //data being send to SecondFragment
                    transaction.replace(R.id.bloodBank_container, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

                }
                if(position == 5)
                {
                    String hname = "Chakan Blood Bank";
                    String hadd = "Survey No 4976, Ambethan Road, Chakan, Pune - 410501, Near Yashwant Nagar At Post Chakan Taluka Khed";
                    String hno = "+91 7719955050";
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    Fragment fragment = new test();

                    Bundle bundle = new Bundle();
                    bundle.putString("hospname", hname);
                    bundle.putString("hospadd", hadd);
                    bundle.putString("hospno", hno);


                    fragment.setArguments(bundle); //data being send to SecondFragment
                    transaction.replace(R.id.bloodBank_container, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

                }
                if (position == 6)
                {


                    String hname = "Saswat Blood Bank";
                    String hadd = "Wantmure Corner, Miraj, Sangli - 416410, Behind Sarvamangal Hospita";
                    String hno = "+91 8390386825";
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    Fragment fragment = new test();

                    Bundle bundle = new Bundle();
                    bundle.putString("hospname", hname);
                    bundle.putString("hospadd", hadd);
                    bundle.putString("hospno", hno);


                    fragment.setArguments(bundle); //data being send to SecondFragment
                    transaction.replace(R.id.bloodBank_container, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

                }
                 if(position == 7)
                {
                    String hname = "Inlaks and Budhrani Hospital";
                    String hadd = "Lane 1 North Main Road, Koregaon Park, Pune - 411001, Opposite Osho Ashram";
                    String hno = "020 66099727";
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    Fragment fragment = new test();

                    Bundle bundle = new Bundle();
                    bundle.putString("hospname", hname);
                    bundle.putString("hospadd", hadd);
                    bundle.putString("hospno", hno);


                    fragment.setArguments(bundle); //data being send to SecondFragment
                    transaction.replace(R.id.bloodBank_container, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

                }


            }
        });

        return view;

    }
}

   /* public void replaceFragment(Fragment somt) {
        fragment.setArguments(bundle);
        transaction.replace(R.id.bloodBank_container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();*/

