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
public class ConnectDB {
    public CSDbDelegate db;
            
    public void connect(){
    db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
    System.out.println(db.connect());
    }
    
}
