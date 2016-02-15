package com.courtaks.learningapplication.projects1;

import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.courtaks.learningapplication.R;

public class lifecycle extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lifecycle, menu);
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


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("life","Started");
        out("Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("life","resumed");
        out("Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("life","Pause");
        out("Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("life","Stop");
        out("Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("life","Destroy");
        out("Destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("life", "Restart");
        out("Restart");
    }

    //this is how to detect the orientaion in android system...
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            out("it's a LandScape---didn't destroy it because of manifest");
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            out("it's a Portrait---didn't destroy it because of manifest");
        }
    }

    public void out(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

}
