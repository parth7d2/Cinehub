package com.example.cinehub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SeeAllTreandingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SeeAllTreandingFragment extends Fragment {

    ArrayList<MovieModel> arrayList;
    RecyclerView recyclerView;

    VerticalAdapter allTrending;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SeeAllTreandingFragment() {
        // Required empty public constructor
    }

    public SeeAllTreandingFragment(ArrayList<MovieModel> arrayList) {
        this.arrayList = arrayList;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SeeAllTreandingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SeeAllTreandingFragment newInstance(String param1, String param2) {
        SeeAllTreandingFragment fragment = new SeeAllTreandingFragment();
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
        View view = inflater.inflate(R.layout.fragment_see_all_treanding, container, false);

        LinearLayout llback = view.findViewById(R.id.llback);
        llback.setOnClickListener(v -> getActivity().onBackPressed());

        recyclerView = view.findViewById(R.id.allrecyclerView1);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);


        allTrending = new VerticalAdapter(getContext(), arrayList);
        recyclerView.setAdapter(allTrending);


        
        return view;
    }

}