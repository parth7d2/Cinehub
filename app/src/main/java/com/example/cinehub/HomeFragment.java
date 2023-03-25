package com.example.cinehub;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    LinearLayout llTranding_heading, llRecently_heading, llContinue_heading, llEnglish_heading, llHindi_heading;

    RecyclerView trendingRecyclerView;
    RecyclerView recentlyRecyclerView;
    RecyclerView continueRecyclerView;

    RecyclerView englishRecyclerView;

    RecyclerView hindiRecyclerView;


    ArrayList<PosterModel> trendingModelArrayList = new ArrayList<>();
    ArrayList<PosterModel> recentlyModelArrayList = new ArrayList<>();
    ArrayList<PosterModel> continueModelArrayList = new ArrayList<>();

    ArrayList<PosterModel> englishModelArrayList = new ArrayList<>();

    ArrayList<PosterModel> hindiModelArrayList = new ArrayList<>();

    TrendingAdapter trendingAdapter;

    VerticalAdapter verticalAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

//  *************************************** Search View ***************************************

        ImageView imageView = view.findViewById(R.id.img_Search);
        Intent intent = new Intent(getContext(), SearchActivity.class);

        imageView.setOnClickListener(v -> startActivity(intent));

//  *************************************** Trending RecyclerView ***************************************

        trendingRecyclerView = view.findViewById(R.id.trending_recyclerView);
        trendingRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        trendingModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Captain Dheglu: The First Avenger", "Germany to Canada by plan"));
        trendingModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Hera Pheri by Shetty", "Radhe... Radhe..."));
        trendingModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglo: Age of Ultron", "Germany to Canada by train"));
        trendingModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Phir Hera Pheri", "Meri AnuRadha esa nahi karskti"));
        trendingModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Captain Dheglu: Self War", "Germany to Canada by plan"));
        trendingModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Hera Pheri 3", "Radhe... Radhe..."));
        trendingModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglas: Infinity War", "Germany to Canada by train"));
        trendingModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dil De Diya", "Meri AnuRadha esa nahi karskti"));
        trendingModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglas: Endgame", "Germany to Canada by plan"));
        trendingModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Mujhko Yaad Sataye Teri", "Radhe... Radhe..."));
        trendingModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglu🧸 Man", "Germany to Canada by train"));
        trendingModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Main Ladki Pom Pom", "Meri AnuRadha esa nahi karskti"));
        trendingModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglu🧸 Man 2", "Germany to Canada by plan"));
        trendingModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Denewala Jab Bhi Deta Deta Chhappar Phaad Ke", "Radhe... Radhe..."));
        trendingModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglu🧸 Man 3", "Germany to Canada by train"));
        trendingModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Shetty👨‍💻", "Meri AnuRadha esa nahi karskti"));

        trendingAdapter = new TrendingAdapter(getContext(), trendingModelArrayList);
        trendingRecyclerView.setAdapter(trendingAdapter);



//  *************************************** Recently RecyclerView ***************************************

        recentlyRecyclerView = view.findViewById(R.id.recently_recyclerView);
        recentlyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recentlyModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Captain Dheglu: The First Avenger", "Germany to Canada by plan"));
        recentlyModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Hera Pheri by Shetty", "Radhe... Radhe..."));
        recentlyModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglo: Age of Ultron", "Germany to Canada by train"));
        recentlyModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Phir Hera Pheri", "Meri AnuRadha esa nahi karskti"));
        recentlyModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Captain Dheglu: Self War", "Germany to Canada by plan"));
        recentlyModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Hera Pheri 3", "Radhe... Radhe..."));
        recentlyModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglas: Infinity War", "Germany to Canada by train"));
        recentlyModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dil De Diya", "Meri AnuRadha esa nahi karskti"));
        recentlyModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglas: Endgame", "Germany to Canada by plan"));
        recentlyModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Mujhko Yaad Sataye Teri", "Radhe... Radhe..."));
        recentlyModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglu🧸 Man", "Germany to Canada by train"));
        recentlyModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Main Ladki Pom Pom", "Meri AnuRadha esa nahi karskti"));
        recentlyModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglu🧸 Man 2", "Germany to Canada by plan"));
        recentlyModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Denewala Jab Bhi Deta Deta Chhappar Phaad Ke", "Radhe... Radhe..."));
        recentlyModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglu🧸 Man 3", "Germany to Canada by train"));
        recentlyModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Shetty👨‍💻", "Meri AnuRadha esa nahi karskti"));

        verticalAdapter = new VerticalAdapter(getContext(), recentlyModelArrayList);
        recentlyRecyclerView.setAdapter(verticalAdapter);



