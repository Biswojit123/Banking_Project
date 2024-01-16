package com.biswo.beans;

public class HolderAccount {
    //All are the Holder details
    private String holderName ;
    private int holderAccount ;
    private String gmail;
    private String accoType;
    private float balance ;
    private String userName;
    private String password;

    //Set the Holder name
    public void setHolderName(String holderName) {
        this.holderName = holderName ;
    }
    public String getHolderName() {
        return holderName;
    }

    //Set the Holder Account
    public void setHolderAccount(int holderAccount) {
        this.holderAccount = holderAccount ;
    }
    public int getHolderAccount() {
        return holderAccount ;
    }

    //Set the Gmail
    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    public String getGmail() {
        return gmail ;
    }

    //Set the AccountType
    public void setAccountType(String accoType) {
        this.accoType = accoType ;
    }
    public String getAccountType() {
        return accoType;
    } 

    //Set the User Name
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return userName ;
    }

    //Set the User Password
    public void setUserPass(String password) {
        this.password = password ;
    }
    public String getUserPass() {
        return password ;
    }

    //Set Balance
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public float getBalance() {
        return balance;
    }
}
