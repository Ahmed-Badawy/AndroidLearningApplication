package com.courtaks.learningapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Contacts_logger extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_logger);
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
    }


    public void log_contacts(View v){
        Cursor people = getContentResolver().query( ContactsContract.Contacts.CONTENT_URI,null,null,null,null );
        TextView log_contacts_tv = (TextView) findViewById(R.id.log_contacts_tv);
        StringBuilder sb = new StringBuilder();

        while(people.moveToNext()){
            int name_index = people.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME);
//            int number_index = people.getColumnIndex(ContactsContract.PhoneLookup.NUMBER);
            String name = people.getString(name_index);
//            String number = people.getString(number_index);
            if (name != null) {
//                Log.d("debug", name);
                sb.append(name+"\n");
//                sb.append(" - "+number+"\n");
            }
        }

//        Log.d("debug",sb.toString());
        log_contacts_tv.setText(sb.toString());

    }






}
