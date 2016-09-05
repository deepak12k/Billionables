package com.billionables.Activities;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.billionables.R;
import com.billionables.Utils.CircleTransform;
import com.billionables.Utils.Preferences;
import com.facebook.FacebookSdk;
import com.squareup.picasso.Picasso;

/**
 * Created by Nidhi on 25-07-2016.
 */
public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    protected TextView txtProfileName;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ImageView imgNav;
    private View header;
    private ImageView imgProfileImage;
    private DrawerLayout drawerLayout;

    public void initalizeFacebookSdk() {
        FacebookSdk.sdkInitialize(BaseActivity.this);
    }

    public void createDrawer() {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        imgNav = (ImageView) findViewById(R.id.imgNav);
        header = navigationView.getHeaderView(0);
        imgProfileImage = (ImageView) header.findViewById(R.id.imgProfileImage);
        txtProfileName = (TextView) header.findViewById(R.id.txtProfileName);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

    }

    public void initDrawerData() {
        Preferences.getUserData(getApplicationContext());
        String profileName = Preferences.getUserName();
        String profileImage = Preferences.getImageUrl();
        txtProfileName.setText(profileName);
        Picasso.with(getApplicationContext()).load(profileImage).transform(new CircleTransform()).into(imgProfileImage);
    }

    public void drawerIconClick() {
        imgNav.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imgNav) {
            drawerLayout.openDrawer(Gravity.LEFT);
        }
    }
}
