package com.courtaks.learningapplication.projects1.listView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.courtaks.learningapplication.R;

import java.util.List;

/**
 * Created by Courtaks on 2/1/2015.
 */
public class PersonAdapter extends ArrayAdapter<Person> {

    private Context context;
    private List<Person> persons;

    public PersonAdapter(Context context, int resource, List<Person> objects) {
        super(context, resource, objects);

        this.context = context;
        this.persons = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Person current_person = persons.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_custom_layout,null);

        ImageView img1 = (ImageView) view.findViewById(R.id.imageView5);
        img1.setImageResource(current_person.Photo);

        TextView tv = (TextView) view.findViewById(R.id.textView10);
        tv.setText(current_person.Name);

        return view;
//        return super.getView(position, convertView, parent);
    }
}
