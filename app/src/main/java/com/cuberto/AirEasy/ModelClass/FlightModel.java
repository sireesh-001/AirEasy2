package com.cuberto.AirEasy.ModelClass;

import java.io.Serializable;
import java.util.Comparator;

public class FlightModel implements Serializable {
//    Integer flight_Img;
    String arrival_city,depart_city,airIndia_Txt,number_Txt,rupees_Txt,arrival_Txt,hour_txt,stop_txt,depart_txt;
   public FlightModel(){}

    public FlightModel( String airIndia_Txt,String depart_city,String arrival_city, String number_Txt, String rupees_Txt, String arrival_Txt, String hour_txt, String stop_txt, String depart_txt) {
//        this.flight_Img = flight_Img;
        this.arrival_city=arrival_city;
        this.depart_city=depart_city;
        this.airIndia_Txt = airIndia_Txt;
        this.number_Txt = number_Txt;
        this.rupees_Txt = rupees_Txt;
        this.arrival_Txt = arrival_Txt;
        this.hour_txt = hour_txt;
        this.stop_txt = stop_txt;
        this.depart_txt = depart_txt;
    }

//    public Integer getFlight_Img() {
//        return flight_Img;
//    }

//    public void setFlight_Img(Integer flight_Img) {
//        this.flight_Img = flight_Img;
//    }
    public String getarrival_city() {
    return arrival_city;
}

    public void setarrival_city(String arrival_city) {
        this.arrival_city= arrival_city;
    }
    public String getAirIndia_Txt() {
        return airIndia_Txt;
    }
    public String getdepart_city() {
        return depart_city;
    }

    public void setdepart_city(String depart_city) {
        this.depart_city = depart_city;
    }

    public void setAirIndia_Txt(String airIndia_Txt) {
        this.airIndia_Txt = airIndia_Txt;
    }

    public String getNumber_Txt() {
        return number_Txt;
    }

    public void setNumber_Txt(String number_Txt) {
        this.number_Txt = number_Txt;
    }

    public String getRupees_Txt() {
        return rupees_Txt;
    }

    public void setRupees_Txt(String rupees_Txt) {
        this.rupees_Txt = rupees_Txt;
    }

    public String getArrival_Txt() {
        return arrival_Txt;
    }

    public void setArrival_Txt(String arrival_Txt) {
        this.arrival_Txt = arrival_Txt;
    }

    public String getHour_txt() {
        return hour_txt;
    }

    public void setHour_txt(String hour_txt) {
        this.hour_txt = hour_txt;
    }

    public String getStop_txt() {
        return stop_txt;
    }

    public void setStop_txt(String stop_txt) {
        this.stop_txt = stop_txt;
    }

    public String getDepart_txt() {
        return depart_txt;
    }

    public void setDepart_txt(String depart_txt) {
        this.depart_txt = depart_txt;
    }
}
