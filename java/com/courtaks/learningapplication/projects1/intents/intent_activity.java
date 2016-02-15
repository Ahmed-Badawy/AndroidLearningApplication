package com.courtaks.learningapplication.projects1.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.courtaks.learningapplication.Helpers.Chelper;
import com.courtaks.learningapplication.R;

public class intent_activity extends AppCompatActivity {

    public static final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_types_layout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intent_activity, menu);
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



//change activity 1:
    public void normal_intent(View v){
        Log.d("depug","stoped the application");

        Intent intent = new Intent(this , intent_reciever.class); //this refer to the Testing3 Class.
        startActivity(intent); // for regular intents
    }
//change activity 2:
    public void Explicit_intent(View v){
//        if you need to add a extra to the intent you use this:-
        Intent intent = new Intent(this , intent_reciever.class); //this refer to the Testing3 Class.
        Bundle basket = new Bundle();
        basket.putString("name", "data from bundel: bundle name is basket");
        intent.putExtra("basket", basket);

        intent.putExtra("s1", "String to pass to the other activity");
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void Implicit_intent(View v){
        Chelper.toast(this,"You Can use this Implicit Intent By sharing an image to the application");
//        Intent i = new Intent(this,Implicit_intent_activity.class);
//        startActivity(i);
    }


    public void passing_Parcelable_model(View v){
//instead of passing all the model data.(slow & inconvenient) you should pass a parcelable model.
        Intent intent = new Intent(this , intent_reciever.class); //this refer to the Testing3 Class.
        person_model person_obj = new person_model(1,"ahmed",21,44,"this is person info");
        intent.putExtra(".model.person_model", person_obj);
        startActivity(intent);
    }


    public void send_email(View v){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com","courtaks@yahoo.com","admin@ahmed-badawy.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email---man");
        i.putExtra(Intent.EXTRA_TEXT   , "body of email---man");
        try {
            startActivity(Intent.createChooser(i, "Send mail...to me"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    public void view_website(View v){
        String webpage = "http://ahmed-badawy.com/site/cv";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webpage));
        startActivity(intent);
    }

    public void implicitSendText(View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"Hello Every Body... this is my text");
        intent.setType("Text/plain");
        startActivity(intent);
    }


}
