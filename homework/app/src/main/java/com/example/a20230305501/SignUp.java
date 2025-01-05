package com.example.a20230305501;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    TextInputLayout reg_Name, reg_UserName, reg_Email, reg_PhoneNo, reg_Password;
    Button reg_Btn, reg_ToLoginBtn;

    //FirebaseDatabase rootNode;
    //DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        reg_Name = findViewById(R.id.regName);
        reg_UserName = findViewById(R.id.regUserName);
        reg_Email = findViewById(R.id.regEmail);
        reg_PhoneNo = findViewById(R.id.regPhoneNo);
        reg_Password = findViewById(R.id.regPassword);
        reg_Btn = findViewById(R.id.regBtn);
        reg_ToLoginBtn = findViewById(R.id.regToLoginBtn);

        reg_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rootNode = FirebaseDatabase.getInstance();
                //reference = rootNode.getReference("users");

                String name = reg_Name.getEditText().getText().toString();
                String username = reg_UserName.getEditText().getText().toString();
                String email = reg_Email.getEditText().getText().toString();
                String phoneNo = reg_PhoneNo.getEditText().getText().toString();
                String password = reg_Password.getEditText().getText().toString();

                UserHelperClass helperClass = new UserHelperClass(name, username, email, phoneNo, password);

                //reference.child(phoneNo).setValue(helperClass);

                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

        reg_ToLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}