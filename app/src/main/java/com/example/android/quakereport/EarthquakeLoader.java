package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;

import static com.example.android.quakereport.EarthquakeActivity.USGS_REQUEST_URL;

/**
 * Created by jangjeet on 02/10/16.
 */
    public class EarthquakeLoader extends AsyncTaskLoader<ArrayList<Earthquakes>> {

        public EarthquakeLoader(Context context, String url) {
            super(context);
            // TODO: Finish implementing this constructor
        }

        @Override
        protected void onStartLoading() {
            forceLoad();
        }

        @Override
        public ArrayList<Earthquakes> loadInBackground() {
            ArrayList<Earthquakes> earthquakes = QueryUtils.fetchEarthquakeData(USGS_REQUEST_URL);
            return earthquakes;

        }
    }

