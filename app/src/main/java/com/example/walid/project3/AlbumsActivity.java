package com.example.walid.project3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class AlbumsActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        gridView = findViewById(R.id.gvAlbum);
        final ArrayList<Album> albums = new ArrayList<Album>();
        albums.add(new Album("Hello", "Adele", R.drawable.adele));
        albums.add(new Album("Billie jean", "Michael jackson", R.drawable.thriller));
        albums.add(new Album("La boheme", "Charles aznavour", R.drawable.laboheme));
        albums.add(new Album("Aicha", "Khaled", R.drawable.sahra));
        albums.add(new Album("El harrez", "Guerouabi", R.drawable.lechaabidesmaitres));
        albums.add(new Album("Discovery", "Daft punk", R.drawable.discovery));
        albums.add(new Album("Hello", "Adele", R.drawable.adele));
        albums.add(new Album("Billie jean", "Michael jackson", R.drawable.thriller));
        albums.add(new Album("La boheme", "Charles aznavour", R.drawable.laboheme));
        albums.add(new Album("Aicha", "Khaled", R.drawable.sahra));
        albums.add(new Album("El harrez", "Guerouabi", R.drawable.lechaabidesmaitres));
        albums.add(new Album("Discovery", "Daft punk", R.drawable.discovery));
        albums.add(new Album("Hello", "Adele", R.drawable.adele));
        albums.add(new Album("Billie jean", "Michael jackson", R.drawable.thriller));
        albums.add(new Album("La boheme", "Charles aznavour", R.drawable.laboheme));
        albums.add(new Album("Aicha", "Khaled", R.drawable.sahra));
        albums.add(new Album("El harrez", "Guerouabi", R.drawable.lechaabidesmaitres));
        albums.add(new Album("Discovery", "Daft punk", R.drawable.discovery));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AlbumsActivity.this, NowPlayingActivity.class);
                intent.putExtra("album", albums.get(i).getAlbum());
                intent.putExtra("artist", albums.get(i).getArtist());
                intent.putExtra("title", "track 1");
                intent.putExtra("img_res", albums.get(i).getImg_res());
                startActivity(intent);
            }
        });
        gridView.setAdapter(new AlbumsAdapter(this, albums));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_albums, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.allTracksMenu:
                startActivity(new Intent(this, AllTracksActivity.class));
                break;
            case R.id.artistsMenu:
                startActivity(new Intent(this, ArtistsActivity.class));
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
