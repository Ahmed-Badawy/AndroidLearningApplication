package com.courtaks.learningapplication.projects1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.courtaks.learningapplication.Helpers.Chelper;
import com.courtaks.learningapplication.R;


public class elm_min extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elm_min_layout);

//        getActionBar().setDisplayHomeAsUpEnabled(true);


        Button b = Chelper.get_button(this,R.id.show_info);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = Chelper.get_editText_string(elm_min.this, R.id.user_name);
                String pass = Chelper.get_editText_string(elm_min.this, R.id.password);

                if(user_name.equals("shit"))Chelper.toast(elm_min.this,"fuck, he said shit");
                Chelper.toast(elm_min.this,user_name+"--"+pass);
            }
        });

        final ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton); //final means it's going to change for this instance.
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggle.isChecked()){
                    Chelper.toast(elm_min.this,"it's Checked");
                }else{
                    Chelper.toast(elm_min.this,"it's Not Checked");
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_elm_min, menu);
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
        else if (id == R.id.finish) {
            //this is how you finish an activity
            finish();
        }
        return super.onOptionsItemSelected(item);
    }



}
