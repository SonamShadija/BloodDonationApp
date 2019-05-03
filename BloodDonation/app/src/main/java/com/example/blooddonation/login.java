package com.example.blooddonation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
     private FirebaseUser currentUser;
     private FirebaseAuth mAuth;
    private ProgressDialog loadingBar;

    private Button btn;
     private Button btn2;
     private Button btn3;
    private EditText edtextemail,edtextpassword;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Context context = getApplicationContext();
        FirebaseApp.initializeApp(context);
        mAuth= FirebaseAuth.getInstance();
        currentUser= mAuth.getCurrentUser();


        btn = findViewById(R.id.button_sign_in);
        btn2 = findViewById(R.id.button_register);
        btn3 = findViewById(R.id.btn_forgot_pass);

        initializeFields();



        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                /*Intent intent = new Intent(login.this,options.class);
                startActivity(intent);*/
                AllowUserToLogin();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(login.this,registerhere.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(login.this,forgotpass.class);
                startActivity(intent);
            }
        });
    }

    private void AllowUserToLogin()
    {
        email = edtextemail.getText().toString();
        String password = edtextpassword.getText().toString();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingBar.setTitle("Sign In");
            loadingBar.setMessage("Please wait...");
            loadingBar.setCanceledOnTouchOutside(true);
            loadingBar.show();

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if(task.isSuccessful())
                            {
                                Intent intent = new Intent(login.this,options.class);
                                intent.putExtra("email",email);
                                startActivity(intent);
                                Toast.makeText(login.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }
                            else
                            {
                                String message= task.getException().toString();
                                Toast.makeText(login.this, "Error "+message, Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }

                        }
                    });
        }
    }

    private void initializeFields()
    {

            btn = findViewById(R.id.button_sign_in);
            edtextemail=findViewById(R.id.editText_email);
            edtextpassword=findViewById(R.id.editText_password);
            loadingBar= new ProgressDialog(this);

    }
}
