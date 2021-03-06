/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Earthquakes>> {

    /** URL for earthquake data from the USGS dataset */
    public static final String USGS_REQUEST_URL = " http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";


    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

      //  getQuakes task = new getQuakes();
      //  task.execute(USGS_REQUEST_URL);
        getLoaderManager().initLoader(0, null, this);

    }

    private void updateUi(ArrayList<Earthquakes> earthquake){
        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        final quakeadapter adapter = new quakeadapter(this, earthquake);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Earthquakes currentQ = adapter.getItem(position);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(currentQ.getmUrl()));
                startActivity(intent);
            }
        });
    }
  /**  private class getQuakes extends AsyncTask<String, Void, ArrayList<Earthquakes>>{

        @Override
        protected ArrayList<Earthquakes> doInBackground(String... urls) {
            // Create a fake list of earthquakes.
            ArrayList<Earthquakes> earthquakes = QueryUtils.fetchEarthquakeData(USGS_REQUEST_URL);
            return earthquakes;
        }

        @Override
        protected void onPostExecute(ArrayList<Earthquakes> earthquakes) {
            updateUi(earthquakes);
        }


    } */

    @Override
    public Loader<ArrayList<Earthquakes>> onCreateLoader(int i, Bundle bundle) {
        // TODO: Create a new loader for the given URL
        return new EarthquakeLoader(this, USGS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Earthquakes>> loader, ArrayList<Earthquakes> earthquakes) {
        // TODO: Update the UI with the result
        updateUi(earthquakes);

    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Earthquakes>> loader) {
        // TODO: Loader reset, so we can clear out our existing data.
    }
}
