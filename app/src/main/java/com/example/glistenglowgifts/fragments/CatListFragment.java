package com.example.glistenglowgifts.fragments;

import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.glistenglowgifts.Cats;
import com.example.glistenglowgifts.CustomListViewAdapter;
import com.example.glistenglowgifts.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CatListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CatListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CatListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CatListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CatListFragment newInstance(String param1, String param2) {
        CatListFragment fragment = new CatListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cat_list, container, false);

        // Initialize UI components
        ListView listView = view.findViewById(R.id.cat_list_view);

        int forWomenImg = R.drawable.women;
        int forMenImg = R.drawable.men;
        int forKidsImg = R.drawable.kids;
        int handmadeImg = R.drawable.handmade;

        ArrayList<Cats> cats = new ArrayList<>();
        cats.add(new Cats(forWomenImg, "For Women", "some testing description for women"));
        cats.add(new Cats(forMenImg, "For Men", "Some testing description for men"));
        cats.add(new Cats(forKidsImg, "For Little Ones", "Some testing description for little ones"));
        cats.add(new Cats(handmadeImg, "Handmade Gifts Ideas", "Some testing description for handmade gifts ideas"));

        // The adapter is the bridge between the data source and the UI element (List/Grid/Recycle view)
        CustomListViewAdapter adapter = new CustomListViewAdapter(getContext(), cats);
        listView.setAdapter(adapter);


        return view;
    }
}