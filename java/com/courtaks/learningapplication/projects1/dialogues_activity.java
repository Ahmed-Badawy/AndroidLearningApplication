package com.courtaks.learningapplication.projects1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.courtaks.learningapplication.R;

public class dialogues_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogues_activity);
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
    }


    private AlertDialog alert;


    //opening a dialogue
    public void open_dialogue1(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Attention").
                setIcon(android.R.drawable.ic_delete).
                setMessage("Do you want to close this App ?");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                alert.dismiss();
            }
        });
        alert = builder.create();
        alert.setCanceledOnTouchOutside(false);
        alert.show();
    }


    public void open_dialogue2(View v) {
        Dialog d = new Dialog(this);
        d.setContentView(R.layout.activity_lifecycle);
        d.show();
    }

    public void open_dialogue3(View v) {
        ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Ahmed Badawy is currently getting data mother fucker...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
    }

}
