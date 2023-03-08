package com.example.cinehub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    RecyclerView recyclerView;

    ArrayList<TrandingModel> trandingModelArrayList = new ArrayList<>();

    TrandingAdapter trandingAdapter;

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
        recyclerView = view.findViewById(R.id.tranging_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        trandingModelArrayList.add(new TrandingModel(R.drawable.ic_launcher_background, "Captain Dheglu: The First Avenger", "Germany to Canada by plan"));
        trandingModelArrayList.add(new TrandingModel(R.drawable.ic_launcher_background, "Hera Pheri by Shetty", "Radhe... Radhe..."));
        trandingModelArrayList.add(new TrandingModel(R.drawable.ic_launcher_background, "Dheglo: Age of Ultron", "Germany to Canada by train"));
        trandingModelArrayList.add(new TrandingModel(R.drawable.ic_launcher_background, "Phir Hera Pheri", "Meri AnuRadha esa nahi karskti"));
        trandingModelArrayList.add(new TrandingModel(R.drawable.ic_launcher_background, "Captain Dheglu: Self War", "Germany to Canada by plan"));
        trandingModelArrayList.add(new TrandingModel(R.drawable.ic_launcher_background, "Hera Pheri 3", "Radhe... Radhe..."));
        trandingModelArrayList.add(new TrandingModel(R.drawable.ic_launcher_background, "Dheglas: Infinity War", "Germany to Canada by train"));
        trandingModelArrayList.add(new TrandingModel(R.drawable.ic_launcher_background, "Dil De Diya", "Meri AnuRadha esa nahi karskti"));
        trandingModelArrayList.add(new TrandingModel(R.drawable.ic_launcher_background, "Dheglas: Endgame", "Germany to Canada by plan"));
        trandingModelArrayList.add(new TrandingModel(R.drawable.ic_launcher_background, "Mujhko Yaad Sataye Teri", "Radhe... Radhe..."));
        trandingModelArrayList.add(new TrandingModel(R.drawable.ic_launcher_background, "Dheglu🧸 Man", "Germany to Canada by train"));
        trandingModelArrayList.add(new TrandingModel(R.drawable.ic_launcher_background, "Main Ladki Pom Pom", "Meri AnuRadha esa nahi karskti"));
        trandingModelArrayList.add(new TrandingModel(R.drawable.ic_launcher_background, "Dheglu🧸 Man 2", "Germany to Canada by plan"));
        trandingModelArrayList.add(new TrandingModel(R.drawable.ic_launcher_background, "Denewala Jab Bhi Deta Deta Chhappar Phaad Ke", "Radhe... Radhe..."));
        trandingModelArrayList.add(new TrandingModel(R.drawable.ic_launcher_background, "Dheglu🧸 Man 3", "Germany to Canada by train"));
        trandingModelArrayList.add(new TrandingModel(R.drawable.ic_launcher_background, "Shetty👨‍💻", "Meri AnuRadha esa nahi karskti"));

        trandingAdapter = new TrandingAdapter(getContext(), trandingModelArrayList);
        recyclerView.setAdapter(trandingAdapter);
        return view;
    }
}