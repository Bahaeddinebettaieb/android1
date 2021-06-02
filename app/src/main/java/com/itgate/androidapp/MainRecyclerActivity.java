package com.itgate.androidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerActivity extends AppCompatActivity {
    RecyclerView recyclerView,cartItemsTv;
    List<ModelTech> techList;
    TechnoAdapter adapterTech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycler);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_tech);
        ArrayList<ModelTech> techList = new ArrayList<>();
        techList.add(new ModelTech("Angular","Angular est un Framework open source écrit en JavaScript.",R.drawable.angular));
        techList.add(new ModelTech("Android","Android est un système d'exploitation mobile fondé sur le noyau Linux et développé par Google.",R.drawable.android));
        techList.add(new ModelTech("Flutter","Flutter est un kit de développement de logiciel (SDK) d'interface utilisateur open-source créé par Google.",R.drawable.flutter));

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_tech);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterTech = new TechnoAdapter(this, techList);
        recyclerView.setAdapter(adapterTech);

    }
}