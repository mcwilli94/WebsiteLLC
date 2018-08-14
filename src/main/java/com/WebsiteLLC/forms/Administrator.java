package com.WebsiteLLC.forms;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Administrator {
    //Initialize Variables
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=30, message = "Username or password is incorrect")
    private String administrator;

    @NotNull
    @Size(min=3, max=30, message = "Username or password is incorrect")
    private String password;


    // Getters
    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String name){
        this.administrator = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId(){
        return id;
    }

    // Constructor
    public Administrator(String administrator, String password){
        this.administrator = administrator;
        this.password = password;
    }

    public Administrator(){}
}

