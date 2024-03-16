package com23.biswo.service;

import com.biswo.beans.HolderAccount;

import com12.biswo.dataAccess.HolderData;
import com24.biswo.factoryClass.HolderDataFactory;

public class AcountServiceImp implements AccountService {

    HolderData holdata = null;
    String status ;
    HolderAccount holacc = null;


    @Override
    public String createAccount(HolderAccount holderAcc) {
        holdata = HolderDataFactory.getHolderData();
        status = holdata.createAccount(holderAcc);
        return status;
    }

    @Override
    public String checkAccountBalance(String userName , String passd ,int accountNo) {
        holdata = HolderDataFactory.getHolderData();
        status = holdata.checkAccountBalance(userName, passd, accountNo);
        return status;
    }

    @Override
    public HolderAccount checkAccountDetails(String userName , String passd ,int accountNo) {
        holdata = HolderDataFactory.getHolderData();
        holacc = holdata.checkAccountDetails(userName, passd, accountNo);
        return holacc;
    }

    @Override
    public String deposite(String userName , String passd ,int accountNo,float depamount) {
        holdata = HolderDataFactory.getHolderData();
        status = holdata.deposite(userName, passd, accountNo, depamount);
        return status;
    }

    @Override
    public String withdraw(String userName , String passd ,int accountNo,float Withdwamount) {
        holdata = HolderDataFactory.getHolderData();
        status = holdata.withdraw(userName, passd, accountNo, Withdwamount);
        return status;
    }

    @Override
    public String login(String UserName , String Password) {
        holdata = HolderDataFactory.getHolderData();
        status = holdata.loginPage(UserName, Password);
        return status;
    }

    @Override
    public String signUp(String UserName , String password) {
        holdata = HolderDataFactory.getHolderData();
        status = holdata.signInPage(UserName, password);
        return status;
    }

}
