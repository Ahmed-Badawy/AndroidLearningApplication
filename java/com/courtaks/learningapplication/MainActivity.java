package com.courtaks.learningapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.courtaks.learningapplication.Helpers.Chelper;
import com.courtaks.learningapplication.projects1.*;
import com.courtaks.learningapplication.projects1.auto_buttons_with_intents.auto_btns;
import com.courtaks.learningapplication.projects1.intents.intent_activity;
import com.courtaks.learningapplication.projects1.listView.list_activity;
import com.courtaks.learningapplication.projects1.listView2.listView2;
import com.courtaks.learningapplication.projects1.listView2.listView22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.CharsetDecoder;


public class MainActivity extends AppCompatActivity {

    Activity ac = this; //refer to this class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//this is how we verify of the fact that the app gets restarted every screen orientation change:-
        Chelper.toast(ac,"Orientation Changed");//in the create veriry number of times the app gets restarted.





//this will open a context menu on a button
        Button click_hold = (Button) findViewById(R.id.click_hold);
        registerForContextMenu(click_hold); // this will fire the onCreateContextMenu action so we need to override it






//there are three ways you can add an onclick event
//1- take an object from the button then add a .setOnClickListener() Like this:-
        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Chelper.toast(ac,"you clicked button 1");
                goto_elm(v);
            }
        });
//way 2: from the xml layout refer to a method with the onclick event
//way 3: general onClick referance Method
//        Button b1 = (Button) findViewById(R.id.button1);
//        b1.setOnClickListener(this);
    }

//    public void onClick(View v) {
//        int id = v.getId();
//        switch (id) {
//            case R.id.button1:
//                Chelper.toast(this,"button clicked");
//                break;
//            case R.id.button2:
//                break;
//            default:
//                break;
//        }
//    }




//-----------------------------------context menus----------------------------------------------
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_elm_min,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String id = (String) item.getTitle();
        Chelper.toast(this,"the id of the selected item is: "+id);
        return super.onContextItemSelected(item);
    }
//-----------------------------------------------------------------------------------------------







//this is how you config a orientation action
    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) Chelper.toast(ac,"Orientation To Landscape");
        else Chelper.toast(ac,"Orientation To Portrait");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            Log.d("alert","settings clicked man....");
//            return true;
//        }


        switch (id){
            case R.id.action_settings:
                Chelper.toast(ac,"Settings Was Clicked");
                break;
            case R.id.custom1:
                Chelper.toast(ac,"Custom 1 Was Clicked");
                break;
            case R.id.custom2:
                Chelper.toast(ac,"Custom 2 Was Clicked");
                break;
            default:
                Chelper.toast(ac,"no one from the above was clicked");
        }
        return super.onOptionsItemSelected(item);
    }


//    public void goto_elm_min(View v){
//        Chelper.goAc(ac, elm_min.class);
//        Intent OpenCalc = new Intent(this,elm_min.class);
//        this.startActivity(OpenCalc);
//    }

    //this is how you open an activity
    public void goto_elm(View v){
        Chelper.goAc(ac, elm_min.class);
    }
    public void goto_thread(View v){
        Chelper.goAc(ac,thread_activity.class);
    }
    public void goto_lifecycle(View v){
        Chelper.goAc(ac,lifecycle.class);
    }
    public void goto_mediaPlayer(View v){
        Chelper.goAc(ac,mediaPlayer.class);
    }
    public void goto_list1(View v){
        Chelper.goAc(ac,list_activity.class);
    }
    public void goto_list2(View v){
        Chelper.goAc(ac, listView22.class);
    }
    public void goto_dialogues(View v){
        Chelper.goAc(ac, dialogues_activity.class);
    }
    public void goto_intent_types(View v){
        Chelper.goAc(ac, intent_activity.class);
    }
    public void goto_setWallpaper_app(View v){
        Chelper.goAc(ac, SetWallpaperApp.class);
    }
    public void goto_auto_btns(View v){
        Chelper.goAc(ac, auto_btns.class);
    }
    public void goto_contacts_provider(View v){
        Chelper.goAc(ac, Contacts_logger.class);
    }



    public void get_resource(View v){
//        InputStream in = new FileInputStream(new File("C:/temp/test.txt")); //in java
        InputStream is = this.getResources().openRawResource(R.raw.persons); //in android
        String out = null;
        try { out = InputStreamToString(is); } catch(IOException e){ e.printStackTrace(); }
        Log.d("output_data", out);
    }


    @NonNull
    private String InputStreamToString(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
        }
        reader.close();
        is.close();
        return out.toString();
    }



    public void notify_me(View v){ //called statis bar notification
        Intent resultIntent = new Intent(this, MainActivity.class);
        output_notification(10,android.R.drawable.stat_notify_more,
                "Notification Title","Hello! this is the notification text",resultIntent);
        output_notification(20,android.R.drawable.ic_delete,
                "Other Notification","other message",resultIntent);

        Chelper.toast(this, "Notified You!!!");
    }


    private void output_notification(int Mid,int icon,String title,String msg,Intent i){
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(icon)
                        .setContentTitle(title)
                        .setContentText(msg);

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(MainActivity.class);
// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(i);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);


//لعب هنا من الهزاز للستيل
        mBuilder.setAutoCancel(true);
        mBuilder.setLights(Color.BLUE, 500, 500);
        long[] pattern = {500,500,500,500,500,500,500,500,500};
        mBuilder.setVibrate(pattern);
        mBuilder.setStyle(new NotificationCompat.InboxStyle());
//        mBuilder.setSound(Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        mBuilder.setSound(Uri.parse("android.resource://" + MainActivity.this.getPackageName() + "/" + R.raw.song1));
//-------------------------------------------


        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

// mId allows you to update the notification later on.
//        int mId = 40;
        mNotificationManager.notify(Mid,mBuilder.build());

    }

}
