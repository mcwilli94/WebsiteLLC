package com.WebsiteLLC.forms;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Users {
    //Initialize Variables
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=30, message = "Please provide a valid email address")
    private String username;

    @NotNull
    @Size(min=3, max=30, message = "Please provide a valid password")
    private String password;

    @NotNull
    @Range(min=1, max = 5, message = "Please choose 1 to 5 stars")
    private Integer rating;

    @NotNull
    @Size(min=10, max=1000)
    private String comment;

    //Getters and Setters


    @NotNull
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating(){
        return rating;
    }

    public void setRating(Integer rating){
        this.rating = rating;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    //Constructors
    public Users(){}

    public Users(String username, String password, Integer rating, String comment){
        this.username = username;
        this.password = password;
        this.comment = comment;
        this.rating = rating;
    }

}
