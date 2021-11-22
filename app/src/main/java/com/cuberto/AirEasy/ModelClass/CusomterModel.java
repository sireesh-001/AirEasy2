
package com.cuberto.AirEasy.ModelClass;
import java.io.Serializable;
import java.util.ArrayList;


public class CusomterModel implements Serializable {
    public FlightModel model=new FlightModel();
    public double  total;
    public String classes;
    public String pnr;
    public ArrayList<String> object = new ArrayList<String>();

    public CusomterModel(){}

    public CusomterModel( FlightModel model,double total,String classes,String pnr,ArrayList<String> object) {

        this.model=model;
        this.total=total;
        this.classes = classes;
        this.pnr = pnr;
        this.object = object;
    }

}
