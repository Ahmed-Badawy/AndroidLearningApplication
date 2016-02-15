package com.courtaks.learningapplication.projects1.listView;

/**
 * Created by Courtaks on 2/1/2015.
 */
public class Person {
    public int index;
    public String Name;
    public int Age;
    public int Photo;
    public String person_info;

    public Person(String name,int age , int photo , String person_info){
        this.Name = name;
        this.Age = age;
        this.Photo = photo;
        this.person_info = person_info;
    }

    public String toString(){
        return this.Name;
    }

}
