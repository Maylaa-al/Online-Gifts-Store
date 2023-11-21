package com.example.glistenglowgifts.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.glistenglowgifts.R;
import com.example.glistenglowgifts.recycleView.CustomRecyclerViewAdapter;
import com.example.glistenglowgifts.recycleView.Term;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ForHerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForHerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ForHerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForHerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForHerFragment newInstance(String param1, String param2) {
        ForHerFragment fragment = new ForHerFragment();
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
        View view = inflater.inflate(R.layout.fragment_for_her, container, false);
        int mapImage = R.drawable.custom_map;
        int sportImg = R.drawable.sport_kit;
        int coffeeImg = R.drawable.coffee;
        int coffeeClubImg = R.drawable.coffee_club;
        int sipsImg = R.drawable.sips_tea;
        int puzzleImg = R.drawable.puzzle;
        int mugImg = R.drawable.mug;
        int flowersImg = R.drawable.urban_stems;
        int noiseCancellingImg = R.drawable.noise_cancelling;
        int kindle = R.drawable.kindle;
        int jBoxImg = R.drawable.j_box;
        int tileImg = R.drawable.tile;
        int candleImg = R.drawable.candel;
        int jeweleryImg = R.drawable.jewelry;

        ArrayList<Term> terms = new ArrayList<Term>();
        terms.add(new Term("Minted Custom Map Filled Foil Art", mapImage));
        terms.add(new Term("Fitness Workout Essential Package", sportImg));
        terms.add(new Term("Whittard Of Chelsea Luxury Hot Chocolate and Marshmallows Gift Set",coffeeImg));
        terms.add(new Term("Atlas Coffee Club Gift Subscription", coffeeClubImg));
        terms.add(new Term("Sips By Personalized Tea Discovery Box", sipsImg));
        terms.add(new Term("Jiggy Personalized Puzzle", puzzleImg));
        terms.add(new Term("Ember Temperature Control Smart Mug 2", mugImg));
        terms.add(new Term("Uncommon Goods Birth Month Flower Grow Kit", flowersImg));
        terms.add(new Term("Bose Noise Cancelling Headphones 700", noiseCancellingImg));
        terms.add(new Term("Amazon Kindle Paperwhite", kindle));
        terms.add(new Term("Mark & Graham Small Travel Jewelry Case", jBoxImg));
        terms.add(new Term("Tile Pro 2-Pack", tileImg));
        terms.add(new Term("Brooklyn Candle Studio Candle of the Month Subscription", candleImg));
        terms.add(new Term("Rocksbox Jewelry Gift Subscription", jeweleryImg));
        RecyclerView recyclerView = view.findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CustomRecyclerViewAdapter(terms));

        return view;
    }
}