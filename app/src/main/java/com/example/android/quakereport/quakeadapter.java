package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

        TextView date = (TextView) listItemView.findViewById(R.id.date);
        Date ddd = new Date(currentQuake.getmDate());
        SimpleDateFormat sdf = new SimpleDateFormat("LLL.dd.yyyy");
        String formattedDate = sdf.format(ddd);
        date.setText(formattedDate);

        TextView time = (TextView) listItemView.findViewById(R.id.tim);
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String formattedTime = timeFormat.format(ddd);
        time.setText(formattedTime);

        return listItemView;

    }

}
