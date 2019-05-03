package com.example.blooddonation;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registerhere extends AppCompatActivity {
   private Button btnsignin;
    private EditText edemail,edpassword;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerhere);
        mAuth= FirebaseAuth.getInstance();

        InitializeFields();

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewAccount();
                /*Intent intent = new Intent(registerhere.this,details.class);
                startActivity(intent);*/

            }
        });
    }

    private void createNewAccount() {
        final String email = edemail.getText().toString();
        String password = edpassword.getText().toString();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
        }
        else
        {
           loadingBar.setTitle("Creating New Account");
           loadingBar.setMessage("Please wait, while we are creating an account");
           loadingBar.setCanceledOnTouchOutside(true);
           loadingBar.show();
            
            mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if(task.isSuccessful())
                            {
                                Intent intent = new Intent(registerhere.this,details.class);
                                intent.putExtra("email",email);
                                startActivity(intent);
                                Toast.makeText(registerhere.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }
                            else
                            {
                                String message= task.getException().toString();
                                 Toast.makeText(registerhere.this, "Error "+message, Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }
                        }
                    });

        }
    }

    private void InitializeFields()
    {
        btnsignin=findViewById(R.id.button_sign);
        edemail=findViewById(R.id.editText_email);
        edpassword=findViewById(R.id.editText_password);
        loadingBar= new ProgressDialog(this);
    }
}
