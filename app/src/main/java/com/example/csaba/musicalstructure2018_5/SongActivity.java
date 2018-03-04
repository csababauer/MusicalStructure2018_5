package com.example.csaba.musicalstructure2018_5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.csaba.musicalstructure2018_5.R.drawable.play;

/**
 * Created by csaba on 2/27/2018.
 */

public class SongActivity extends AppCompatActivity {

    String songOnePerformer = "xfruge x baechulgi";
    String songTwoPerformer = "mounika.";
    String songThreePerformer = "mrmrs";
    String songOneTitle = "sunflowers";
    String songTwoTitle = "nobody but me";
    String songThreeTitle = "RIIIDE OUT";
    public MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_item);


        /**back to main button*/
        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mp.release();
                Intent BackToMain = new Intent(SongActivity.this, MainActivity.class);
                startActivity(BackToMain);
            }
        });

        /**stop button*/
        final Button stop = (Button) findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.pause();
                    stop.setBackgroundResource(R.drawable.play);
                } else {
                    stop.setBackgroundResource(R.drawable.stop);
                    mp.start();
                }
            }
        });


        /**get list item position*/
        //get list item position and display it
        int listItemPosition = getIntent().getIntExtra("position", 0);
        Toast.makeText(this, String.valueOf(listItemPosition), Toast.LENGTH_LONG).show();

        /**set theese objects on song item*/
        TextView performer = (TextView) findViewById(R.id.performer);
        TextView title = (TextView) findViewById(R.id.title);
        ImageView cover = (ImageView) findViewById(R.id.image);

        /**set song details in song_item*/
        /**use common method to be able to stop music from main activity */

        switch (listItemPosition) {
            case 0:
            case 3:
            case 6:
            case 9:
            case 12:
                performer.setText(songOnePerformer);
                title.setText(songOneTitle);
                cover.setImageResource(R.drawable.sunflowers);
                mp = MediaPlayer.create(this, R.raw.xfruge_x_baechulgi_collab);
                mp.start();
                break;
            case 1:
            case 4:
            case 7:
            case 10:
            case 13:
                performer.setText(songTwoPerformer);
                title.setText(songTwoTitle);
                cover.setImageResource(R.drawable.mounika_nobody);
                mp = MediaPlayer.create(this, R.raw.mounika_nobody_but_me);
                mp.start();
                break;
            case 2:
            case 5:
            case 8:
            case 11:
                performer.setText(songThreePerformer);
                title.setText(songThreeTitle);
                cover.setImageResource(R.drawable.mrmrs_ride);
                mp = MediaPlayer.create(this, R.raw.riiide_out);
                mp.start();
                break;
        }



    }

    /**
     * when I press the physical home button I stop the music
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mp.isPlaying()) {
            mp.stop();
            mp.release();
        }
    }
}
