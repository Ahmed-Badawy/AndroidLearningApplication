package com.courtaks.learningapplication.projects1.listView;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.courtaks.learningapplication.Helpers.Chelper;
import com.courtaks.learningapplication.R;

import java.util.List;

public class list_activity extends ListActivity {


    List<Person> persons = new PersonsData().GetPersons();
    public static final int REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activity);
    }

    @Override
    protected void onResume() {
        super.onResume();
//this one generate a list with texts:- also person class gets a toString output to the name
//        ArrayAdapter<Person> adapter = new ArrayAdapter<Person>(this,android.R.layout.simple_expandable_list_item_1,persons);

//also we can use xml string arrays like this:
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_expandable_list_item_1,
//                getResources().getStringArray(R.array.countries)
//        );

//this one generate a list with custom view (personAdapter creation):-
        PersonAdapter adapter = new PersonAdapter(this,R.layout.list_custom_layout,persons);


        setListAdapter(adapter);
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

//get the name of the person in that position & toast it:-
        Chelper.toast(this, persons.get(position).Name);
        //or you can just pass it to another activity to view the person

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.custom_menu, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) { return true; }
        return super.onOptionsItemSelected(item);
    }
}
