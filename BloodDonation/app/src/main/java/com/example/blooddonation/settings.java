package com.example.blooddonation;

import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.blooddonation.fragments.fragment_home;

public class settings extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btn1 = findViewById(R.id.button_forgot_pass);
        btn2 = findViewById(R.id.button_chnage_pass);
        btn3 = findViewById(R.id.button_feedback);
        btn4 = findViewById(R.id.button_logout);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(settings.this,forgotpass.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(settings.this,changepassword.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(settings.this,Feedback1.class);
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                final AlertDialog.Builder builder= new AlertDialog.Builder(settings.this);
                builder.setTitle("Alert!!!!");
                builder.setMessage("Are you sure ou want to logout");
                builder.setCancelable(false);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Intent intent = new Intent(settings.this,login.class);
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.cancel();

                    }


                });

                AlertDialog alert = builder.create();
                alert.show();

            }
        });
    }
}
