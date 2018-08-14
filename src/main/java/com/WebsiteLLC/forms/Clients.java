package com.WebsiteLLC.forms;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Clients {
    //Initialize Variables
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, max=30, message = "Please provide a first name for the client")
    private String firstname;

    @Size(min=1, max=30)
    private String middlename;

    @NotNull
    @Size(min=1, max=30, message = "Please provide a last name for the client")
    private String lastname;

    private Date entryDate;

    private Float currentBalance;

    private ClientType clientStatus;


    //Constructors
    public Clients(){}

    public Clients( String firstname, String middlename, String lastname, Date entryDate, Float currentBalance, ClientType status) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.entryDate = entryDate;
        this.currentBalance = currentBalance;
        this.clientStatus = status;
    }

    public Clients( String firstname, String middlename, String lastname, ClientType status) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.clientStatus = status;
    }

    public Clients( String firstname, String lastname, ClientType status) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.clientStatus = status;
    }


    public Clients(String firstname, String middlename, String lastname){
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
    }

    public Clients(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Clients( String firstname, String middlename, String lastname, Date entryDate) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.entryDate = entryDate;
    }

    public Clients(String firstname, String lastname, Date entryDate){
        this.firstname = firstname;
        this.lastname = lastname;
        this.entryDate = entryDate;
    }


    public Clients( String firstname, String middlename, String lastname, Float currentBalance) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.currentBalance = currentBalance;
    }

    public Clients( String firstname, String lastname, Float currentBalance) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.currentBalance = currentBalance;
    }




    //Getters and Setters
    public int getId() {
        return id;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename(){ return middlename; }

    public void setMiddlename(String middlename) { this.middlename = middlename; }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }


    public Float getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Float currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void madePayment(Float payment){
        this.currentBalance = currentBalance - payment;
    }

    public void addFees(Float fees){
        this.currentBalance = currentBalance + fees;
    }

    public ClientType getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(ClientType clientStatus) {
        this.clientStatus = clientStatus;
    }
}
