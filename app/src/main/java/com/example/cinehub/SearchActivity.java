package com.example.cinehub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

//    ArrayList<MovieModel> searchList;

    EditText searchText;

    RecyclerView rvSearch;

//    VerticalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        TextView textView = findViewById(R.id.txt_searchCancle);
        searchText = findViewById(R.id.search_HomeView);
        rvSearch = findViewById(R.id.rv_search);

        textView.setOnClickListener(v -> onBackPressed());

//        Intent intent = getIntent();

//        searchList = (ArrayList<MovieModel>) intent.getSerializableExtra("searchlist");

//        searchText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                String query = s.toString().toLowerCase();
//                ArrayList<MovieModel> filteredList = new ArrayList<>();
//
//                for(MovieModel item: searchList){
//                    if(item.getOriginal_title().toLowerCase().contains(query)) {
//                        filteredList.add(new MovieModel(item.original_title, item.overview, item.poster_path, item.release_date, item.vote_average));
//                    }
//                }
//                        adapter = new VerticalAdapter(SearchActivity.this, filteredList);
//                        rvSearch.setAdapter(adapter);
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//
//
//
//            }
//        });
    }
}