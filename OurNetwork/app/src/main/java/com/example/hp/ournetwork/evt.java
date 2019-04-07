package com.example.hp.ournetwork;

public class evt {
    private int photo;
    private String name;
    private String date;


    public evt(int photo, String name,String date) {
        this.photo = photo;
        this.name = name;
        this.date = date;

    }

    public int getphoto() {
        return photo;
    }

    public void setphoto(int photo) {
        this.photo = photo;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.date = date;
    }

    public String getdate() {
        return date;
    }

    public void setdate(String name) {
        this.date = date;
    }

}