package com.example.blooddonation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class details extends AppCompatActivity {
    private Button btnsave;
    private EditText nme,addr,pcode,btype,email;
    private DatabaseReference databaseReference;
    String eMail = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        eMail = getIntent().getStringExtra("email");
        //Context context = getActivity();
        databaseReference = FirebaseDatabase.getInstance().getReference("Details");


        btnsave=findViewById(R.id.Button_save);
        nme= findViewById(R.id.editText_name);
        addr=findViewById(R.id.editText_address);
        pcode=findViewById(R.id.editText_pcode);
        btype=findViewById(R.id.editText_bg);
        email=findViewById(R.id.editText_email);
        email.setText(eMail);

        btnsave.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               CreateRequest();
           }
       });




        }

        private void CreateRequest(){
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Users");
            String key = FirebaseAuth.getInstance().getCurrentUser().getUid();

            String paname = nme.getText().toString().trim();
            String add = addr.getText().toString().trim();
            Long pin = Long.parseLong(pcode.getText().toString());
            String bloodg = btype.getText().toString().trim();
            String emailid = email.getText().toString().trim();



            if (!TextUtils.isEmpty(paname)&&!TextUtils.isEmpty(bloodg)&&!TextUtils.isEmpty(add)&&!TextUtils.isEmpty(emailid)){
                myRef.child(key).child("name").setValue(paname);
                myRef.child(key).child("address").setValue(add);
                myRef.child(key).child("pincode").setValue(pin);
                myRef.child(key).child("bloodGroup").setValue(bloodg);
                myRef.child(key).child("email").setValue(emailid);


                Intent intent = new Intent(details.this,options.class);
                intent.putExtra("email",eMail);
                startActivity(intent);

                /*// Clearing fields
                nme.setText("");
                addr.setText("");
                pcode.setText("");
                btype.setText("");
                email.setText("");*/




            }
            else
            {
                Toast.makeText(this,"Please enter all details ", Toast.LENGTH_SHORT).show();
            }


        }

    }

