package com.example.Group_mrpgh_FP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class Register extends AppCompatActivity {

    //    DatabaseHelper mDatabaseHelper;
    Button save;
    EditText name, email, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        save = findViewById(R.id.save);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.mobile);
//        mDatabaseHelper = new DatabaseHelper(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nam, mail, pho;
                nam = name.getText().toString().trim();
                mail = email.getText().toString();
                pho = phone.getText().toString();
                int imgID = new Random().nextInt(30);

                if(nam.length()!=0 && mail.length()!=0 && pho.length()!=0){
                    name.setText("");
                    email.setText("");
                    phone.setText("");
                    Intent intent = new Intent(Register.this,Captcha.class);
                    intent.putExtra("nam",nam);
                    intent.putExtra("mail",mail);
                    intent.putExtra("pho",pho);
                    intent.putExtra("imgID", imgID);
                    startActivity(intent);
//                    AddData(nam, mail, pho, imgID);
//                    startActivity(new Intent(Register.this, MainActivity.class));
                }else {
                    Toast.makeText(Register.this, "you should fil all the fields", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
//    public void AddData(String newName, String newMail, String newPhone, int imgId){
//        boolean insertData = mDatabaseHelper.addData(newName, newMail, newPhone, imgId);
//        if (insertData) {
//            toastMessage("Data Successfully Inserted!");
//        }else {
//            toastMessage("Something went wrong");
//        }
//    }
//
//    private void toastMessage(String message){
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
//    }
}