//  *************************************** Continue RecyclerView ***************************************

        continueRecyclerView = view.findViewById(R.id.continue_recyclerView);
        continueRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        continueModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Captain Dheglu: The First Avenger", "Germany to Canada by plan"));
        continueModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Hera Pheri by Shetty", "Radhe... Radhe..."));
        continueModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglo: Age of Ultron", "Germany to Canada by train"));
        continueModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Phir Hera Pheri", "Meri AnuRadha esa nahi karskti"));
        continueModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Captain Dheglu: Self War", "Germany to Canada by plan"));
        continueModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Hera Pheri 3", "Radhe... Radhe..."));
        continueModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglas: Infinity War", "Germany to Canada by train"));
        continueModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dil De Diya", "Meri AnuRadha esa nahi karskti"));
        continueModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglas: Endgame", "Germany to Canada by plan"));
        continueModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Mujhko Yaad Sataye Teri", "Radhe... Radhe..."));
        continueModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglu🧸 Man", "Germany to Canada by train"));
        continueModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Main Ladki Pom Pom", "Meri AnuRadha esa nahi karskti"));
        continueModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglu🧸 Man 2", "Germany to Canada by plan"));
        continueModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Denewala Jab Bhi Deta Deta Chhappar Phaad Ke", "Radhe... Radhe..."));
        continueModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglu🧸 Man 3", "Germany to Canada by train"));
        continueModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Shetty👨‍💻", "Meri AnuRadha esa nahi karskti"));

        verticalAdapter = new VerticalAdapter(getContext(), continueModelArrayList);
        continueRecyclerView.setAdapter(verticalAdapter);



//  *************************************** English RecyclerView ***************************************

        englishRecyclerView = view.findViewById(R.id.english_recyclerView);
        englishRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        englishModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Captain Dheglu: The First Avenger", "Germany to Canada by plan"));
        englishModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Hera Pheri by Shetty", "Radhe... Radhe..."));
        englishModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglo: Age of Ultron", "Germany to Canada by train"));
        englishModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Phir Hera Pheri", "Meri AnuRadha esa nahi karskti"));
        englishModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Captain Dheglu: Self War", "Germany to Canada by plan"));
        englishModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Hera Pheri 3", "Radhe... Radhe..."));
        englishModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglas: Infinity War", "Germany to Canada by train"));
        englishModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dil De Diya", "Meri AnuRadha esa nahi karskti"));
        englishModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglas: Endgame", "Germany to Canada by plan"));
        englishModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Mujhko Yaad Sataye Teri", "Radhe... Radhe..."));
        englishModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglu🧸 Man", "Germany to Canada by train"));
        englishModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Main Ladki Pom Pom", "Meri AnuRadha esa nahi karskti"));
        englishModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglu🧸 Man 2", "Germany to Canada by plan"));
        englishModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Denewala Jab Bhi Deta Deta Chhappar Phaad Ke", "Radhe... Radhe..."));
        englishModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglu🧸 Man 3", "Germany to Canada by train"));
        englishModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Shetty👨‍💻", "Meri AnuRadha esa nahi karskti"));

        verticalAdapter = new VerticalAdapter(getContext(), englishModelArrayList);
        englishRecyclerView.setAdapter(verticalAdapter);



//  *************************************** Hindi RecyclerView ***************************************

        hindiRecyclerView = view.findViewById(R.id.hindi_recyclerView);
        hindiRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        hindiModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Captain Dheglu: The First Avenger", "Germany to Canada by plan"));
        hindiModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Hera Pheri by Shetty", "Radhe... Radhe..."));
        hindiModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglo: Age of Ultron", "Germany to Canada by train"));
        hindiModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Phir Hera Pheri", "Meri AnuRadha esa nahi karskti"));
        hindiModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Captain Dheglu: Self War", "Germany to Canada by plan"));
        hindiModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Hera Pheri 3", "Radhe... Radhe..."));
        hindiModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglas: Infinity War", "Germany to Canada by train"));
        hindiModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dil De Diya", "Meri AnuRadha esa nahi karskti"));
        hindiModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglas: Endgame", "Germany to Canada by plan"));
        hindiModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Mujhko Yaad Sataye Teri", "Radhe... Radhe..."));
        hindiModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglu🧸 Man", "Germany to Canada by train"));
        hindiModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Main Ladki Pom Pom", "Meri AnuRadha esa nahi karskti"));
        hindiModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglu🧸 Man 2", "Germany to Canada by plan"));
        hindiModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Denewala Jab Bhi Deta Deta Chhappar Phaad Ke", "Radhe... Radhe..."));
        hindiModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Dheglu🧸 Man 3", "Germany to Canada by train"));
        hindiModelArrayList.add(new PosterModel(R.drawable.ic_launcher_background, "Shetty👨‍💻", "Meri AnuRadha esa nahi karskti"));

        verticalAdapter = new VerticalAdapter(getContext(), hindiModelArrayList);
        hindiRecyclerView.setAdapter(verticalAdapter);

//  *************************************** SeeAll View ***************************************

        llTranding_heading = view.findViewById(R.id.llTranding_heading);
        llRecently_heading = view.findViewById(R.id.llRecently_heading);
        llContinue_heading = view.findViewById(R.id.llContinue_heading);
        llEnglish_heading = view.findViewById(R.id.llEnglish_heading);
        llHindi_heading = view.findViewById(R.id.llHindi_heading);

        loadFrag(llTranding_heading, new SeeAllTreandingFragment());
        loadFrag(llRecently_heading, new SeeAllRecentFragment());
        loadFrag(llContinue_heading, new SeeAllContinueFragment());
        loadFrag(llEnglish_heading, new SeeAllEnglishFragment());
        loadFrag(llHindi_heading, new SeeAllHindiFragment());



        return view;
    }

    public void loadFrag(LinearLayout linearLayout, Fragment fragment){
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = fragment.getId();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                fm.popBackStack(String.valueOf(id), FragmentManager.POP_BACK_STACK_INCLUSIVE);
                ft.addToBackStack(String.valueOf(id));
                ft.replace(R.id.framContainer, fragment).commit();
            }
        });
    }
}