package com.courtaks.learningapplication.projects1.auto_buttons_with_intents;

/**
 * Created by courtaks on 1/26/2016.
 */
public class flower_model {

    public int id;
    public String name;
    public String desc;
    public int imageResource;


    public flower_model(int id,String name,int imageResource, String desc){
        this.id = id;
        this.name = name;
        this.imageResource = imageResource;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return this.name;
    }


}
