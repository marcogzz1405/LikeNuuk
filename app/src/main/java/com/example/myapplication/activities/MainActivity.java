package com.example.myapplication.activities;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.adapters.AdapterDatos;
import com.example.myapplication.models.PersonModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.drawerMain) DrawerLayout drawerLayout;
    @BindView(R.id.navigationMain) NavigationView navigationView;

    @BindView(R.id.recyclerMain) RecyclerView recyclerView;

    private ActionBarDrawerToggle mToggle;

    View headerView;

    private ArrayList<PersonModel> personModels;
    private PersonModel adapter;
    private AdapterDatos myAdapter;
    private RecyclerView.LayoutManager lManager;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        mToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        personModels = new ArrayList<>();

        personModels.add(new PersonModel("Emma Wilson", R.string.text1, R.drawable.paisaje1));
        personModels.add(new PersonModel("Lavery Maiss", R.string.text2, R.drawable.paisaje2));
        personModels.add(new PersonModel("Lillie Watts", R.string.text3, R.drawable.paisaje3));

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        myAdapter = new AdapterDatos(personModels, this, this);
        recyclerView.setAdapter(myAdapter);

        headerView = navigationView.getHeaderView(0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
