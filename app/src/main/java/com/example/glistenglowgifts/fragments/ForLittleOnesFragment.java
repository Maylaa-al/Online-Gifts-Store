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
 * Use the {@link ForLittleOnesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForLittleOnesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ForLittleOnesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForLittleOnesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForLittleOnesFragment newInstance(String param1, String param2) {
        ForLittleOnesFragment fragment = new ForLittleOnesFragment();
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
        View view = inflater.inflate(R.layout.fragment_for_little_ones, container, false);
        int atomImg = R.drawable.atom_maze;
        int chainImg = R.drawable.chain_reaction;
        int cookingImg = R.drawable.cooking;
        int growingSeedsImg = R.drawable.growing_seeds;
        int launchAndPlayImg = R.drawable.launch_play;
        int makeItMoveImg = R.drawable.make_it_move;
        int microscopeImg = R.drawable.microscope;
        int oceanExplorerImg = R.drawable.ocean_explorer;
        int oilCleanupImg = R.drawable.oil_cleanup;
        int peekAZppImg = R.drawable.peekazoo;
        int pegboard = R.drawable.pegboard;
        int pixelArt = R.drawable.pixel_art;
        int projector = R.drawable.projector;
        int rampImg = R.drawable.ramp;
        int speakerImg = R.drawable.speaker;

        ArrayList<Term> terms = new ArrayList<Term>();
        terms.add(new Term("Atom Bead Maze", atomImg));
        terms.add(new Term("Growing Seeds Tissue Box Toy", growingSeedsImg));
        terms.add(new Term("Peek A Zoo Puzzle Box", peekAZppImg));
        terms.add(new Term("Ocean Explorer Baby Activity Wedge", oceanExplorerImg));
        terms.add(new Term("Color Wheel Racers and Ramp", rampImg));
        terms.add(new Term("Launch And Play Catapult Games", launchAndPlayImg));
        terms.add(new Term("Chain Reaction Workshop", chainImg));
        terms.add(new Term("Science Of Cooking Ice Cream", cookingImg));
        terms.add(new Term("Environmental Science Oil Cleanup", oilCleanupImg));
        terms.add(new Term("Pixel Art Light box", pixelArt));
        terms.add(new Term("Launch And Play Catapult Games", launchAndPlayImg));
        terms.add(new Term("PegboardGames And Puzzles", pegboard));
        terms.add(new Term("Microscope Exploration Set", microscopeImg));
        terms.add(new Term("Make-It-Move Electronics Set", makeItMoveImg));
        terms.add(new Term("Kinetic Light-Up Speaker", speakerImg));
        terms.add(new Term("Color Projector Lamp", projector));
        RecyclerView recyclerView = view.findViewById(R.id.forLittleOnes_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CustomRecyclerViewAdapter(terms));
        return view;
    }
}