package com.courtaks.learningapplication.projects1.auto_buttons_with_intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.courtaks.learningapplication.Helpers.Chelper;
import com.courtaks.learningapplication.R;

public class auto_butns_item_view extends AppCompatActivity {

    private String flowerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_btns_item_view);

//get the intent data
        Intent intent = getIntent();
        int flowerId = intent.getIntExtra("flowerId", 0); //in getIntExtra you must pass a default value
        String flowerName = intent.getStringExtra("flowerName");
        String flowerDesc = intent.getStringExtra("flowerDesc");
        int flowerImg = intent.getIntExtra("flowerImg", 0);

//set the header
        TextView header = (TextView) findViewById(R.id.auto_btns_header);
        header.setText(flowerName);
//set the desc
        TextView desc = (TextView) findViewById(R.id.auto_btns_desc);
        desc.setText(flowerDesc);
//set the img
        ImageView img = (ImageView) findViewById(R.id.auto_btns_img);
        img.setImageResource(flowerImg);


        this.flowerName = flowerName;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.auto_btn_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.add_to_cart:
                Chelper.toast(this, "Add To Cart Was Clicked");
                add_to_cart();
                break;
            default:
                Chelper.toast(this,"no one from the above was clicked");
        }
        return super.onOptionsItemSelected(item);
    }


    private void add_to_cart() {
        Intent i = new Intent();
        i.putExtra("flowerName",this.flowerName);
        i.putExtra("action","add_to_cart");
        setResult(RESULT_OK,i);
        finish();
    }



}
