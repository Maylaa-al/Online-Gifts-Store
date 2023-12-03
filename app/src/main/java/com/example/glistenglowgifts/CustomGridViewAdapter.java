package com.example.glistenglowgifts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;

import com.example.glistenglowgifts.fragments.ForHerFragment;

import java.util.ArrayList;

// Adapters are responsible for taking data from a data source, such as an array, list, or database, and binding it to the UI elements within a view

// Adapters handle user interaction with the data items
public class CustomGridViewAdapter extends ArrayAdapter<Cats> {
//    ArrayList<Cats> cats;
    private OnCatClickListener listener;


    public CustomGridViewAdapter(@NonNull Context context, @NonNull ArrayList<Cats> cats) {
        super(context, 0, cats);

    }

    public interface OnCatClickListener {
        void onCatClick(Cats cat);
    }

    public void setOnCatCickListener(OnCatClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    /*
    * Customizing how each item in a GridView is displayed.
    * This method is called by the Android system for each data item in the adapter's data source
    * to create and configure the corresponding view that will be displayed within the GridView.*/
    public View getView(int i, @NonNull View convertView2, @NonNull ViewGroup parent) {
        //  Retrieve the Cats object (a category) at the specified position i from the adapter's data source (cats).
        Cats cat = getItem(i);

        if(convertView2 == null) {
            convertView2 = LayoutInflater.from(getContext()).inflate(R.layout.cat_grid_view, parent, false);
        }
            TextView gridName = convertView2.findViewById(R.id.grid_textView);
            ImageView gridImageView = convertView2.findViewById(R.id.grid_imageView);
            gridName.setText(cat.getName());
            gridImageView.setImageResource(cat.getImage());

            // Pass the data to the destination fragment (Bundle)
            convertView2.setOnClickListener(new View.OnClickListener() {
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

        return convertView2;
    }

    }

