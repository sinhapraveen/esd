package com.rdc.utilities.esd.model;


import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

@Document(collection = "RDCUsers", schemaVersion= "1.0")
public class RDCUsers {
    @Id
    private String userID;

   private String fname;

    private String lname;

    private String location;

    public RDCUsers() {
    }

    public RDCUsers(String userID, String fname, String lname, String location) {
        this.userID = userID;
        this.fname = fname;
        this.lname = lname;
        this.location = location;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "RDCUsers{" +
                "userID='" + userID + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
