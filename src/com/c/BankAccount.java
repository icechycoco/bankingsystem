/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c;

import java.util.ArrayList;
import java.util.HashMap;

public class BankAccount extends Account {
    /*
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
*/
    public static boolean openAccount(String name, double balance,
            String email,
            String phone_num, String id_no,
            String address, String acc_fname, String acc_lname) {
        
        ConnectDB c = new ConnectDB();
        c.connect();

        long id = System.currentTimeMillis();

        String sql_openAccount = "INSERT INTO "
                + "BANK_ACCOUNT(acc_id,acc_name,balance,date,email,phone_num,id_no,address,fname,lname)"
                + "VALUES ('" + id + "','" + name + "','" + balance + "','" + new java.sql.Date(System.currentTimeMillis())
                + "','" + email + "','" + phone_num + "','" + id_no + "','" + address + "','" + acc_fname + "','" + acc_lname + "')";

        String code = "OPA";
        String sql_transaction = "INSERT INTO BANK_TRANSACTION (code,staff_id,date,amount,acc_id,balance)"
                + " VALUES ('" + code + "','1234','" + new java.sql.Date(System.currentTimeMillis()) + "'," + balance + "," + id + ","+balance+
        ")";
        c.db.executeQuery(sql_transaction);
        boolean check = c.db.executeQuery(sql_openAccount);
        return check;
    }
    
    public static double getBalanceNow(long acc_id){
        ConnectDB c = new ConnectDB();
        c.connect();
            c.db.connect();
            double balance = 0;
            String sql = "SELECT balance FROM BANK_ACCOUNT WHERE acc_id = ('" + acc_id + "')";

             ArrayList<HashMap> data = c.db.queryRows(sql);

            if (data != null && data.size() > 0){
                for (int i = 0; i < data.size(); i++){
                    HashMap std = data.get(i);
                    balance = Double.parseDouble((String) std.get("balance"));
                 }
            }
            c.db.disconnect();
            return balance;
     }
    
     public static BankAccount search(long acc_id) {
        ConnectDB c = new ConnectDB();
        c.connect();
        c.db.connect();
        
        String sql_search = "SELECT * FROM BANK_ACCOUNT WHERE acc_id = ('" + acc_id + "')";

        ArrayList<HashMap> data = c.db.queryRows(sql_search);
        BankAccount ba = null;

        if (data != null && data.size() > 0) {
            ba = new BankAccount();
            for (int i = 0; i < data.size(); i++) {
                HashMap std = data.get(i);
                           
                ba.setAcc_name((String) std.get("acc_name"));
                ba.setAcc_id(Long.parseLong((String) std.get("acc_id")));
                ba.setAddress((String) std.get("address"));
                ba.setBalance(Double.parseDouble((String) std.get("balance")));
                ba.setDate((String) std.get("date"));
                ba.setId_no((String) std.get("id_no"));
                ba.setEmail((String) std.get("email"));
                ba.setPhone_num((String) std.get("phone_num"));

            }
        }
        return ba;
    }
     
     public double calculateInterest(long acc_id)
    {
            BankAccount user = BankAccount.search(acc_id);
            return user.getBalance()*0.1/100;
    }
    
    public double balanceUpdateInterest(double interest)
    {
           double balance = (interest/0.1)*100;
            balance = balance + interest;
            return balance;
    }
}
