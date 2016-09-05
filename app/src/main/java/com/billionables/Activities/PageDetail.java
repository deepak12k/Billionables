package com.billionables.Activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.billionables.Fragments.Home;
import com.billionables.R;
import com.billionables.Utils.BillionablesUtils;
import com.billionables.Utils.Constants;
import com.billionables.Utils.Intents;

public class PageDetail extends BaseActivity implements View.OnClickListener {
    TabLayout tabs;
    ViewPager viewPager;
    ImageView imgBack;
    String pageName;
    String pageAddress;
    TextView txtPageName;
    TextView txtPageAddress;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    ImageView imgMap;
    private AppBarLayout app_bar_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_detail);
        pageName = getIntent().getStringExtra("PageName");
        pageAddress = getIntent().getStringExtra("PageAddress");
        initViews();
        initDataToViews();
        initFonts();
        initClickListeners();
        app_bar_layout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    imgBack.setColorFilter(Color.WHITE);

                } else {
                    imgBack.setColorFilter(Color.BLACK);
                }
            }
        });
    }

    private void initClickListeners() {
        imgBack.setOnClickListener(this);
        imgMap.setOnClickListener(this);

    }

    private void initFonts() {
        Typeface typefaceRegular = BillionablesUtils.getSansFont(getApplicationContext(), Constants.FONT_TYPE_REGULAR);
        txtPageName.setTypeface(typefaceRegular);
        txtPageAddress.setTypeface(typefaceRegular);
        collapsingToolbarLayout.setCollapsedTitleTypeface(typefaceRegular);
        collapsingToolbarLayout.setExpandedTitleTypeface(typefaceRegular);
    }

    private void initDataToViews() {
        collapsingToolbarLayout.setTitle(pageName);
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);
        txtPageName.setText(pageName);
        txtPageAddress.setText(pageAddress);
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabs = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
        app_bar_layout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        tabs.setupWithViewPager(viewPager);
        BillionablesUtils.changeTabTextAttributes(tabs, PageDetail.this);
        imgBack = (ImageView) findViewById(R.id.imgBack);
        txtPageName = (TextView) findViewById(R.id.txtPageName);
        txtPageName.setVisibility(View.INVISIBLE);
        txtPageAddress = (TextView) findViewById(R.id.txtPageAddress);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        imgMap = (ImageView) findViewById(R.id.imgMap);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imgBack) {
            finish();
        }
        if (v.getId() == R.id.imgMap) {
            Intents.callMapScreen(getApplicationContext());
        }

    }

    private class SectionPagerAdapter extends FragmentStatePagerAdapter {
        final int PAGE_COUNT = 5;
        private String tabTitles[] = new String[]{"Home", "Video", "Virtual Tour", "Chat", "Book"};

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new Home();
            return fragment;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }

}
