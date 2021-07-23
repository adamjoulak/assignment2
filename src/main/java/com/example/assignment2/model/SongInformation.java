package com.example.assignment2.model;

public class SongInformation {
    private String songName;
    private Artist artist;
    private String album;
    private Genres genre;

    public SongInformation(String songName, Artist artist, String album, Genres genre) {
        this.songName = songName;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }
}
