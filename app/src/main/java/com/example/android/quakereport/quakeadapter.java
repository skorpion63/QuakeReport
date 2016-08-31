package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
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

        //Get the current object in the array.
        Earthquakes currentQuake = getItem(position);

        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);

        // Set the proper background color on the magnitude circle.
                // Fetch the background from the TextView, which is a GradientDrawable.
                GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        int magnitudeFloor = (int) Math.floor(currentQuake.getmMagnitude());
        int magnitudeColorResourceId;

        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = ContextCompat.getColor(getContext(), magnitudeColorResourceId);

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);





        //Set the magnitude of the earthquake.

        DecimalFormat formatter = new DecimalFormat("0.0");
        String magn = formatter.format(currentQuake.getmMagnitude());
        magnitude.setText(magn);


        //Set the location field in the listView.
        TextView place = (TextView) listItemView.findViewById(R.id.place);
        TextView place2 = (TextView) listItemView.findViewById(R.id.place2);

        String locale = currentQuake.getmPlace();

        if (locale.contains("of")) {
            String[] parts = locale.split("(?<=of)");
            part1 = parts[0];
            part2 = parts[1];
        } else {
            part1 = getContext().getString(R.string.near_the);
            part2 = locale;
        }

        place.setText(part1);
        place2.setText(part2);

        //Set the date and time of the earthquake.
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
