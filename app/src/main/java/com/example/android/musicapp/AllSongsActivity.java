package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.HashMap;

/**
 * Activity that displays according to genre selected.
 */
public class AllSongsActivity extends AppCompatActivity {

    private final String playlists_calling = "Playlists";
    private final String songs_calling = "Songs";
    private final String artists_calling = "Artists";
    private final String albums_calling = "Albums";
    HashMap<Integer, String> genreSong = new HashMap<Integer, String>();
    HashMap<Integer, String> allSongs = new HashMap<Integer, String>();
    HashMap<Integer, String> artistSong = new HashMap<Integer, String>();
    HashMap<Integer, String> albumSong = new HashMap<Integer, String>();
    private SongsDistrubution helper = new SongsDistrubution();
    private LinearLayout allSongsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allsongslist);

        initializeMaps();

        allSongsList = (LinearLayout) findViewById(R.id.activity_allsongsList_addButtons);

        Intent intent = getIntent();
        String genre = "";
        String artist = "";
        String album = "";
        String callingFrom = intent.getStringExtra("Calling From");

        if (callingFrom.equals(playlists_calling)) {

            genre = intent.getStringExtra("Genre");

            for (Integer s : genreSong.keySet()) {
                if (genreSong.get(s).equals(genre)) {
                    display(s);
                }
            }

        } else if (callingFrom.equals(songs_calling)) {

            for (Integer s : allSongs.keySet()) {
                display(s);
            }

        } else if (callingFrom.equals(artists_calling)) {

            artist = intent.getStringExtra("Artist");

            for (Integer s : artistSong.keySet()) {
                if (artistSong.get(s).equals(artist)) {
                    display(s);
                }
            }

        } else if (callingFrom.equals(albums_calling)) {

            album = intent.getStringExtra("Album");

            for (Integer s : albumSong.keySet()) {
                if (albumSong.get(s).equals(album)) {
                    display(s);
                }
            }
        }
    }

    private void display(int s) {
        Button songsList = new Button(this);
        songsList.setText(allSongs.get(s));
        songsList.setId(s);
        final int key = s;
        songsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(AllSongsActivity.this, PlaySongs.class);

                i.putExtra("SongId", key);
                i.putExtra("NowPlaying", false);
                startActivity(i);
            }
        });

        allSongsList.addView(songsList);
    }

    private void initializeMaps() {
        allSongs = helper.getSongsPlaylist();
        genreSong = helper.getSongsGenrelist();
        artistSong = helper.getArtistSongs();
        albumSong = helper.getAlbumSongs();
    }

    public void nowPlaying(View view) {
        Intent intent = new Intent(this, PlaySongs.class);
        intent.putExtra("SongId", -1);
        intent.putExtra("NowPlaying", true);
        startActivity(intent);
    }
}
