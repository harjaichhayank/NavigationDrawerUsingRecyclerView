package com.example.navigationDrawerWithRecyclerView;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
    DrawerLayout drawerLayout;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<String> arrayList = new ArrayList<>();

    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        drawerLayout = findViewById(R.id.DrawerLayout);
        recyclerView.setHasFixedSize(true);

        items = getResources().getStringArray(R.array.TOPICS);
        arrayList.addAll(Arrays.asList(items));

        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);

        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }
}
