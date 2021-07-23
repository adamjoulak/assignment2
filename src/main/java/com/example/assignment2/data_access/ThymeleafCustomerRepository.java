package com.example.assignment2.data_access;
import com.example.assignment2.model.Artist;
import com.example.assignment2.model.Genres;
import com.example.assignment2.model.SongInformation;
import com.example.assignment2.model.Songs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ThymeleafCustomerRepository {




        String URL = ConnectionHelper.jdbcUrl;
        Connection conn = null;

        public ArrayList<Songs> get5RandomSongs() {
            ArrayList<Songs> songs = new ArrayList<Songs>();
            try {
                // Connect to the database
                conn = DriverManager.getConnection(URL);
                System.out.println("Connection to SQLite has been established.");

                // create query
                PreparedStatement preparedStatement =
                        conn.prepareStatement("SELECT TrackId, Name FROM Track ORDER BY random() LIMIT 5");
                // Execute the query
                ResultSet resultSet = preparedStatement.executeQuery();

                // Iterate through every result, create a song --> add to arraylist
                while (resultSet.next()) {
                    songs.add(
                            new Songs(
                                    resultSet.getInt(1), resultSet.getString(2)
                            ));
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            } finally {
                try {
                    // Close Connection
                    conn.close();
                } catch (Exception e) {

                }
                return songs;
            }
        }




        public ArrayList<Artist> get5RandomArtists() {
            ArrayList<Artist> artists = new ArrayList<Artist>();
            try {
                // Open Connection
                conn = DriverManager.getConnection(URL);
                System.out.println("Connection to SQLite has been established.");

                // Prepare Statement
                PreparedStatement preparedStatement =
                        conn.prepareStatement("SELECT ArtistId, Name FROM Track ORDER BY random() LIMIT 5");
                // Execute Statement
                ResultSet resultSet = preparedStatement.executeQuery();

                // Iterate through every result, create anartist --> add to arraylist
                while (resultSet.next()) {
                    artists.add(
                            new Artist(resultSet.getInt(1), resultSet.getString(2)));
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            } finally {
                try {
                    // Close Connection
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                return artists;
            }
        }

        public ArrayList<Genres> get5RandomGenres() {
            ArrayList<Genres> genres = new ArrayList<Genres>();
            try {
                // Open Connection
                conn = DriverManager.getConnection(URL);
                System.out.println("Connection to SQLite has been established.");

                // Prepare Statement
                PreparedStatement preparedStatement =
                        conn.prepareStatement("SELECT GenreId, Name FROM Track ORDER BY random() LIMIT 5");
                // Execute Statement
                ResultSet resultSet = preparedStatement.executeQuery();

                // Iterate through every result, create Genres --> add to arraylist
                while (resultSet.next()) {
                    genres.add(
                            new Genres(
                                    resultSet.getInt(1), resultSet.getString(2)
                            ));
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            } finally {
                try {
                    // Close Connection
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                return genres;
            }
        }







        public ArrayList<SongInformation> getSongInformation(String songTitle) {
            ArrayList<SongInformation> trackList = new ArrayList<SongInformation>();
            Artist a;
            Genres g;
            try {
                conn = DriverManager.getConnection(URL);
                System.out.println("Connection to SQLite has been established.");

                PreparedStatement preparedStatement =
                        conn.prepareStatement("SELECT track.Name, artist.ArtistId, artist.Name, album.Title, genre.GenreId, genre.Name \n" +
                                "FROM Track AS track INNER JOIN Genre AS genre on track.GenreId = genre.GenreId \n" +
                                "INNER JOIN Album album on track.AlbumId = album.AlbumId INNER JOIN Artist as artist \n" +
                                "on album.ArtistId = artist.ArtistId WHERE track.Name LIKE ?");

                preparedStatement.setString(1, "%" + songTitle + "%");
                ResultSet resultSet = preparedStatement.executeQuery();


                while (resultSet.next()) {

                    trackList.add(
                            new SongInformation(
                                    resultSet.getString(1),
                                    new Artist(resultSet.getInt(2), resultSet.getString(3)),
                                    resultSet.getString(4),
                                    new Genres(resultSet.getInt(5), resultSet.getString(6))
                            ));
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                return trackList;
            }
        }






}
