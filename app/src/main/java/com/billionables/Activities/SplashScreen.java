package com.billionables.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.billionables.Facebook.FacebookLogin;
import com.billionables.R;
import com.billionables.Utils.BillionablesUtils;
import com.billionables.Utils.Constants;
import com.billionables.Utils.Intents;
import com.billionables.Utils.Preferences;
import com.facebook.CallbackManager;

public class SplashScreen extends BaseActivity implements View.OnClickListener {
    private static final long SPLASH_DISPLAY_LENGTH = 1500;
    Button loginButton;
    CallbackManager callbackManager;
    String name;
    ImageView imgLogo;
    CheckBox chkBoxTermsCondition;
    TextView txtLogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initalizeFacebookSdk();
        setContentView(R.layout.activity_splashscreen);

        Preferences.getUserData(SplashScreen.this);
        name = Preferences.getUserName();
        if (name == null) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    SlideToAbove();
                }
            }, SPLASH_DISPLAY_LENGTH);
        } else {
            Intents.callCategoryScreen(SplashScreen.this);
        }


        initViews();
        initFonts();
        initClickListeners();
        BillionablesUtils.getHashKeys(SplashScreen.this);

    }

    private void initFonts() {
        Typeface typefaceRegular = BillionablesUtils.getSansFont(getApplicationContext(), Constants.FONT_TYPE_REGULAR);
        txtLogo.setTypeface(typefaceRegular);
    }

    private void SlideToAbove() {
        Animation splash_screen_animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.splash_screen_animation);
        splash_screen_animation.setDuration(1500);
        imgLogo.startAnimation(splash_screen_animation);
        afterAnimation();


    }

    private void afterAnimation() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loginButton.setVisibility(View.VISIBLE);
                chkBoxTermsCondition.setVisibility(View.VISIBLE);
                txtLogo.setVisibility(View.VISIBLE);
            }
        }, 1600);
    }

    private void initClickListeners() {
        loginButton.setOnClickListener(this);
        chkBoxTermsCondition.setOnClickListener(this);
    }

    private void initViews() {
        loginButton = (Button) findViewById(R.id.loginButton);
        imgLogo = (ImageView) findViewById(R.id.imgLogo);
        chkBoxTermsCondition = (CheckBox) findViewById(R.id.chkBoxTermsCondition);
        String checkBoxText = "I agree to all the <a href='https://www.google.com' > Terms and Conditions</a>";
        assert chkBoxTermsCondition != null;
        chkBoxTermsCondition.setText(Html.fromHtml(checkBoxText));
        txtLogo = (TextView) findViewById(R.id.txtLogo);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.loginButton) {
            callbackManager = FacebookLogin.fbLogin(SplashScreen.this);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        Intents.callIntroScreens(SplashScreen.this);
    }
}
