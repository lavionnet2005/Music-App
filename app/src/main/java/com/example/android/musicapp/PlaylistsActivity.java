package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Displays songs based on the genre selected.
 */
public class PlaylistsActivity extends AppCompatActivity {

    private final String sad = "SadSong";
    private final String happy = "HappySong";
    private final String romantic = "RomanticSong";
    private final String party = "partySong";
    private final String callingFrom = "Playlists";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlists);

        Button sadSong = (Button) findViewById(R.id.sadsong);

        sadSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAllSongsActivity(sad);
            }
        });

        Button happySong = (Button) findViewById(R.id.happysong);
        happySong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAllSongsActivity(happy);
            }
        });

        Button partySong = (Button) findViewById(R.id.partysong);
        partySong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAllSongsActivity(party);
            }
        });

        Button romanticSong = (Button) findViewById(R.id.romanticsong);
        romanticSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAllSongsActivity(romantic);
            }
        });

    }

    private void startAllSongsActivity(String genre) {
        Intent intent = new Intent(this, AllSongsActivity.class);
        intent.putExtra("Genre", genre);
        intent.putExtra("Calling From", callingFrom);
        startActivity(intent);
    }

    public void nowPlaying(View view) {
        Intent intent = new Intent(this, PlaySongs.class);
        intent.putExtra("SongId", -1);
        intent.putExtra("NowPlaying", true);
        startActivity(intent);
    }
}
