package com.courtaks.learningapplication.projects1.listView2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.courtaks.learningapplication.Helpers.Chelper;
import com.courtaks.learningapplication.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class listView22 extends AppCompatActivity {


    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




        String[] arr = {
                "Today - Sunny - 88/63",
                "Tomorrow - Foggy - 70/40",
                "Weds - Cloudy - 72/63",
                "Thurs - Asteroids - 72/63",
                "Fri - Asteroids - 72/63",
                "Sat - Asteroids - 72/63",
                "Sun - Asteroids - 72/63"
        };
        List<String> arr2 = new ArrayList<String>(Arrays.asList(arr));

        Log.d("list_view_error", String.valueOf(arr2));

        //getActivity() method returns a instance of the current Activity. used by static methods instead of MainActivity.this
        //with in the fragments we can't use the findViewById directly, we use the rootView to get to it.
        adapter = new ArrayAdapter<String>(this,R.layout.list_item_layout,R.id.ourListView,arr2);
//            adapter = new ArrayAdapter<String>(getActivity(),R.layout.list_item_layout,arr2);

        ListView lv = (ListView) findViewById(R.id.ourListView);
        lv.setAdapter(adapter);


    }







}
