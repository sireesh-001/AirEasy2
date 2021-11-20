package com.cuberto.AirEasy;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class Userdetails implements Serializable {

    public String from1;
    public String dest;
    public String way;
    public String f_date;
    public String d_date;
    public String Number;
    public String classes;
    public String type;


    public Userdetails() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Userdetails(String from1,String dest,String way,String f_date,String d_date, String Number,String classes,String type) {
        this.from1 = from1;
        this.dest = dest;
        this.way = way;
        this.f_date=f_date;
        this.d_date = d_date;
        this.Number = Number;
        this.classes = classes;
        this.type = type;
    }

}
