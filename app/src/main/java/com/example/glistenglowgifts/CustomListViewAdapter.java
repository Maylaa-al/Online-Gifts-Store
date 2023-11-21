package com.example.glistenglowgifts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewAdapter extends ArrayAdapter<Cats> {


    public CustomListViewAdapter(@NonNull Context context, @NonNull ArrayList<Cats> cats) {
        super(context, 0, cats);
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        Cats cat = getItem(position);
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cat_list_view, parent, false);
            TextView name = convertView.findViewById(R.id.cat_name);
            ImageView imageView = convertView.findViewById(R.id.cat_image);
            name.setText(cat.getName());
            imageView.setImageResource(cat.getImage());
        }
        return convertView;
    }

}
