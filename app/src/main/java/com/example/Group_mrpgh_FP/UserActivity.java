package com.example.Group_mrpgh_FP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.Group_mrpgh_FP.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {

    ActivityUserBinding binding;
    int img[] = {R.drawable.icon01_01, R.drawable.icon01_02, R.drawable.icon01_03, R.drawable.icon01_04,
            R.drawable.icon01_05, R.drawable.icon01_06, R.drawable.icon01_07, R.drawable.icon01_08,
            R.drawable.icon01_09, R.drawable.icon01_10, R.drawable.icon01_11, R.drawable.icon01_12,
            R.drawable.icon01_13, R.drawable.icon01_14, R.drawable.icon01_15,
            R.drawable.icon01_16, R.drawable.icon01_17, R.drawable.icon01_18, R.drawable.icon01_19,
            R.drawable.icon01_20, R.drawable.icon01_21, R.drawable.icon01_22, R.drawable.icon01_23,
            R.drawable.icon01_24, R.drawable.icon01_25, R.drawable.icon01_26, R.drawable.icon01_27,
            R.drawable.icon01_28, R.drawable.icon01_29, R.drawable.icon01_30};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent!=null){
            String name = intent.getStringExtra("name");
            String email = intent.getStringExtra("email");
            String phone = intent.getStringExtra("phone");
            int imgID = intent.getIntExtra("imgID",0);

            binding.profileName.setText(name);
            binding.profileEmail.setText(email);
            binding.profileMobile.setText(phone);
            binding.profilePic.setImageResource(img[imgID]);
        }
    }
}