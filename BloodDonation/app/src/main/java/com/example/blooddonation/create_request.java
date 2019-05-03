package com.example.blooddonation;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;


public class create_request extends Fragment {
    Calendar myCalendar = Calendar.getInstance();

     private Button btnsave;
     private EditText pname,mno,addr,Date,pcode,city;
     private Spinner type,cap;
     private DatabaseReference databaseReference;
     boolean check=false;

     DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener(){
         @Override
         public void onDateSet(DatePicker view,int year, int monthOfYear, int dayOfMonth){
             myCalendar.set(Calendar.YEAR, year);
             myCalendar.set(Calendar.MONTH, monthOfYear);
             myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
             updateLabel();
         }
     };
    private String phone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_request, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Context context = getActivity();

        databaseReference = FirebaseDatabase.getInstance().getReference("bloodRequest");

        btnsave=view.findViewById(R.id.Button_save);
        pname= view.findViewById(R.id.editText_name);
        mno =view.findViewById(R.id.editText_mobile_no);
        addr=view.findViewById(R.id.editText_address);
        Date=view.findViewById(R.id.editText_date);
        pcode=view.findViewById(R.id.editText_pcode);
        city=view.findViewById(R.id.editText_city);
        type=view.findViewById(R.id.spinner_type);
        cap=view.findViewById(R.id.spinner_capacity);

        Date.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), date,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                CreateRequest();
            }
        });

    }

    private void CreateRequest(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("bloodRequest");
        String key = myRef.push().getKey();

        String paname = pname.getText().toString().trim();
        String phoneno = mno.getText().toString().trim();
        String add = addr.getText().toString().trim();
        String pin = pcode.getText().toString().trim();
        String town = city.getText().toString().trim();
        String bloodg = type.getSelectedItem().toString();
        Long bloodu = Long.parseLong(cap.getSelectedItem().toString());
        String date = Date.getText().toString().trim();

        if (!TextUtils.isEmpty(paname)&&!TextUtils.isEmpty(phoneno)&&!TextUtils.isEmpty(add)&&!TextUtils.isEmpty(pin)&&!TextUtils.isEmpty(town)&&!TextUtils.isEmpty(date)){

            isValidMobile(phoneno);
            if(check) {
                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                myRef.child(uid).child(key).setValue(FirebaseAuth.getInstance().getCurrentUser().getUid());
                myRef.child(uid).child(key).child("name").setValue(paname);
                myRef.child(uid).child(key).child("no").setValue(phoneno);
                myRef.child(uid).child(key).child("address").setValue(add);
                myRef.child(uid).child(key).child("pincode").setValue(pin);
                myRef.child(uid).child(key).child("city").setValue(town);
                myRef.child(uid).child(key).child("bloodGroup").setValue(bloodg);
                myRef.child(uid).child(key).child("bloodUnit").setValue(bloodu);
                myRef.child(uid).child(key).child("date").setValue(date);


                Toast.makeText(getActivity(), "Request created succesfully", Toast.LENGTH_SHORT).show();

                // Clearing fields
                pname.setText("");
                mno.setText("");
                addr.setText("");
                pcode.setText("");
                city.setText("");
                type.setSelection(0);
                cap.setSelection(0, true);
                Date.setText("");
            }
        }
        else
            {
            Toast.makeText(getActivity(),"Please enter all details ", Toast.LENGTH_SHORT).show();
            }
    }


    private  void updateLabel()
    {
        String myFormat = "dd/MM/yy";
        SimpleDateFormat sdf= new SimpleDateFormat(myFormat, Locale.ENGLISH);
        Date.setText(sdf.format(myCalendar.getTime()));
    }

    private boolean isValidMobile(String phone) {


        if(!Pattern.matches("[a-zA-Z]+", phone))
        {
           // if(phone.length() < 6 || phone.length() > 10) {
                if(phone.length() != 10)
                {
                check = false;
                Toast.makeText(getActivity(),"Please enter valid no ", Toast.LENGTH_SHORT).show();
                mno.setError("Not Valid Number");
               }
               else {
                check = true;
               }
        } else {
            check=false;
        }
        return check;
    }



}
