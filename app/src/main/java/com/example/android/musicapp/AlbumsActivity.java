package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.HashMap;

/**
 *
 * Activity for displaying Albums list.
 */
public class AlbumsActivity extends AppCompatActivity {

    private final String callingFrom = "Albums";
    private SongsDistrubution helper = new SongsDistrubution();
    HashMap<Integer, String> albums = new HashMap<Integer, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        albums = helper.getAlbumNames();

        LinearLayout albumLayout = (LinearLayout) findViewById(R.id.activity_albums_addButtons);

        for (Integer s : albums.keySet()) {
            Button albumsList = new Button(this);
            albumsList.setText(albums.get(s));
            albumsList.setId(s);
            final int id = s;
            albumsList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startAllSongsActivity(albums.get(id));
                }
            });

            albumLayout.addView(albumsList);
        }

    }

    public void nowPlaying(View view) {
        Intent intent = new Intent(this, PlaySongs.class);
        intent.putExtra("SongId", -1);
        intent.putExtra("NowPlaying", true);
        startActivity(intent);

    }

    private void startAllSongsActivity(String album) {
        Intent intent = new Intent(this, AllSongsActivity.class);
        intent.putExtra("Album", album);
        intent.putExtra("Calling From", callingFrom);
        startActivity(intent);
    }

}



