package com.courtaks.learningapplication.projects1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.courtaks.learningapplication.Helpers.Chelper;
import com.courtaks.learningapplication.R;

public class thread_activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_activity_layout);

        Thread timer = new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    sleep(5000);
                }catch(Exception e) {
                    e.printStackTrace();
                }finally {
                    finish();
                }
            }
        };
        timer.start();

        TextView tv = Chelper.get_TextView(this,R.id.thread_string);
        tv.setText("it will wait for 5 seconds then it will finish");

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_thread_activity, menu);
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
