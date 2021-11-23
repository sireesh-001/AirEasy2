package com.cuberto.AirEasy.ModelClass;

import java.io.Serializable;

public class profileModel implements Serializable {
    public String name, email, phone, city, passport, state, country, zip;

    public profileModel() {
    }

    public profileModel( String phone, String email, String name, String city, String passport, String state, String country, String zip) {


        this.name = name;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.passport = passport;
        this.state = state;
        this.country = country;
        this.zip = zip;

    }
}


