package com.example.csaba.musicalstructure2018_5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by csaba on 2/26/2018.
 */

public class SongAdapter extends ArrayAdapter <Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the  object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.performer);
        // Get the version name from the current name object and
        // set this text on the name TextView
        nameTextView.setText(currentSong.getSongPerformer());

        TextView tTextView = (TextView) listItemView.findViewById(R.id.title);
        tTextView.setText(currentSong.getSongTitle());

        TextView pTextView = (TextView) listItemView.findViewById(R.id.played);
        pTextView.setText(currentSong.getSongPlayed());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        iconView.setImageResource(currentSong.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }
}
