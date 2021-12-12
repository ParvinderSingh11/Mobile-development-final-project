package com.example.Group_mrpgh_FP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<User> {

    int img[] = {R.drawable.icon01_01, R.drawable.icon01_02, R.drawable.icon01_03, R.drawable.icon01_04,
            R.drawable.icon01_05, R.drawable.icon01_06, R.drawable.icon01_07, R.drawable.icon01_08,
            R.drawable.icon01_09, R.drawable.icon01_10, R.drawable.icon01_11, R.drawable.icon01_12,
            R.drawable.icon01_13, R.drawable.icon01_14, R.drawable.icon01_15,
            R.drawable.icon01_16, R.drawable.icon01_17, R.drawable.icon01_18, R.drawable.icon01_19,
            R.drawable.icon01_20, R.drawable.icon01_21, R.drawable.icon01_22, R.drawable.icon01_23,
            R.drawable.icon01_24, R.drawable.icon01_25, R.drawable.icon01_26, R.drawable.icon01_27,
            R.drawable.icon01_28, R.drawable.icon01_29, R.drawable.icon01_30};

    public ListAdapter(Context context, ArrayList<User> userArrayList) {
        super(context, R.layout.list_item, userArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        User user = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        }

        ImageView imageView = convertView.findViewById(R.id.dp);
        TextView userName = convertView.findViewById((R.id.personName));
        TextView email = convertView.findViewById(R.id.demail);
        TextView mobile = convertView.findViewById(R.id.dmobile);

        imageView.setImageResource(img[user.imageId]);
        userName.setText(user.name);
        email.setText(user.email);
        mobile.setText(user.mobile);
        return convertView;
    }
}
