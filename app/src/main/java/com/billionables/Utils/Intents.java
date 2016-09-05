package com.billionables.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.billionables.Activities.Category;
import com.billionables.Activities.CategorySelection;
import com.billionables.Activities.IntroScreens;
import com.billionables.Activities.MapView;
import com.billionables.Activities.PageDetail;
import com.billionables.Activities.SplashScreen;

/**
 * Created by Nidhi on 25-07-2016.
 */
public class Intents {
    public static void callIntroScreens(SplashScreen splashScreen) {
        Intent intent = new Intent(splashScreen, IntroScreens.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        splashScreen.startActivity(intent);
    }

    public static void callCategoryScreen(Activity activity) {
        Intent intent = new Intent(activity, Category.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(intent);
    }

    public static void callCategorySelection(Context context) {
        Intent intent = new Intent(context, CategorySelection.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void callPageDetail(Context context, String pageName, String pageAddress) {
        Intent intent = new Intent(context, PageDetail.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("PageName", pageName);
        intent.putExtra("PageAddress", pageAddress);
        context.startActivity(intent);

    }

    public static void callMapScreen(Context context) {
        Intent intent = new Intent(context, MapView.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
