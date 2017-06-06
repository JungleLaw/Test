package com.example.jungle.test;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jungle.test.adapter.SimpleAdapter;
import com.example.jungle.test.entity.People;

import java.util.ArrayList;
import java.util.List;

import me.imid.swipebacklayout.lib.app.SwipeBackAutoLayotActivity;

/**
 * Created by Jungle on 2017/6/2.
 */

public class SecondActivity extends SwipeBackAutoLayotActivity {
    RecyclerView recyclerView;
    SimpleAdapter adapter;
    List<People> peoples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerView = (RecyclerView) findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        peoples = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            People people = new People("name " + i, "desc " + i);
            peoples.add(people);
        }
        adapter = new SimpleAdapter(this, peoples);
        recyclerView.setAdapter(adapter);
    }
}
