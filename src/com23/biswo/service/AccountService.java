package com23.biswo.service;

import com.biswo.beans.HolderAccount;

public interface AccountService {

    public String createAccount(HolderAccount holderAcc);
    public String checkAccountBalance(String userName , String passd ,int accountNo);
    public HolderAccount checkAccountDetails(String userName , String passd ,int accountNo);
    public String deposite(String userName , String passd ,int accountNo,float depamount);
    public String withdraw(String userName , String passd ,int accountNo,float Withdwamount);
    public String login(String UserName , String Password);
    public String signUp(String UserName , String password);
}
