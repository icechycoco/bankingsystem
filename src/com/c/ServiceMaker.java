/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c;

/**
 *
 * @author icechycoco
 */
public class ServiceMaker {
    private final ServiceBank deposite;
    private final ServiceBank withdraw;
    private final ServiceBank interest;
    private final ServiceBank transfer;
    
    public ServiceMaker()
    {
        deposite = new Deposit();
        withdraw = new Withdraw();
        interest = new Interest();
        transfer = new Transfer();
    }
    
    public void serviceDeposite(long acc_id, int amount)
    {
        deposite.service(acc_id,amount);
    }
    
    public void serviceWithdraw(long acc_id, int amount)
    {
        withdraw.service(acc_id,amount);
    }
    
    public void serviceTransferNoAcc(long acc_id, int amount)
    {
        transfer.setcode("TRC");
        transfer.service(acc_id,amount);
    }
    
    public void serviceTransferAccSend(long acc_id, int amount)
    {
        transfer.setcode("TRS");
        transfer.service(acc_id,amount);
    }
    
    public void serviceTransferAccRecive(long acc_id, int amount)
    {
        transfer.setcode("TRR");
        transfer.service(acc_id,amount);
    }
    public void serviceInterest(long acc_id, int amount)
    {
        interest.service(acc_id,amount);
    }
}
