package com.example.csaba.musicalstructure2018_5;

/**
 * Created by csaba on 2/26/2018.
 */

public class Song {

    private String performer;
    private String title;
    private String played;
    private int icon;


    public Song (String songPerformer, String songTitle, String songPlayed, int songIcon){
        performer = songPerformer;
        title = songTitle;
        played = songPlayed;
        icon = songIcon;
    }

    public String getSongPerformer () {
        return performer;
    }
    public String getSongTitle (){
        return title;
    }
    public String getSongPlayed (){
        return played;
    }
    public int getImageResourceId () {return  icon;}
    public String setSongPlayed (String songPlayed) {this.played = songPlayed; return played;}


}
