package com12.biswo.dataAccess;

import com.biswo.beans.HolderAccount;

public interface HolderData {

    public String createAccount(HolderAccount holderAcc);
    public String checkAccountBalance(String userName , String passd ,int accountNo);
    public HolderAccount checkAccountDetails(String userName , String passd ,int accountNo);
    public String deposite(String userName , String passd ,int accountNo,float depamount);
    public String withdraw(String userName , String passd ,int accountNo,float Withdwamount);
    
}
