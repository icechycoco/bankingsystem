/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c;

import java.util.ArrayList;
import java.util.HashMap;

public class BankAccount extends Account {
    
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
