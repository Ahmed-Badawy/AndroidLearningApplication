package com.courtaks.learningapplication.projects1.intents;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.courtaks.learningapplication.Helpers.Chelper;
import com.courtaks.learningapplication.R;

public class intent_reciever extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_reciever);

        Intent i = getIntent();
        if(i.hasExtra("basket")) {
            Chelper.toast(this,"it's an advanced intent");

            Bundle basket = i.getBundleExtra("basket");
            String name = basket.getString("name");

            String s1 = i.getStringExtra("s1");
            Chelper.toast(this, "bundle data is: " + name + "-- & string data is: " + s1);


//you can return with data like here:-
//            i.putExtra("result","result is here");
//            setResult(RESULT_OK,i);
//            finish();
//you must receive the data on the other side with the code fuckshit

        }else if(i.hasExtra(".model.person_model")){
            person_model person = i.getParcelableExtra(".model.person_model");
            Chelper.toast(this,"Person_name is: "+person.Name+" & age is: "+person.Age);
        }else Chelper.toast(this,"ok! it's a normal intent");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intent_reciever, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





}
