package com.example.cinehub;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    View view;

    BlurView blurView;

    LinearLayout llTranding_heading, llRecently_heading, llContinue_heading, llEnglish_heading, llHindi_heading;

    RecyclerView trendingRecyclerView, recentlyRecyclerView, continueRecyclerView, englishRecyclerView, hindiRecyclerView;


    ArrayList<MovieModel> trendingModelArrayList = new ArrayList<>();
    ArrayList<MovieModel> recentlyModelArrayList = new ArrayList<>();
    ArrayList<MovieModel> continueModelArrayList = new ArrayList<>();

    ArrayList<MovieModel> englishModelArrayList = new ArrayList<>();

    ArrayList<MovieModel> hindiModelArrayList = new ArrayList<>();

    TrendingAdapter trendingAdapter;

    VerticalAdapter verticalAdapter;

    ArrayList<MovieModel> movieArrayList = new ArrayList<>();

    final String url = "https://api.themoviedb.org/";

//    int startPosition = 0;  // Starting position (inclusive)
//    int endPosition = 4;    // Ending position (inclusive)

    boolean data = false;


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

//  *************************************** Retrofit ***************************************
        getJsonData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);


//  *************************************** Blur View ***************************************
        blurView = view.findViewById(R.id.blurLayout2);
        blurBackground();

//  *************************************** Avoid View ***************************************
        View view1 = view.findViewById(R.id.avoid_view);
        view1.setOnClickListener(v -> {});


//  *************************************** Search View ***************************************

        ImageView searchView = view.findViewById(R.id.img_Search);
        Intent intent_Search = new Intent(getContext(), SearchActivity.class);

        searchView.setOnClickListener(v -> startActivity(intent_Search));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(data) {

//  *************************************** Trending RecyclerView ***************************************

//        trendingModelArrayList.add(new PosterModel(R.drawable.avatar_land, "Dheglas: The Way Of Water", "Germany to Canada by train"));
//        trendingModelArrayList.add(new PosterModel(R.drawable.the_avengers_land, "Captain Dheglu: The First Avenger", "Germany to Canada by plan"));

                    getTrendingRecyclerView();


//  *************************************** Recently RecyclerView ***************************************

//        recentlyModelArrayList.add(new PosterModel(R.drawable.ironman, "Captain Dheglu: Iron Man", "Germany to Canada by plan"));

                    getRecentlyRecyclerView();


//  *************************************** Continue RecyclerView ***************************************

                    getContinueRecyclerView();


//  *************************************** English RecyclerView ***************************************

                    getEnglishRecyclerView();


//  *************************************** Hindi RecyclerView ***************************************

                    getHindiRecyclerView();

                }

            }
        }, 3000);


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

    //  *************************************** Retrofit Object and Data Fetching ***************************************
    private void getJsonData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetroService_interface service_interface = retrofit.create(RetroService_interface.class);

        Call<JsonModel> call = service_interface.getData();

        call.enqueue(new Callback<JsonModel>() {
            @Override
            public void onResponse(Call<JsonModel> call, Response<JsonModel> response) {
                JsonModel model = response.body();
                movieArrayList = model.getResults();
                Toast.makeText(getContext(), "Server Connected", Toast.LENGTH_LONG).show();
                data = true;
            }

            @Override
            public void onFailure(Call<JsonModel> call, Throwable t) {
//                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }


    //  *************************************** Blur View Method ***************************************
    private void blurBackground() {
        float radius = 16f;
        View decorView = getActivity().getWindow().getDecorView();
        ViewGroup rootView = decorView.findViewById(android.R.id.content);
        Drawable windowBackground = decorView.getBackground();
        blurView.setupWith(rootView, new RenderScriptBlur(getContext())).setFrameClearDrawable(windowBackground).setBlurRadius(radius);
    }


    //  *************************************** Trending RecyclerView Method ***************************************
    private void getTrendingRecyclerView() {

//                startPosition = Math.max(startPosition, -1);
//                endPosition = Math.min(endPosition, movieArrayList.size() - 1);

                for (int i = 0 ; i <= 4; i++) {
                    trendingModelArrayList.add(movieArrayList.get(i));
                }

                trendingRecyclerView = view.findViewById(R.id.trending_recyclerView);
                trendingRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

                trendingAdapter = new TrendingAdapter(getContext(), trendingModelArrayList);
                trendingRecyclerView.setAdapter(trendingAdapter);


    }


    //  *************************************** Recently RecyclerView Method***************************************
    private void getRecentlyRecyclerView() {

//                startPosition = Math.max(startPosition + 5, startPosition);
//                endPosition = Math.min(endPosition + 5, movieArrayList.size() - 1);

                for (int i = 5; i <= 9; i++) {
                    recentlyModelArrayList.add(movieArrayList.get(i));
                }

                recentlyRecyclerView = view.findViewById(R.id.recently_recyclerView);
                recentlyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

                verticalAdapter = new VerticalAdapter(getContext(), recentlyModelArrayList);
                recentlyRecyclerView.setAdapter(verticalAdapter);


    }


    //  *************************************** Continue RecyclerView Method ***************************************
    private void getContinueRecyclerView() {


                for (int i = 10; i <= 14; i++) {
                    continueModelArrayList.add(movieArrayList.get(i));
                }

                continueRecyclerView = view.findViewById(R.id.continue_recyclerView);
                continueRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

                verticalAdapter = new VerticalAdapter(getContext(), continueModelArrayList);
                continueRecyclerView.setAdapter(verticalAdapter);


    }


    //  *************************************** English RecyclerView Method ***************************************
    private void getEnglishRecyclerView() {


                for (int i = 15; i <= 19; i++) {
                    englishModelArrayList.add(movieArrayList.get(i));
                }

                englishRecyclerView = view.findViewById(R.id.english_recyclerView);
                englishRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


                verticalAdapter = new VerticalAdapter(getContext(), englishModelArrayList);
                englishRecyclerView.setAdapter(verticalAdapter);


    }


    //  *************************************** Hindi RecyclerView Method ***************************************
    private void getHindiRecyclerView() {


                for (int i = 15; i <= 19; i++) {
                    hindiModelArrayList.add(movieArrayList.get(i));
                }

                hindiRecyclerView = view.findViewById(R.id.hindi_recyclerView);
                hindiRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


                verticalAdapter = new VerticalAdapter(getContext(), hindiModelArrayList);
                hindiRecyclerView.setAdapter(verticalAdapter);

//                startPosition = 0;
//                endPosition = 4;

    }


    public void loadFrag(LinearLayout linearLayout, Fragment fragment) {
        linearLayout.setOnClickListener(v -> {
            int id = fragment.getId();
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            fm.popBackStack(String.valueOf(id), FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.addToBackStack(String.valueOf(id));
            ft.replace(R.id.framContainer, fragment).commit();
        });
    }


}