package com.courtaks.learningapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.courtaks.learningapplication.Helpers.Chelper;

/**
 * Created by courtaks on 1/21/2016.
 */
public class customPhoneReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if(extras != null){
            String state = extras.getString(TelephonyManager.EXTRA_STATE);
            Log.d("phoneReceiver", state);
            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                String phoneNumber = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.d("phoneReceiver", "the Phone number is: "+phoneNumber);
//                Toast.makeText(super.class ,"the calling number is: " + phoneNumber, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
