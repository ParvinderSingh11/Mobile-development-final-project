package com.example.Group_mrpgh_FP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.Group_mrpgh_FP.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ActivityMainBinding binding;
    DatabaseHelper mDatabaseHelper;
    private ListView listView;
    Button addUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //new
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addUser = (Button) findViewById(R.id.addUser);
        listView = (ListView) findViewById(R.id.listView);
        mDatabaseHelper = new DatabaseHelper(this);

        //new
        //3214binding =ActivityMainBinding.inflate(getLayoutInflater());


        populateListView();

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });
    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        Cursor data = mDatabaseHelper.getData();
        ArrayList<User> listData = new ArrayList<>();
        while (data.moveToNext()){
            User user = new User(data.getString(1),data.getString(2),
                    data.getString(3),data.getInt(4));
            listData.add(user);
        }
        ListAdapter listAdapter = new ListAdapter(this, listData);
//        mlistView.setAdapter(adapter);
        binding.listView.setAdapter(listAdapter);
        binding.listView.setClickable(true);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                ClipData.Item item = (ClipData.Item) adapterView.getItemAtPosition(i);
//                String name, email, mobile;
//                int imageId = ;
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                intent.putExtra("name", listData.get(i).name);
                intent.putExtra("email", listData.get(i).email);
                intent.putExtra("phone", listData.get(i).mobile);
                intent.putExtra("imgID", listData.get(i).imageId);
                startActivity(intent);

            }
        });
    }

//    public void AddData(String newEntry){
//        boolean insertData = mDatabaseHelper.addData(newEntry);
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