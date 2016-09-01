package com.example.android.quakereport;

/**
 * Created by jangjeet on 29/08/16.
 */
public class Earthquakes {

    private String mPlace;
    private double mMagnitude;
    private long mDate;
    private String mUrl;

    public Earthquakes(double magnitude, String place, long date, String url){
        mMagnitude = magnitude;
        mPlace = place;
        mDate = date;
        mUrl = url;
    }

    public double getmMagnitude(){return mMagnitude;}

    public String getmPlace(){return mPlace;}

    public long getmDate(){return mDate;}

    public String getmUrl(){return mUrl;}
}
