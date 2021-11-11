package com.cuberto.AirEasy.ModelClass;

public class FlightSearchResultModelClass {

    String tvTitle,tvPrice;

    public FlightSearchResultModelClass(String tvTitle, String tvPrice) {
        this.tvTitle = tvTitle;
        this.tvPrice = tvPrice;
    }

    public String getTvTitle() {
        return tvTitle;
    }

    public void setTvTitle(String tvTitle) {
        this.tvTitle = tvTitle;
    }

    public String getTvPrice() {
        return tvPrice;
    }

    public void setTvPrice(String tvPrice) {
        this.tvPrice = tvPrice;
    }
}
