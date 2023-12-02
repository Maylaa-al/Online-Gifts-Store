package com.example.glistenglowgifts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

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

            // Pass the data to the destination fragment (Bundle)
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cat.getName().equals("For Women")) {
                        Navigation.findNavController(view).navigate(R.id.action_nav_categories_to_forHerFragment);
                    }
                    if (cat.getName().equals("For Men")) {
                        Navigation.findNavController(view).navigate(R.id.action_nav_categories_to_forHimFragment);
                    }
                    if (cat.getName().equals("Handmade Gifts Ideas")) {
                        Navigation.findNavController(view).navigate(R.id.action_nav_categories_to_handmadeFragment);
                    }
                    if (cat.getName().equals("For Little Ones")) {
                        Navigation.findNavController(view).navigate(R.id.action_nav_categories_to_forLittleOnesFragment);
                    }
                }
            });
        }
        return convertView;
    }

}
