package com.example.foodi;


public class Food {
    private String name;
    private int resID;
    private String time;

    public Food(String name, int resID,String time) {
            this.name = name;
            this.resID = resID;
            this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
