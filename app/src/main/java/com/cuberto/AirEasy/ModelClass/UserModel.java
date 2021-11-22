package com.cuberto.AirEasy.ModelClass;

import java.io.Serializable;
import java.util.ArrayList;

public class UserModel implements Serializable {
    //    Integer flight_Img;
    public String classes;
    public FlightModel model;
    public ArrayList<String> object;
    public Double total;
    public UserModel(){}

    public UserModel( String classes,FlightModel model,ArrayList<String> object,Double total) {
//        this.flight_Img = flight_Img;
        this.classes=classes;
        this.model=model;
        this.object=object;
        this.total=total;
    }
}
