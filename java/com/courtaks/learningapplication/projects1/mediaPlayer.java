package com.courtaks.learningapplication.projects1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.courtaks.learningapplication.Helpers.Chelper;
import com.courtaks.learningapplication.R;

public class mediaPlayer extends ActionBarActivity {
    MediaPlayer oursong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player_layout);
        oursong = MediaPlayer.create(this,R.raw.song1);
//        oursong.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_media_player, menu);
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

    public void play(View v){
        oursong.start();
    }
    public void pause(View v){
        oursong.pause();
        int pos = oursong.getCurrentPosition();
        Log.d("ddd", String.valueOf(pos));
    }
    public void stop(View v){
        oursong.stop();
    }
    public void seek(View v){
        oursong.seekTo(30000);
    }


}
