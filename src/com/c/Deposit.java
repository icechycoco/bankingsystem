package com.c;

import edu.sit.cs.db.CSDbDelegate;
/**
 *
 * @author  icechycoco
 */
public class Deposit implements ServiceBank {
    
    String type = "deposite";
    String code = "DPS";    
    CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");

        
    
    @Override
    public void service(long acc_id, int amount) {
        
        double balance = amount+BankAccount.getBalanceNow(acc_id);
        db.connect();    
        
        String sql_depositvalue = "UPDATE BANK_ACCOUNT SET balance = (balance + " + amount + ") WHERE acc_id = ('" + acc_id + "')";
        
        String sql_transaction = "INSERT INTO `BANK_TRANSACTION` (`trans_id`, `code`, `staff_id`, `date`, `amount`, `acc_id`, `balance`) VALUES (NULL, '"+code+"', '1234', CURRENT_TIMESTAMP, '"+amount+"', '"+acc_id+"', '"+balance+"');";
                
        db.executeQuery(sql_depositvalue);     
        db.executeQuery(sql_transaction);       
        db.disconnect();
    }
    public void setcode(String code) {
        this.code = code;
    }
}
