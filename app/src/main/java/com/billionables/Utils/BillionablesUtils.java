package com.billionables.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Nidhi on 25-07-2016.
 */
public class BillionablesUtils {

    public static void getHashKeys(Activity activity) {
        try {
            PackageInfo info = activity.getPackageManager().getPackageInfo(
                    "com.billionables",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException ignored) {

        }
    }

    static public Typeface getSansFont(Context context, int type) {
        try {

            if (type == Constants.FONT_TYPE_REGULAR) {

                return Typeface.createFromAsset(context.getAssets(), "fonts/open-sans.regular.ttf");
            }
            if (type == Constants.FONT_TYPE_THIN) {
                return Typeface.createFromAsset(context.getAssets(), "fonts/open-sans.light.ttf");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void changeTabTextAttributes(TabLayout tabLayout, Context context) {
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTextSize(12);
                    ((TextView) tabViewChild).setAllCaps(false);
                    ((TextView) tabViewChild).setTypeface(BillionablesUtils.getSansFont(context, Constants.FONT_TYPE_REGULAR));
                }
            }
        }
    }

}
