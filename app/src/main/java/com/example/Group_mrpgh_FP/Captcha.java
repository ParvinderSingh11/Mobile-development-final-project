package com.example.Group_mrpgh_FP;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class Captcha extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    ImageView img1, img2,img3, img4,img5, img6,img7, img8, img9, refresh;
    ImageView check1, check2, check3, check4, check5, check6, check7, check8, check9;
    CheckBox checkBox;
    Button verify;
    AlertDialog.Builder builder;

    int []traffic = {R.drawable.img1,R.drawable.img2,R.drawable.img3,
            R.drawable.img4,R.drawable.img5,R.drawable.img6,
            R.drawable.img7,R.drawable.img8,R.drawable.img9};

    int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8};

    boolean[] x = new boolean[] {false, false, false,false,false,false, false,false,false} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captcha);
        img1 = findViewById(R.id.imageView1);
        img2 = findViewById(R.id.imageView2);
        img3 = findViewById(R.id.imageView3);
        img4 = findViewById(R.id.imageView4);
        img5 = findViewById(R.id.imageView5);
        img6 = findViewById(R.id.imageView6);
        img7 = findViewById(R.id.imageView7);
        img8 = findViewById(R.id.imageView8);
        img9 = findViewById(R.id.imageView9);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        check4 = findViewById(R.id.check4);
        check5 = findViewById(R.id.check5);
        check6 = findViewById(R.id.check6);
        check7 = findViewById(R.id.check7);
        check8 = findViewById(R.id.check8);
        check9 = findViewById(R.id.check9);
        refresh =findViewById(R.id.refresh);
        checkBox = findViewById(R.id.checkBox);
        verify = (Button) findViewById(R.id.verify);


        mDatabaseHelper = new DatabaseHelper(this);
        builder = new AlertDialog.Builder(this);

        Intent intent = this.getIntent();
        String nam, mail, pho;
        nam = intent.getStringExtra("nam");
        mail = intent.getStringExtra("mail");
        pho = intent.getStringExtra("pho");
        int imgID = intent.getIntExtra("imgID",0);

        ImageView[] imgArr = {img1, img2,img3, img4,img5, img6,img7, img8, img9};
        refreshImg(imgArr);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshImg(imgArr);
            }
        });

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Captcha.this, "Clicked", Toast.LENGTH_SHORT).show();
                if(checkBox.isChecked()){
                    int count =0;
                    for (int i = 0; i < 9; i++) {
                        if(x[i]==true && (arr[i]==0||arr[i]==1||arr[i]==2||arr[i]==3)){
                            count++;
                        }
                    }
                    if (count == 4){
                        builder.setTitle("Verified")
                                .setCancelable(true)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        AddData(nam, mail, pho, imgID);
                                        startActivity(new Intent(Captcha.this, MainActivity.class));
                                        finish();
                                    }
                                }).show();
                    }else {
                        builder.setTitle("Not Verified")
                                .setCancelable(true)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        startActivity(new Intent(Captcha.this, MainActivity.class));
                                        finish();
                                    }
                                }).show();
                    }
                }else{
                    builder.setTitle("Not Verified")
                            .setCancelable(true)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    startActivity(new Intent(Captcha.this, MainActivity.class));
                                    finish();
                                }
                            }).show();
                }
            }
        });

    }

    public void click1(View view) {
        img1.setAlpha(0.5F);
        check1.setVisibility(View.VISIBLE);
        x[0] = true;
    }

    public void click2(View view) {
        img2.setAlpha(0.5F);
        check2.setVisibility(View.VISIBLE);
        x[1] = true;
    }
    public void click3(View view) {
        img3.setAlpha(0.5F);
        check3.setVisibility(View.VISIBLE);
        x[2] = true;
    }

    public void click4(View view) {
        img4.setAlpha(0.5F);
        check4.setVisibility(View.VISIBLE);
        x[3] = true;
    }

    public void click5(View view) {
        img5.setAlpha(0.5F);
        check5.setVisibility(View.VISIBLE);
        x[4] = true;
    }

    public void click6(View view) {
        img6.setAlpha(0.5F);
        check6.setVisibility(View.VISIBLE);
        x[5] = true;
    }

    public void click7(View view) {
        img7.setAlpha(0.5F);
        check7.setVisibility(View.VISIBLE);
        x[6] = true;
    }

    public void click8(View view) {
        img8.setAlpha(0.5F);
        check8.setVisibility(View.VISIBLE);
        x[7] = true;
    }

    public void click9(View view) {
        img9.setAlpha(0.5F);
        check9.setVisibility(View.VISIBLE);
        x[8] = true;
    }

    private void refreshImg(ImageView[] imgArr) {
        int n = arr.length;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(arr, i, change);
        }
        for (int i = 0; i < n; i++){
            imgArr[i].setImageResource(traffic[arr[i]]);
        }
        img1.setAlpha(1F);
        img2.setAlpha(1F);
        img3.setAlpha(1F);
        img4.setAlpha(1F);
        img5.setAlpha(1F);
        img6.setAlpha(1F);
        img7.setAlpha(1F);
        img8.setAlpha(1F);
        img9.setAlpha(1F);
        check1.setVisibility(View.INVISIBLE);
        check2.setVisibility(View.INVISIBLE);
        check3.setVisibility(View.INVISIBLE);
        check4.setVisibility(View.INVISIBLE);
        check5.setVisibility(View.INVISIBLE);
        check6.setVisibility(View.INVISIBLE);
        check7.setVisibility(View.INVISIBLE);
        check8.setVisibility(View.INVISIBLE);
        check9.setVisibility(View.INVISIBLE);

    }

    private void swap(int[] arr, int i, int change) {
        int helper = arr[i];
        arr[i] = arr[change];
        arr[change] = helper;

    }
    public void AddData(String newName, String newMail, String newPhone, int imgId){
        boolean insertData = mDatabaseHelper.addData(newName, newMail, newPhone, imgId);
        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        }else {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}