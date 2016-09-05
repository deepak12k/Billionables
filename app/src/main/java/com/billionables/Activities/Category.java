package com.billionables.Activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.billionables.R;
import com.billionables.Utils.BillionablesUtils;
import com.billionables.Utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class Category extends BaseActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    RecyclerView recyclerView;
    List<com.billionables.Models.Category> categoryList;
    com.billionables.Adapters.Category categoryAdapter;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        categoryList = new ArrayList<>();
        initViews();
        drawerIconClick();
        addCategoryData();
        initDataToViews();
        initFonts();
    }

    private void addCategoryData() {
        categoryList.add(new com.billionables.Models.Category(R.drawable.food, "Food"));
        categoryList.add(new com.billionables.Models.Category(R.drawable.shopping, "Shopping"));
        categoryList.add(new com.billionables.Models.Category(R.drawable.entertainment, "Entertainment"));
        categoryList.add(new com.billionables.Models.Category(R.drawable.health, "Health"));
        categoryList.add(new com.billionables.Models.Category(R.drawable.events, "Events"));
        categoryList.add(new com.billionables.Models.Category(R.drawable.education, "Education"));
        categoryList.add(new com.billionables.Models.Category(R.drawable.buildings, "Buildings"));
        categoryList.add(new com.billionables.Models.Category(R.drawable.washroom, "Washrooms"));
        categoryList.add(new com.billionables.Models.Category(R.drawable.atm, "Banking"));
        categoryList.add(new com.billionables.Models.Category(R.drawable.transport, "Public Transport"));
        categoryList.add(new com.billionables.Models.Category(R.drawable.cabs, "Cabs"));
        categoryList.add(new com.billionables.Models.Category(R.drawable.tours, "Tours"));
    }

    private void initFonts() {
        Typeface typefaceRegular = BillionablesUtils.getSansFont(getApplicationContext(), Constants.FONT_TYPE_REGULAR);
        txtProfileName.setTypeface(typefaceRegular);
    }

    private void initDataToViews() {
        categoryAdapter = new com.billionables.Adapters.Category(categoryList, getApplicationContext());
        recyclerView.setAdapter(categoryAdapter);
        gridLayoutManager = new GridLayoutManager(Category.this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        initDrawerData();
    }

    private void initViews() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        setSupportActionBar(toolbar);
        createDrawer();
    }
}
