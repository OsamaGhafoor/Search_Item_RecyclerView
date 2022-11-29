package com.blogspot.atifsoftwares.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] versionNames = {
            "Kit Kat 4.4",
            "Kit Kat 4.4.4",
            "Lollipop 5.0",
            "Lollipop 5.1",
            "Marshamallow 6.0",
            "Nougat 7.0",
            "Nougat 7.1",
            "Oreo 8.0",
            "Oreo 8.1",
            "Pie 9",
            "Q 10",
    };
    private String[] apiLevels = {
            "API Level 19",
            "API Level 20",
            "API Level 21",
            "API Level 22",
            "API Level 23",
            "API Level 24",
            "API Level 25",
            "API Level 26",
            "API Level 27",
            "API Level 28",
            "API Level 29",
    };
    private String[] versionDescriptions = {
            "Android development releases are organized into families with alphabetical codenames that are inspired by tasty treats.",
            "Android development releases are organized into families with alphabetical codenames that are inspired by tasty treats.",
            "Android development releases are organized into families with alphabetical codenames that are inspired by tasty treats.",
            "Android development releases are organized into families with alphabetical codenames that are inspired by tasty treats.",
            "Android development releases are organized into families with alphabetical codenames that are inspired by tasty treats.",
            "Android development releases are organized into families with alphabetical codenames that are inspired by tasty treats.",
            "Android development releases are organized into families with alphabetical codenames that are inspired by tasty treats.",
            "Android development releases are organized into families with alphabetical codenames that are inspired by tasty treats.",
            "Android development releases are organized into families with alphabetical codenames that are inspired by tasty treats.",
            "Android development releases are organized into families with alphabetical codenames that are inspired by tasty treats.",
            "Android development releases are organized into families with alphabetical codenames that are inspired by tasty treats."
    };
    private int[] icons = {
            R.drawable.kitkat,
            R.drawable.kitkat,
            R.drawable.lollipop,
            R.drawable.lollipop,
            R.drawable.marshmallow,
            R.drawable.nougat,
            R.drawable.nougat,
            R.drawable.oreo,
            R.drawable.oreo,
            R.drawable.pie,
            R.drawable.q,
    };

    private RecyclerView androidRv;

    private ArrayList<ModelAndroid> androidArrayList;
    private AdapterAndroid adapterAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidRv = findViewById(R.id.androidRv);

        loadItems();
    }

    private void loadItems() {
        androidArrayList = new ArrayList<>();

        for (int i = 0; i < versionNames.length; i++) {
            ModelAndroid modelAndroid = new ModelAndroid(
                    "" + versionNames[i],
                    "" + apiLevels[i],
                    "" + versionDescriptions[i],
                    icons[i]
            );
            androidArrayList.add(modelAndroid);
        }
        adapterAndroid = new AdapterAndroid(this, androidArrayList);
        androidRv.setAdapter(adapterAndroid);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //adapterAndroid.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterAndroid.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}
