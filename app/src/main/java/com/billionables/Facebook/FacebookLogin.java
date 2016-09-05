package com.billionables.Facebook;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.billionables.Utils.Preferences;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Nidhi on 05-05-2016.
 */
public class FacebookLogin {

    static Activity activity;
    static CallbackManager callbackManager;

    public static CallbackManager fbLogin(final Activity activity) {
        FacebookLogin.activity = activity;
        callbackManager = CallbackManager.Factory.create();
        final List<String> permissionNeeds = Arrays.asList("user_photos", "email", "user_birthday", "user_friends");
        LoginManager.getInstance().logInWithReadPermissions(activity, permissionNeeds);
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResults) {

                        GraphRequest request = GraphRequest.newMeRequest(loginResults.getAccessToken(),
                                new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(JSONObject object, GraphResponse response) {
                                        try {
                                            //getting user access token
                                            AccessToken token = AccessToken.getCurrentAccessToken();
                                            if (token != null) {

                                                Log.d("User Id", object.getString("id"));
                                                Log.d("Facebook access token", token.getToken());
                                                Log.d("UserName", object.getString("name"));
                                                Log.d("Email", object.getString("email"));
                                                Log.d("Gender", object.getString("gender"));
                                                Preferences.setUserData(activity, object, token);
                                            }

                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "id,name,email,gender, birthday");
                        request.setParameters(parameters);
                        request.executeAsync();

                    }

                    @Override
                    public void onCancel() {
                        Log.e("dd", "facebook login canceled");
                    }

                    @Override
                    public void onError(FacebookException e) {
                        Log.e("dd", "facebook login failed error");
                        Toast.makeText(activity, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                });
        return callbackManager;
    }
}
