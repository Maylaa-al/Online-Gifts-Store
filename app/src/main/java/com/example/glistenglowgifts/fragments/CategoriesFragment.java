package com.example.glistenglowgifts.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;


import com.example.glistenglowgifts.Cats;
import com.example.glistenglowgifts.CustomGridViewAdapter;
import com.example.glistenglowgifts.CustomListViewAdapter;
import com.example.glistenglowgifts.R;
import com.google.android.material.internal.MultiViewUpdateListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoriesFragment extends Fragment {

    private boolean isGridView;
    private ToggleButton toggleButton;
    FragmentManager fm;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER to pass arguments to the fragment
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView listView;
    private Object Menu;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoriesFragment.
     */
    // TODO: Rename and change types and number of parameters

    // Sets the arguments for the fragment and returns the created instance
    public static CategoriesFragment newInstance(String param1, String param2) {
        CategoriesFragment fragment = new CategoriesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    // This method is called when the fragment is being created
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) { // Retrieve any arguments passed to the fragment and stores them in mParam1 and mParam2
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    // This method is called when the UI is created
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        // Decide which layout to inflate based on the isGridView flag
        View view = inflater.inflate( R.layout.fragment_categories , container, false);


        // Initialize UI components
        ListView listView = view.findViewById(R.id.cat_list_view);

        int forWomenImg = R.drawable.women;
        int forMenImg = R.drawable.men;
        int forKidsImg = R.drawable.kids;
        int handmadeImg = R.drawable.handmade;

        TextView description = view.findViewById(R.id.description);
//        SwitchCompat toggleButton = view.findViewById(R.id.list_view_switch);
        ArrayList<Cats> cats = new ArrayList<>();
        cats.add(new Cats(forWomenImg, "For Women", "some testing description for women"));
        cats.add(new Cats(forMenImg, "For Men", "Some testing description for men"));
        cats.add(new Cats(forKidsImg, "For Little Ones", "Some testing description for little ones"));
        cats.add(new Cats(handmadeImg, "Handmade Gifts Ideas", "Some testing description for handmade gifts ideas"));

        // The adapter is the bridge between the data source and the UI element (List/Grid/Recycle view)
        CustomListViewAdapter adapter = new CustomListViewAdapter(getContext(), cats);
        listView.setAdapter(adapter);
        GridView gridView = view.findViewById(R.id.cat_grid_view);

        CustomGridViewAdapter gridAdapter = new CustomGridViewAdapter(getContext(), cats);
        gridView.setAdapter(gridAdapter);

//        if (gridView != null) {
//             gridAdapter = new CustomGridViewAdapter(getContext(), cats);
//            gridView.setAdapter(gridAdapter);
//        } else {
//            Log.e("Categories Fragment","Grid View is null");
//        }

        ImageButton listBtn = view.findViewById(R.id.list_button);
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_nav_categories_to_catListFragment);
               // #######################3
            }
        });

//        ImageButton gridButton = view.findViewById(R.id.grid_button);
//        gridButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(view).navigate(R.id.action_catListFragment_to_nav_categories);
//            }
//        });

            return view;
        }

//    public void setGridView(boolean isGridView) {
//        this.isGridView = isGridView;
//    }

    }
