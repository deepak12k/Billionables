package com.billionables.Models;

/**
 * Created by Nidhi on 28-07-2016.
 */
public class CategorySelection {
    String placeName;
    String placeCategory;
    String address;
    String distance;
    int image;

    public CategorySelection(String placeName, int image, String placeCategory, String address, String distance) {

        this.placeName = placeName;
        this.placeCategory = placeCategory;
        this.address = address;
        this.distance = distance;
        this.image = image;
    }


    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceCategory() {
        return placeCategory;
    }

    public void setPlaceCategory(String placeCategory) {
        this.placeCategory = placeCategory;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
