package com.example.blooddonation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgotpass extends AppCompatActivity {

    private Button btn;
    private EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);

        btn= findViewById(R.id.button_resetpass);
        email=findViewById(R.id.tvhospno);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                String email1 =email.getText().toString();
                if (!TextUtils.isEmpty(email1)) {
                    Toast.makeText(forgotpass.this,"Instructions have been sent to your email",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(forgotpass.this,"Feilds are compulsory",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
