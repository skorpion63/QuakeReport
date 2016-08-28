package com.example.android.quakereport;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.LayoutInflater;

import java.util.ArrayList;

/**
 * Created by jangjeet on 29/08/16.
 */
public class quakeadapter extends ArrayAdapter<Earthquakes> {


    public quakeadapter(Activity context, ArrayList<Earthquakes> earthquakes) {

        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_items, parent, false);
        }


        Earthquakes currentQuake = getItem(position);

        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitude.setText(currentQuake.getmMagnitude());

        TextView place = (TextView) listItemView.findViewById(R.id.place);
        place.setText(currentQuake.getmPlace());

        TextView date = (TextView) listItemView.findViewById(R.id.tim);
        date.setText(currentQuake.getmDate());

        return listItemView;

    }

}
