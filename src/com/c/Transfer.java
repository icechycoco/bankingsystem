/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c;

import edu.sit.cs.db.CSDbDelegate;

/**
 *
 * @author icechycoco
 */
public class Transfer implements ServiceBank {

        String type = "transfer";
        String code = "TRC";
        CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");

    @Override
    public void service(long acc_id, int amount) {
        
        double balance;
        String sql_depositvalue;
        
        if(code.equals("TRS"))
        {
            balance = BankAccount.getBalanceNow(acc_id) - amount;
            sql_depositvalue = "UPDATE BANK_ACCOUNT SET balance = (balance - " + amount + ") WHERE acc_id = ('" + acc_id + "')";
        }
        else
        {
            balance = amount+BankAccount.getBalanceNow(acc_id);
            sql_depositvalue  = "UPDATE BANK_ACCOUNT SET balance = (balance + " + amount + ") WHERE acc_id = ('" + acc_id + "')";
        }
        
        db.connect();    
        String sql_transaction = "INSERT INTO `CSC105_G3`.`BANK_TRANSACTION` (`trans_id`, `code`, `staff_id`, `date`, `amount`, `acc_id`, `balance`) VALUES (NULL, '"+code+"', '1234', CURRENT_TIMESTAMP, '"+amount+"', '"+acc_id+"', '"+balance+"');";
                
        db.executeQuery(sql_depositvalue);     
        db.executeQuery(sql_transaction);       
        db.disconnect();
    }

    /**
     * @param code the code to set
     */
    public void setcode(String code) {
        this.code = code;
    }
    
    
}
