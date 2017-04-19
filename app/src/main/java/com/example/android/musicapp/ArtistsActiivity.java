package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.HashMap;

public class ArtistsActiivity extends AppCompatActivity {

    HashMap<Integer, String> artists = new HashMap<Integer, String>();
    private SongsDistrubution helper = new SongsDistrubution();
    private final String callingFrom = "Artists";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);

        artists = helper.getArtistNames();

        LinearLayout artistsLayout = (LinearLayout) findViewById(R.id.activity_artists_addButtons);

        for(Integer s: artists.keySet()) {
            Button artistsList = new Button(this);
            artistsList.setText(artists.get(s));
            artistsList.setId(s);
            final int id = s;
            artistsList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startAllSongsActivity(artists.get(id));
                }
            });

            artistsLayout.addView(artistsList);
        }

    }

    private void startAllSongsActivity(String artist) {
        Intent intent = new Intent(this, AllSongsActivity.class);
        intent.putExtra("Artist", artist);
        intent.putExtra("Calling From", callingFrom);
        startActivity(intent);
    }

    public void nowPlaying(View view){
        Intent intent = new Intent(this,PlaySongs.class);
        intent.putExtra("SongId", -1);
        intent.putExtra("NowPlaying", true);
        startActivity(intent);


    }
}
