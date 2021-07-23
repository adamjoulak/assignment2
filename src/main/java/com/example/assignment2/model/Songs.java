package com.example.assignment2.model;

public class Songs {
    private int songID;
    private String songName;

    public Songs(int songID, String songName) {
        this.songID = songID;
        this.songName = songName;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
}
