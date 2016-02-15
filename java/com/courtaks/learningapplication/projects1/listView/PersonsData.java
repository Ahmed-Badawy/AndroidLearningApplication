package com.courtaks.learningapplication.projects1.listView;


import com.courtaks.learningapplication.R;

import java.util.ArrayList;

/**
 * Created by Courtaks on 2/1/2015.
 */
public class PersonsData {
    ArrayList<Person> Persons_Array = new ArrayList<Person>();

    public PersonsData() {
        for(int i=0; i < 4 ; i++){
            add_person("mona",24, R.drawable.pic1,"data1");
            add_person("ahmed",22,R.drawable.pic2,"this is the wanted data to write on this page...\n it's a dummy data...");
            add_person("mohamed",50,R.drawable.pic3,"data3");
            add_person("ali",80,R.drawable.pic4,"data4");
        }
    }

    public ArrayList<Person> GetPersons(){
        return Persons_Array;
    }

    private void add_person(String name,int age , int photo , String person_info) {
        Person person_obj = new Person(name,age,photo,person_info);
        Persons_Array.add(person_obj);
    }

}
