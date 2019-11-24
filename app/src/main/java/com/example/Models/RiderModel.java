package com.example.Models;

public class RiderModel {

    String UserName;
    String RatingBar;
    String Date;

    public RiderModel(String userName, String ratingBar, String date) {
        UserName = userName;
        RatingBar = ratingBar;
        Date = date;
    }

    public String getUserName() {
        return UserName;
    }

    public String getRatingBar() {
        return RatingBar;
    }

    public String getDate() {
        return Date;
    }
}
