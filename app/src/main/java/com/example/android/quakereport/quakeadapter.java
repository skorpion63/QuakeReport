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

    private String part1;
    private String part2;

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
        TextView place2 = (TextView) listItemView.findViewById(R.id.place2);
        String locale = currentQuake.getmPlace();
        if (locale.contains("of")) {
            String[] parts = locale.split("(?<=of)");
            part1 = parts[0];
            part2 = parts[1];
        } else {
            part1 = "Near the";
            part2 = locale;
        }
        place.setText(part1);
        place2.setText(part2);

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
