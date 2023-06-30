package com.example.cinehub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SeeAllEnglishFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SeeAllEnglishFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<MovieModel> arrayList;
    VerticalAdapter verticalAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SeeAllEnglishFragment() {
        // Required empty public constructor
    }

    public SeeAllEnglishFragment(ArrayList<MovieModel> arrayList) {
        this.arrayList = arrayList;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SeeAllEnglishFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SeeAllEnglishFragment newInstance(String param1, String param2) {
        SeeAllEnglishFragment fragment = new SeeAllEnglishFragment();
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
        View view = inflater.inflate(R.layout.fragment_see_all_english, container, false);
        LinearLayout llback = view.findViewById(R.id.llback);
        llback.setOnClickListener(v -> getActivity().onBackPressed());

        recyclerView = view.findViewById(R.id.allrecyclerView4);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        verticalAdapter = new VerticalAdapter(getContext(), arrayList);
        recyclerView.setAdapter(verticalAdapter);
        return view;
    }
}