package com.billionables.Models;

/**
 * Created by Nidhi on 25-07-2016.
 */
public class OnBoarding {
    String strText;
    int imageResource;

    public OnBoarding(String strText, int imageResource) {
        this.strText = strText;
        this.imageResource = imageResource;
    }

    public String getStrText() {
        return strText;
    }

    public void setStrText(String strText) {
        this.strText = strText;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
