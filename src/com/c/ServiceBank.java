package com.c;

import edu.sit.cs.db.CSDbDelegate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author icechy
 */
public abstract class ServiceBank implements Cloneable {

    private String id;
    protected String type;
    static CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");

    public  abstract void service(long acc_id, int amount);

    
    public static double getBalanceNow(long acc_id)
    {
            db.connect();
            double balance = 0;
            String sql = "SELECT balance FROM BANK_ACCOUNT WHERE acc_id = ('" + acc_id + "')";

             ArrayList<HashMap> data = db.queryRows(sql);

            if (data != null && data.size() > 0)
            {
                for (int i = 0; i < data.size(); i++) 
                {
                    HashMap std = data.get(i);
                    balance = Double.parseDouble((String) std.get("balance"));
                 }
            }
            db.disconnect();
            return balance;
     }
    
     public  BankAccount search(long acc_id) {
        db.connect();
        
        String sql_search = "SELECT * FROM BANK_ACCOUNT WHERE acc_id = ('" + acc_id + "')";

        ArrayList<HashMap> data = db.queryRows(sql_search);
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
                ba.setCareer((String) std.get("career"));
                ba.setAge(Integer.parseInt((String) std.get("age")));
                ba.setBirthdate((String) std.get("birthdate"));
                ba.setEmail((String) std.get("email"));
                ba.setGender((String) std.get("gender"));
                ba.setPhone_num((String) std.get("phone_num"));
                ba.setRevenue_month((String) std.get("revenue_month"));

            }
        }
        return ba;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
      Object clone = null;
      
      try {
         clone = super.clone();
         
      } catch (CloneNotSupportedException e) {
         e.printStackTrace();
      }
      
      return clone;
   }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
       
    public double calculateInterest(long acc_id)
    {
            Interest service = new Interest();
            BankAccount user = service.search(acc_id);
            return user.getBalance()*0.1/100;
    }
    
    public double balanceUpdateInterest(double interest)
    {
           double balance = (interest/0.1)*100;
            
            balance = balance + interest;
            
            return balance;
    }
}
