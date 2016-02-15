package com.courtaks.learningapplication.projects1.listView2;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.courtaks.learningapplication.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class listView2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        /* A placeholder fragment containing a simple view. */
        private ArrayAdapter<String> adapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_list_view2, container, false);

            String[] arr = {
                    "Today - Sunny - 88/63",
                    "Tomorrow - Foggy - 70/40",
                    "Weds - Cloudy - 72/63",
                    "Thurs - Asteroids - 72/63",
                    "Fri - Asteroids - 72/63",
                    "Sat - Asteroids - 72/63",
                    "Sun - Asteroids - 72/63"
            };
            List<String> arr2 = new ArrayList<String>(Arrays.asList(arr));

            Log.d("list_view_error", String.valueOf(arr2));

            //getActivity() method returns a instance of the current Activity. used by static methods instead of MainActivity.this
            //with in the fragments we can't use the findViewById directly, we use the rootView to get to it.
            adapter = new ArrayAdapter<String>(getActivity(),R.layout.list_item_layout,R.id.ourListView,arr2);
//            adapter = new ArrayAdapter<String>(getActivity(),R.layout.list_item_layout,arr2);

            ListView lv = (ListView) rootView.findViewById(R.id.ourListView);
            lv.setAdapter(adapter);

            return rootView;
        }
    }
}
