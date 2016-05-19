
/*
package com.v;
import com.c.BankTransaction;
import edu.sit.cs.db.CSDbDelegate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        
        CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
        System.out.println(db.connect());
        String sql_search  = "SELECT * FROM BANK_TRANSACTION b JOIN BANK_ACCOUNT ba ON ba.acc_id = b.acc_id "
                             + "WHERE ba.acc_id =  ('1430622565586')";
       
        ArrayList<HashMap> data= db.queryRows(sql_search);
        
        for(int i = 0 ; i<data.size() ; i++){
            HashMap map = data.get(i);
            System.out.println(map.get("amount"));
        }
        List<BankTransaction> list = BankTransaction.searchByID(1430622565586l);
        
        for(BankTransaction b : list){
            System.out.print(b.getDate().toString()+" : ");
            System.out.print(b.getAmount()+" : ");
            System.out.print(b.getTrans_id());
            System.out.println("------");
        }
        
    }
    
    
}
*/