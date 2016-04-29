/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c;

/**
 *
 * @author  icechycoco
 */
public class Interest extends ServiceBank{

   public Interest()
    {
        type = "interest";
    }
    
    @Override
    public void service(long acc_id, int amount) {
        
        double balance = amount+getBalanceNow(acc_id);
        db.connect();
        
        String code = "INTS";        
        
        String sql_depositvalue = "UPDATE BANK_ACCOUNT SET balance = (balance + " + amount + ") WHERE acc_id = ('" + acc_id + "')";
        
        String sql_transaction = "INSERT INTO `CSC105_G3`.`BANK_TRANSACTION` (`trans_id`, `code`, `staff_id`, `date`, `amount`, `acc_id`, `balance`) VALUES (NULL, '"+code+"', '1234', CURRENT_TIMESTAMP, '"+amount+"', '"+acc_id+"', '"+balance+"');";
                
        db.executeQuery(sql_depositvalue);     
        db.executeQuery(sql_transaction);       
        db.disconnect();
    }
    
    
}

