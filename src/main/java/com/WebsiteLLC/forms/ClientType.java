package com.WebsiteLLC.forms;


public enum ClientType {

    ACTIVE ("Active"),
    PENDING ("Pending"),
    DROPPED ("Dropped");


    private final String name;

    ClientType (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
