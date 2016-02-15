package com.courtaks.learningapplication.projects1;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.courtaks.learningapplication.R;

import java.io.IOException;
import java.io.InputStream;

//this app will take a pic then set it to the wallpaper of the mobile.
public class SetWallpaperApp extends ActionBarActivity implements View.OnClickListener {

    //first we implemented the View.OnClickListener to use the Progressive on click button listener...
/*
manifest modifications
                  1- permission to set wallpaper
                  2- not destroy activity on orientation changes so we fixed orientation to portrait

*/

    public static final int cameraData = 0;
    ImageButton ib;
    Button b;
    ImageView iv;
    Intent i;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_layout);

        initialize();

//        InputStream is = getResources().openRawResource(R.drawable.pic1);
//        bmp = BitmapFactory.decodeStream(bitmap);

    }

    public void initialize() {
        iv = (ImageView) findViewById(R.id.imageView);
        ib = (ImageButton) findViewById(R.id.take_pic);
        b = (Button) findViewById(R.id.set_wallpaper);

        b.setOnClickListener(this);
        ib.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_camera, menu);
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
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.set_wallpaper:
                try {
                    WallpaperManager.getInstance(SetWallpaperApp.this).setBitmap(bmp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.take_pic:
                i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, cameraData);
                break;
        }

    }

    //gets the result after taking the pic...
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            bmp = (Bitmap) extras.get("data");
            iv.setImageBitmap(bmp);
            ib.setImageBitmap(bmp);
        }
    }


}
