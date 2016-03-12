/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import edu.sit.cs.db.CSDbDelegate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Nann
 */
public class BankTransaction {
    private String acc_name;
    private long acc_id;
    private String trans_id;
    private String code;
    private String staff_id;
    private String date;
    private double amount;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAcc_name(String acc_name) {
        this.acc_name = acc_name;
    }

    public void setAcc_id(long acc_id) {
        this.acc_id = acc_id;
    }

    public void setTrans_id(String trans_id) {
        this.trans_id = trans_id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAcc_name() {
        return acc_name;
    }

    public long getAcc_id() {
        return acc_id;
    }

    public String getTrans_id() {
        return trans_id;
    }

    public String getCode() {
        return code;
    }

    public String getStaff_id() {
        return staff_id;
    }
    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
    
     public static List<BankTransaction> searchByID(long acc_id){
        // Connect to database
         List<BankTransaction> list = null;
        CSDbDelegate db = new CSDbDelegate("cs14sitkmutt.me","3306","CSC105_G3","CSC105_G3","cstermproj");
        System.out.println(db.connect());
        String sql_search  = "SELECT * FROM BANK_TRANSACTION b JOIN BANK_ACCOUNT ba ON ba.acc_id = b.acc_id WHERE ba.acc_id =  ('"+acc_id+"')";
       
        ArrayList<HashMap> data= db.queryRows(sql_search);
        
        BankTransaction ba = null;

        if(data!=null && data.size()>0){
           if(list==null) 
               list = new ArrayList<BankTransaction>();
        for(int i = 0;i<data.size();i++){
            HashMap std = data.get(i);
            ba = new BankTransaction();
             
            ba.setAcc_id(Long.parseLong((String) std.get("acc_id")));
            ba.setCode((String)std.get("code"));
            ba.setTrans_id((String)std.get("trans_id"));
            ba.setStaff_id((String)std.get("staff_id"));
            ba.setAmount(Double.parseDouble((String) std.get("amount")));
            ba.setDate((String)std.get("date"));
            ba.setBalance(Double.parseDouble((String)std.get("balance")));
            
            list.add(ba);
        }
        }
        return list;
    }
    
     
     public static void main(String[]args){

     }
}
