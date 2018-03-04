package com.example.csaba.musicalstructure2018_5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String mypreference = "mypref";
    public SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**SharedPreferences inicialization*/
        sharedPreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);


        ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song("xfruge x baechulgi", "sunflowers", "0", R.drawable.sunflowers));
        songs.add(new Song("mounika.", "nobody but me", "0", R.drawable.mounika_nobody));
        songs.add(new Song("mrmrs", "RIIIDE OUT", "0", R.drawable.mrmrs_ride));
        songs.add(new Song("xfruge x baechulgi", "sunflowers", "0", R.drawable.sunflowers));
        songs.add(new Song("mounika.", "nobody but me", "0", R.drawable.mounika_nobody));
        songs.add(new Song("mrmrs", "RIIIDE OUT", "0", R.drawable.mrmrs_ride));
        songs.add(new Song("xfruge x baechulgi", "sunflowers", "0", R.drawable.sunflowers));
        songs.add(new Song("mounika.", "nobody but me", "0", R.drawable.mounika_nobody));
        songs.add(new Song("mrmrs", "RIIIDE OUT", "0", R.drawable.mrmrs_ride));
        songs.add(new Song("xfruge x baechulgi", "sunflowers", "0", R.drawable.sunflowers));
        songs.add(new Song("mounika.", "nobody but me", "0", R.drawable.mounika_nobody));
        songs.add(new Song("mrmrs", "RIIIDE OUT", "0", R.drawable.mrmrs_ride));
        songs.add(new Song("xfruge x baechulgi", "sunflowers", "0", R.drawable.sunflowers));
        songs.add(new Song("mounika.", "nobody but me", "0", R.drawable.mounika_nobody));

        final SongAdapter adapter = new SongAdapter(this, songs);

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);


        //onClick listener on listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {

                Intent intent = new Intent(MainActivity.this, SongActivity.class);
                intent.putExtra("position", position);

                /**use counter*/
                String counterBefore = adapter.getItem(position).getSongPlayed().toString();      //counter before
                int counter = Integer.parseInt(counterBefore);                                     //make counterbefore an integer
                counter += 1;                                                                      //add +1
                String counterAfter = String.valueOf(counter);                                     //make counter a String again
                adapter.getItem(position).setSongPlayed(counterAfter);                             //use setSongPlayed method to set counter with the new value

                //Toast.makeText(MainActivity.this, counterTwo, Toast.LENGTH_SHORT).show();


                startActivity(intent);
            }
        });

    }

}
