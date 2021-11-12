package com.cuberto.AirEasy.ModelClass;

public class FlightCancellationModel {

    String sourceDes;

    public FlightCancellationModel(String sourceDes) {
        this.sourceDes = sourceDes;
    }

    public String getSourceDes() {
        return sourceDes;
    }

    public void setSourceDes(String sourceDes) {
        this.sourceDes = sourceDes;
    }
}
