package com.courtaks.learningapplication.Helpers;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by courtaks on 2/28/2015.
 */
public class Chelper {

    public static TextView get_TextView(Activity activity,int what){
        TextView ans = (TextView) activity.findViewById(what);
        return ans;
    }
    public static String get_TextView_string(Activity activity,int what){
        TextView ans = (TextView) activity.findViewById(what);
        String str = (String) ans.getText();
        return str;
    }

    public static String get_editText_string(Activity activity,int what){
        EditText ans = (EditText) activity.findViewById(what);
        String str = ans.getText().toString();
        return str;
    }

    public static Button get_button(Activity activity,int id){
        Button b = (Button) activity.findViewById(id);
        return b;
    }

    public static void goAc(Activity activity1, Class activity2){
        Intent OpenCalc = new Intent(activity1,activity2);
        activity1.startActivity(OpenCalc);
    }

    public static void toast(Activity activity, String txt){
        Toast toast = Toast.makeText(activity, txt, Toast.LENGTH_SHORT);
        int xoffset=30,yoffset=30;
        toast.setGravity(Gravity.RIGHT,xoffset,yoffset);
        toast.show();
    }


}
