package com24.biswo.factoryClass;


public class AccountSeviceFactory {

    private static AccountService accountSer = null;

    static {
        accountSer = new AcountServiceImp();
    }

    public static AccountService getAccountService() {
        return accountSer ;
    }
}
