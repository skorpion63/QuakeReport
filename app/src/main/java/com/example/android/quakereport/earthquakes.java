package com.example.android.quakereport;

/**
 * Created by jangjeet on 29/08/16.
 */
public class Earthquakes {

    private String mPlace;
    private String mMagnitude;
    private long mDate;

    public Earthquakes(String magnitude, String place, long date){
        mMagnitude = magnitude;
        mPlace = place;
        mDate = date;
    }

    public String getmMagnitude(){return mMagnitude;}

    public String getmPlace(){return mPlace;}

    public long getmDate(){return mDate;}
}
