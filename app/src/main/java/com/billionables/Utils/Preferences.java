package com.billionables.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.facebook.AccessToken;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Nidhi on 25-07-2016.
 */
public class Preferences {
    static SharedPreferences.Editor sharedPreferencesEditor;
    static SharedPreferences sharedPreferences;

    public static void setUserData(Context context, JSONObject object, AccessToken token) throws JSONException {
        sharedPreferencesEditor = context.getSharedPreferences("CurrentUserData", Context.MODE_PRIVATE).edit();
        setUserName(object.getString("name"));
        setEmail(object.getString("email"));
        setGender(object.getString("gender"));
        setProfileImageUrl("https://graph.facebook.com/" + object.getString("id") + "/picture?type=large");
/*
        setAuthenticationToken(object.getString(token.getToken()));
*/
        sharedPreferencesEditor.apply();

    }

    static public void getUserData(Context context) {
        try {
            sharedPreferences = context.getSharedPreferences("CurrentUserData", Context.MODE_PRIVATE);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void setAuthenticationToken(String token) {
        sharedPreferencesEditor.putString("token", token);
    }

    public static void setProfileImageUrl(String profileImageUrl) {
        sharedPreferencesEditor.putString("profileImage", profileImageUrl);
    }

    public static String getUserName() {
        return sharedPreferences.getString("userName", null);
    }

    public static void setUserName(String name) {
        sharedPreferencesEditor.putString("userName", name);
    }

    public static String getEmail() {
        return sharedPreferences.getString("email", null);
    }

    public static void setEmail(String email) {
        sharedPreferencesEditor.putString("email", email);
    }

    public static String getGender() {
        return sharedPreferences.getString("gender", null);
    }

    public static void setGender(String gender) {
        sharedPreferencesEditor.putString("gender", gender);
    }

    public static String getImageUrl() {
        return sharedPreferences.getString("profileImage", null);
    }

}
