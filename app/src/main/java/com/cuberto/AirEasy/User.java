package com.cuberto.AirEasy;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class User implements Serializable {

    public String firstname;
    public String lastname;
    public String email;
    public String mnumber;
    public String dob;
    public String password;
    public String pin;


    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String firstname,String lastname,String email,String mnumber,String dob, String password,String pin) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.mnumber=mnumber;
        this.dob = dob;
        this.password = password;
        this.pin = pin;
    }

}
