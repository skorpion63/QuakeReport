package com.example.android.quakereport;

/**
 * Created by jangjeet on 29/08/16.
 */
public class Earthquakes {

    private String mPlace;
    private String mMagnitude;
    private String mDate;

    public Earthquakes(String magnitude, String place, String date){
        mMagnitude = magnitude;
        mPlace = place;
        mDate = date;
    }

    public String getmMagnitude(){return mMagnitude;}

    public String getmPlace(){return mPlace;}

    public String getmDate(){return mDate;}
}
