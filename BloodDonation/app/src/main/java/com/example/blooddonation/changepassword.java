package com.example.blooddonation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class changepassword extends AppCompatActivity {
    private Button btn;
    private EditText edemail;
    private EditText old;
    private EditText newp;
    private EditText con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);

        btn = findViewById(R.id.button_change);
        edemail = findViewById(R.id.editTextEmail);
        old = findViewById(R.id.editTextOld);
        newp = findViewById(R.id.editTextNew);
        con = findViewById(R.id.editTextConfirm);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edemail.getText().toString();
                String oldpass = old.getText().toString();
                String newpass = newp.getText().toString();
                String conpass = con.getText().toString();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(oldpass) || TextUtils.isEmpty(newpass) || TextUtils.isEmpty(conpass)) {
                    Toast.makeText(changepassword.this, "All the fields are complulsory", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(changepassword.this, "Instructions have been sent to your email", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
