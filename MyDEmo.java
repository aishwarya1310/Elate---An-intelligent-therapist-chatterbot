package com.example.hp.myserverconnectivity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by HP on 16-03-2018.
 */
public class MyDEmo
{
    @SerializedName("intent")
    private int id;
    @SerializedName("firstName")
    private String fname;

    public MyDEmo(int id, String fname) {
        this.id = id;
        this.fname = fname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}
