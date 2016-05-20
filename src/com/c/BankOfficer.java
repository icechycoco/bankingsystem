/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c;

import edu.sit.cs.db.CSDbDelegate;
import java.util.ArrayList;
import java.util.HashMap;


public class BankOfficer {
    private String username;
    private String password;
    private String emp_name;
    private int emp_id;
    static CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public void setEamp_id(int emp_id) {
        this.emp_id = emp_id;
    }
    
    public static BankOfficer searchEmp(String user, String pass){
        
        ConnectDB c = new ConnectDB();
        c.connect();
        
        String sql_searchEmp  = "SELECT * FROM BANK_OFFICER WHERE USERNAME = ('"+user+"') AND PASSWORD = ('"+pass+"')";
        
        ArrayList<HashMap> data= c.db.queryRows(sql_searchEmp);
        BankOfficer bo = null;

        if(data!=null && data.size()>0){
            bo = new BankOfficer();
        for(int i = 0;i<data.size();i++){
            HashMap std = data.get(i);
            
            bo.setEamp_id(Integer.parseInt((String) std.get("EMP_ID")));
            bo.setEmp_name((String)std.get("EMP_NAME"));
            bo.setUsername((String)std.get("USERNAME"));
            bo.setPassword((String) std.get("PASSWORD"));
        }
        }
        return bo;
    }
    
}
