/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c;

/**
 *
 * @author icechycoco
 */
public class Account {
    
    private long acc_id;
    private String acc_name;
    private double balance;
    private String date;
    private String email;
    private String phone_num;
    private String id_no;
    private String address;
    private String acc_fname;
    private String acc_lname;
    
    public void setFirstname(String acc_fname){
        this.acc_fname = acc_fname;
    }
    public void setLastname(String acc_fname){
        this.acc_fname = acc_fname;
    }
    
    public String getFirstname(){
        return acc_fname;
    }
    public String getLastname(){
        return acc_lname;
    }
    
    public void setAcc_id(long acc_id) {
        this.acc_id = acc_id;
    }

    public void setAcc_name(String acc_name) {
        this.acc_name = acc_name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getAcc_id() {
        return acc_id;
    }

    public String getAcc_name() {
        return acc_name;
    }

    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public String getId_no() {
        return id_no;
    }

    public String getAddress() {
        return address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
