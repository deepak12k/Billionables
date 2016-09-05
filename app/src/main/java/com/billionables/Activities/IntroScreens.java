package com.billionables.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.billionables.Models.OnBoarding;
import com.billionables.R;

import java.util.ArrayList;
import java.util.List;

public class IntroScreens extends AppCompatActivity implements View.OnClickListener {
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    ImageView imgIntro;
    TextView txtIntroText;
    Button btnSkip;
    List<OnBoarding> list;
    GradientDrawable bgShape1, bgShape2, bgShape3;
    String str1 = "Agree with something? Tap on it to give your" +
            "review. To withdraw your review, simply tap on it again";

    String str2 = "Say what comes to your mind, all in just 42" +
            "characters. Give as many 42-character review snippets as you like ";

    String str3 = "Add a quick photo to your review if you like. " +
            "Pick a photo from Gallery or click one right away ";


    int drawable1 = R.drawable.intro_screen_1;
    int drawable2 = R.drawable.intro_screen_1;
    int drawable3 = R.drawable.intro_screen_1;

    ViewPager.OnPageChangeListener viewPagerChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            displayMetaInfo(position);
            updateIndicators(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    private View indicator1;
    private View indicator2;
    private View indicator3;

    private void updateIndicators(int position) {
        switch (position) {
            case 0:
                bgShape1.setColor(Color.parseColor("#009688"));
                bgShape2.setColor(Color.TRANSPARENT);
                bgShape3.setColor(Color.TRANSPARENT);
                break;

            case 1:
                bgShape1.setColor(Color.TRANSPARENT);
                bgShape2.setColor(Color.parseColor("#009688"));
                bgShape3.setColor(Color.TRANSPARENT);
                break;

            case 2:
                bgShape1.setColor(Color.TRANSPARENT);
                bgShape2.setColor(Color.TRANSPARENT);
                bgShape3.setColor(Color.parseColor("#009688"));
                break;

        }
    }

    private void displayMetaInfo(int position) {
        txtIntroText.setText(list.get(position).getStrText());
        imgIntro.setImageResource(list.get(position).getImageResource());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro_screens);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        btnSkip = (Button) findViewById(R.id.btnSkip);
        btnSkip.setOnClickListener(this);
        indicator1 = (View) findViewById(R.id.indicator1);
        indicator2 = (View) findViewById(R.id.indicator2);
        indicator3 = (View) findViewById(R.id.indicator3);

        bgShape1 = (GradientDrawable) indicator1.getBackground();
        bgShape2 = (GradientDrawable) indicator2.getBackground();
        bgShape3 = (GradientDrawable) indicator3.getBackground();


        list = new ArrayList<>();
        list.add(new OnBoarding(str1, drawable1));
        list.add(new OnBoarding(str2, drawable2));
        list.add(new OnBoarding(str3, drawable3));

        viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        setCurrentItem(0);
        updateIndicators(0);
        viewPager.addOnPageChangeListener(viewPagerChangeListener);

    }

    private void setCurrentItem(final int i) {
        viewPager.postDelayed(new Runnable() {
            @Override
            public void run() {
                viewPager.setCurrentItem(i, false);
                displayMetaInfo(i);
                viewPagerAdapter.notifyDataSetChanged();
            }
        }, 100);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSkip) {
            Intent firstScreenIntent = new Intent(IntroScreens.this, Category.class);
            firstScreenIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(firstScreenIntent);
        }

    }


    private class ViewPagerAdapter extends PagerAdapter {
        LayoutInflater layoutInflater;


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.intro_screens, container, false);
            imgIntro = (ImageView) view.findViewById(R.id.imgIntro);
            txtIntroText = (TextView) view.findViewById(R.id.txtIntroText);
            displayMetaInfo(position);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((View) object);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
