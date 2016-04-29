package com.c;

/**
 *
 * @author  icechycoco
 */
public class Deposit extends ServiceBank {
    
    public Deposit()
    {
        type = "deposite";
    }
    
    @Override
    public void service(long acc_id, int amount) {
        
        double balance = amount+getBalanceNow(acc_id);
        db.connect();
        
        String code = "DPS";
        
        
        String sql_depositvalue = "UPDATE BANK_ACCOUNT SET balance = (balance + " + amount + ") WHERE acc_id = ('" + acc_id + "')";
        
        String sql_transaction = "INSERT INTO `CSC105_G3`.`BANK_TRANSACTION` (`trans_id`, `code`, `staff_id`, `date`, `amount`, `acc_id`, `balance`) VALUES (NULL, '"+code+"', '1234', CURRENT_TIMESTAMP, '"+amount+"', '"+acc_id+"', '"+balance+"');";
                
        db.executeQuery(sql_depositvalue);     
        db.executeQuery(sql_transaction);       
        db.disconnect();
    }
    
}
