package com23.biswo.service;

import com.biswo.beans.HolderAccount;

import com12.biswo.dataAccess.HolderData;

public class AcountServiceImp implements AccountService {

    HolderData holdata = null;
    String status ;

    @Override
    public String createAccount(HolderAccount holderAcc) {
        holdata = 
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
        return null;
    }

    @Override
    public HolderAccount deposite(String userName , String passd ,int accountNo,float depamount) {
        return null;
    }

    @Override
    public HolderAccount withdraw(String userName , String passd ,int accountNo,float Withdwamount) {
        return null;
    }

}
