package com.example.walid.project3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ArtistsActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tracks);
        listView = findViewById(R.id.lvTracks);
        final ArrayList<Artist> artists = new ArrayList<Artist>();
        artists.add(new Artist("Adele", "adele", R.drawable.adele));
        artists.add(new Artist("Michael Jackson", "Thriller", R.drawable.thriller));
        artists.add(new Artist("Charles Aznavour", "La boheme", R.drawable.laboheme));
        artists.add(new Artist("Cheb khaled", "Sahra", R.drawable.sahra));
        artists.add(new Artist("Guerouabi", "Le chaabi des maitres", R.drawable.lechaabidesmaitres));
        artists.add(new Artist("Daft punk", "Discovery", R.drawable.discovery));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ArtistsActivity.this, NowPlayingActivity.class);
                intent.putExtra("album", artists.get(i).getAlbumName());
                intent.putExtra("artist", artists.get(i).getArtistName());
                intent.putExtra("title", "track 1");
                intent.putExtra("img_res", artists.get(i).getImg_res());
                startActivity(intent);
            }
        });
        listView.setAdapter(new ArtistsAdapter(this, artists));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_artists, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.albumsMenu:
                startActivity(new Intent(this, AlbumsActivity.class));
                break;
            case R.id.allTracksMenu:
                startActivity(new Intent(this, AllTracksActivity.class));
                break;
            case R.id.nowPlayingMenu:
                Intent intent = new Intent(this, NowPlayingActivity.class);
                intent.putExtra("album", "25");
                intent.putExtra("artist", "Adele");
                intent.putExtra("title", "Hello");
                intent.putExtra("img_res", R.drawable.adele);
                startActivity(intent);
                break;
            case R.id.homeMenu:
                startActivity(new Intent(this, HomeActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}