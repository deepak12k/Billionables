package com.billionables.Activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.billionables.R;

import java.util.ArrayList;
import java.util.List;

public class CategorySelection extends BaseActivity {
    RecyclerView recyclerView;
    List<com.billionables.Models.CategorySelection> categorySelectionList;
    com.billionables.Adapters.CategorySelection categorySelection;
    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_selection);

        initViews();
        categorySelectionList = new ArrayList<>();
        addDataToList();
        categorySelection = new com.billionables.Adapters.CategorySelection(categorySelectionList, getApplicationContext());
        linearLayoutManager = new LinearLayoutManager(CategorySelection.this);
        recyclerView.setAdapter(categorySelection);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    private void addDataToList() {
        categorySelectionList.add(new com.billionables.Models.CategorySelection("V3S Mall", R.drawable.v3s, "Wheel Chair Friendly", "V3S mall,Laxmi Nagar 110092", "5Km"));
        categorySelectionList.add(new com.billionables.Models.CategorySelection("V3S Mall", R.drawable.v3s, "Wheel Chair Friendly", "V3S mall,Laxmi Nagar 110092", "5Km"));
        categorySelectionList.add(new com.billionables.Models.CategorySelection("V3S Mall", R.drawable.v3s, "Wheel Chair Friendly", "V3S mall,Laxmi Nagar 110092", "5Km"));
        categorySelectionList.add(new com.billionables.Models.CategorySelection("V3S Mall", R.drawable.v3s, "Wheel Chair Friendly", "V3S mall,Laxmi Nagar 110092", "5Km"));
        categorySelectionList.add(new com.billionables.Models.CategorySelection("V3S Mall", R.drawable.v3s, "Wheel Chair Friendly", "V3S mall,Laxmi Nagar 110092", "5Km"));
        categorySelectionList.add(new com.billionables.Models.CategorySelection("V3S Mall", R.drawable.v3s, "Wheel Chair Friendly", "V3S mall,Laxmi Nagar 110092", "5Km"));
        categorySelectionList.add(new com.billionables.Models.CategorySelection("V3S Mall", R.drawable.v3s, "Wheel Chair Friendly", "V3S mall,Laxmi Nagar 110092", "5Km"));
        categorySelectionList.add(new com.billionables.Models.CategorySelection("V3S Mall", R.drawable.v3s, "Wheel Chair Friendly", "V3S mall,Laxmi Nagar 110092", "5Km"));
        categorySelectionList.add(new com.billionables.Models.CategorySelection("V3S Mall", R.drawable.v3s, "Wheel Chair Friendly", "V3S mall,Laxmi Nagar 110092", "5Km"));
        categorySelectionList.add(new com.billionables.Models.CategorySelection("V3S Mall", R.drawable.v3s, "Wheel Chair Friendly", "V3S mall,Laxmi Nagar 110092", "5Km"));
        categorySelectionList.add(new com.billionables.Models.CategorySelection("V3S Mall", R.drawable.v3s, "Wheel Chair Friendly", "V3S mall,Laxmi Nagar 110092", "5Km"));
        categorySelectionList.add(new com.billionables.Models.CategorySelection("V3S Mall", R.drawable.v3s, "Wheel Chair Friendly", "V3S mall,Laxmi Nagar 110092", "5Km"));
        categorySelectionList.add(new com.billionables.Models.CategorySelection("V3S Mall", R.drawable.v3s, "Wheel Chair Friendly", "V3S mall,Laxmi Nagar 110092", "5Km"));
        categorySelectionList.add(new com.billionables.Models.CategorySelection("V3S Mall", R.drawable.v3s, "Wheel Chair Friendly", "V3S mall,Laxmi Nagar 110092", "5Km"));
        categorySelectionList.add(new com.billionables.Models.CategorySelection("V3S Mall", R.drawable.v3s, "Wheel Chair Friendly", "V3S mall,Laxmi Nagar 110092", "5Km"));

    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }
}
