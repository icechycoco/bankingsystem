/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c;

import com.m.connectDB;
import edu.sit.cs.db.CSDbDelegate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Nann
 */
public class BankAccount  {
    
    private long acc_id;
    private String acc_name;
    private double balance;
    private String date;
    private String gender;
    private String email;
    private String phone_num;
    private String id_no;
    private String revenue_month;
    private String career;
    private int age;
    private String birthdate;
    private String address;
    
    public void setAcc_id(long acc_id) {
        this.acc_id = acc_id;
    }

    public void setAcc_name(String acc_name) {
        this.acc_name = acc_name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public void setRevenue_month(String revenue_month) {
        this.revenue_month = revenue_month;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
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

    public String getGender() {
        return gender;
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

    public String getRevenue_month() {
        return revenue_month;
    }

    public String getCareer() {
        return career;
    }

    public int getAge() {
        return age;
    }

    public String getBirthdate() {
        return birthdate;
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
    
    
    public static boolean openAccount(String name, double balance,
            String gender, String email,
            String phone_num, String id_no,
            String revenue_month, String career, int age,
            String birthdate, String address) {

        //CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
        //System.out.println(db.connect());
        connectDB c = new connectDB();
        c.connectDb();

        long id = System.currentTimeMillis();

        String sql_openAccount = "INSERT INTO "
                + "BANK_ACCOUNT(acc_id,acc_name,balance,date,gender,email,phone_num,id_no,revenue_month,career,age,birthdate,address)"
                + "VALUES ('" + id + "','" + name + "','" + balance + "','" + new java.sql.Date(System.currentTimeMillis())
                + "','" + gender + "','" + email + "','" + phone_num + "','" + id_no + "','" + revenue_month + "'"
                + ",'" + career + "','" + age + "','" + birthdate + "','" + address + "')";

        String code = "OPA";
        String sql_transaction = "INSERT INTO BANK_TRANSACTION (code,staff_id,date,amount,acc_id,balance)"
                + " VALUES ('" + code + "','1234','" + new java.sql.Date(System.currentTimeMillis()) + "'," + balance + "," + id + ","+balance+
        ")";
        c.db.executeQuery(sql_transaction);
        boolean check = c.db.executeQuery(sql_openAccount);
        return check;
    }

}
