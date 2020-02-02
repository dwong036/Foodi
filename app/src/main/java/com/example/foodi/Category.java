package com.example.foodi;

public class Category {
    private String name;
    private String description;
    private int resId;
    private boolean picked;

    public Category(String name, String description, int resId) {
        this.name = name;
        this.description = description;
        this.resId = resId;
        this.picked = false;
    }

    public Category(String name, String description, int resId, boolean picked) {
        this.name = name;
        this.description = description;
        this.resId = resId;
        this.picked = picked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPicked() {
        return picked;
    }

    public void setPicked(boolean picked) {
        this.picked = picked;
    }

    public int getResId() {
        return resId;
    }
}
