package com.courtaks.learningapplication.projects1.intents;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by courtaks on 2/2/2016.
 */
public class person_model implements Parcelable{

    public long Id;
    public String Name;
    public int Age;
    public int Photo;
    public String person_info;

    public person_model(){

    }

    public person_model(int id, String name, int age, int photo, String person_info){
        this.Id = id;
        this.Name = name;
        this.Age = age;
        this.Photo = photo;
        this.person_info = person_info;
    }

    public person_model(String name, int age, int photo, String person_info){
        this.Name = name;
        this.Age = age;
        this.Photo = photo;
        this.person_info = person_info;
    }

    public String toString(){
        return this.Id+" - "+this.Name;
    }




    protected person_model(Parcel in) {
        Log.i("logtag", "Parcel constructor");
        Id = in.readLong();
        Name = in.readString();
        Age = in.readInt();
        Photo = in.readInt();
        person_info = in.readString();
    }

    public static final Creator<person_model> CREATOR = new Creator<person_model>() {
        @Override
        public person_model createFromParcel(Parcel in) {
            Log.i("logtag", "Parcel createFromParcel");
            return new person_model(in);
        }

        @Override
        public person_model[] newArray(int size) {
            Log.i("logtag", "parcel new array");
            return new person_model[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Log.i("logtag", "Parcel Write");
        dest.writeLong(Id);
        dest.writeString(Name);
        dest.writeInt(Age);
        dest.writeInt(Photo);
        dest.writeString(person_info);
    }
    @Override
    public int describeContents() {
        return 0;
    }





}
