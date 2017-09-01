package com.example.pacman.first_app;

/**
 * Created by 123 on 8/31/2017.
 */

public class person {

    int imageid;
    String personName;
    String mobileNumber;

    public person(int imageid, String personName, String mobileNumber) {
        this.imageid = imageid;
        this.personName = personName;
        this.mobileNumber = mobileNumber;

    }


    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid)
    {
        this.imageid = imageid;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
