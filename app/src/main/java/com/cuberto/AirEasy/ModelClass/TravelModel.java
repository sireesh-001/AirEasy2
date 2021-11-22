package com.cuberto.AirEasy.ModelClass;


import java.io.Serializable;

public class TravelModel implements Serializable {
    //    Integer flight_Img;
    public String name, email, gender, age, company, rn;

    public TravelModel() {
    }

    public TravelModel(String gender, String email, String name, String age, String company, String rn) {
//        this.flight_Img = flight_Img;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.company = company;
        this.rn = rn;

    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRn() {
        return rn;
    }

    public void setRn(String rn) {
        this.rn = rn;
    }
}


