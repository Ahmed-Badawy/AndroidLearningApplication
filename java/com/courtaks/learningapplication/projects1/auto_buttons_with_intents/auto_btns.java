package com.courtaks.learningapplication.projects1.auto_buttons_with_intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.courtaks.learningapplication.Helpers.Chelper;
import com.courtaks.learningapplication.R;

import java.util.ArrayList;
import java.util.List;


public class auto_btns extends AppCompatActivity {

    final int RequestCode = 100;

    //this gets called when a activity come back with a result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == this.RequestCode && resultCode == RESULT_OK){
            String flowerName = data.getStringExtra("flowerName");
            String action = data.getStringExtra("action");
            if(action.equals("add_to_cart")) Chelper.toast(this, "item :" + flowerName + " was added to to the cart");
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_btns);
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


//refer to the id of the view linearLayout
        LinearLayout layout = (LinearLayout) findViewById(R.id.auto_btns);
        List<flower_model> flowers_list = this.generate_flowers_list();

//must put final to access it from the onClick method.. (final) means it's a constant can't be modified.
        for(final flower_model flower : flowers_list){
            Chelper.toast(this, flower.toString());
            Button button = new Button(this);
            button.setText(flower.name);
            layout.addView(button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(auto_btns.this,auto_butns_item_view.class);
                    i.putExtra("flowerId",flower.id);
                    i.putExtra("flowerName",flower.name);
                    i.putExtra("flowerDesc",flower.desc);
                    i.putExtra("flowerImg", flower.imageResource);

//                    startActivity(i);

//in order to get back information from an activity you must use
                    startActivityForResult(i,RequestCode); //the 100 is a request code

                }
            });
        }

    }



    private List<flower_model> generate_flowers_list(){
        List<flower_model> flowers_list = new ArrayList<>();
        flower_model flower1 = new flower_model(1,"flower 1",R.drawable.me,"this is desc 1");
        flower_model flower2 = new flower_model(2,"flower 2",R.drawable.me,"this is desc 2");
        flower_model flower3 = new flower_model(3,"flower 3",R.drawable.me,"this is desc 3");
        flowers_list.add(flower1);
        flowers_list.add(flower2);
        flowers_list.add(flower3);
        return flowers_list;
    }






}
