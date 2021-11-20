package com.cuberto.AirEasy.ModelClass;

public class FlightSearchResultModelClass {

    String tvTitle;
    String airIndia_Txt,number_Txt,rupees_Txt,arrival_Txt,hour_txt,stop_txt,depart_txt;
    public FlightSearchResultModelClass(){}


    public FlightSearchResultModelClass(String tvTitle, String tvPrice) {
        this.tvTitle = tvTitle;
        this.airIndia_Txt = airIndia_Txt;
        this.number_Txt = number_Txt;
        this.rupees_Txt = rupees_Txt;
        this.arrival_Txt = arrival_Txt;
        this.hour_txt = hour_txt;
        this.stop_txt = stop_txt;
        this.depart_txt = depart_txt;

    }

    public String getTvTitle() {
        return tvTitle;
    }

    public void setTvTitle(String tvTitle) {
        this.tvTitle = tvTitle;
    }


    public String getAirIndia_Txt() {
        return airIndia_Txt;
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
