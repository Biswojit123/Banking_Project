package com34.biswo.text;

import java.io.*;

import com.biswo.beans.HolderAccount;

import com23.biswo.service.AccountService;
import com24.biswo.factoryClass.AccountSeviceFactory;
import com24.biswo.factoryClass.ConnectionFactory;
public class Test {
    public static void main(String [] arsg) {
        System.out.println("************************!Welcome to Our HDFC Bank Web-site!**********************");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             
            while(true) {
                System.out.println("If you are new plz signup the page !");
                System.out.println("1:Signup page-->>   ");
                System.out.println("2:Login page-->>");
                System.out.println("3:Exit from the page-->>");

                String user;
                String pass;
                String resul;
                AccountService accSer = null;

                int choice = Integer.parseInt(br.readLine());
                switch (choice) {
                    case 2:
                        System.out.println("!!!!****Fill the From****!!!!");
                        System.out.println("Enter the Username :->");
                        user = br.readLine();

                        System.out.println("Enter the Password :->");
                        pass = br.readLine();
                        
                        accSer = AccountSeviceFactory.getAccountService();
                        resul = accSer.login(user, pass);
                        
                        if(resul.equalsIgnoreCase("Log in Sucessfully!")) {
                            System.out.println("**********************Login Sucessfull !********************");
                            while(true) {
                                System.out.println("What you want from our web-site ! select from fllowing options:");
                                System.out.println("1.Create a Account                   :");
                                System.out.println("2.Check your Account details         :");
                                System.out.println("3.Deposit amount to your Account    :");
                                System.out.println("4.Withdrawl amount from your Account :");
                                System.out.println("5.Check your Account balance         :");
                                System.out.println("6.Exit from our application          :");
                                System.out.println("===============================================================");
                
                                int option = Integer.parseInt(br.readLine());
                                String holderName = "";
                                int holderAccount ;
                                String gmail ;
                                String accoType ;
                                float balance ;
                                String userName ;
                                String password ;
                                HolderAccount holAcc = null;
                                AccountService accService = null;
                                String result ;
                
                                switch(option) {
                                    case 1:
                                        //Here , We take the input from User
                                        System.out.println("!!!!!Fill the flowing from!!!!!  ");
                                        System.out.println("Enter the Account Holder Name  :");
                                        holderName = br.readLine();
                                        System.out.print("Enter the Account number         :");
                                        holderAccount = Integer.parseInt(br.readLine());
                                        System.out.print("Enter the Gmail                  :");
                                        gmail = br.readLine();
                                        System.out.print("Enter the Accounttype you want   :");
                                        accoType = br.readLine();
                                        System.out.print("Enter the Account balance        :");
                                        balance = Float.parseFloat(br.readLine());
                                        System.out.print("Enter the Your UserName          :");
                                        userName = br.readLine();
                                        System.out.print("Enter the Your password          :");
                                        password = br.readLine();
                
                                        //Here , We set the holder account details
                                        holAcc = new HolderAccount();
                                        holAcc.setHolderName(holderName);
                                        holAcc.setHolderAccount(holderAccount);
                                        holAcc.setGmail(gmail);
                                        holAcc.setAccountType(accoType);
                                        holAcc.setBalance(balance);
                                        holAcc.setUserName(userName);
                                        holAcc.setUserPass(password);
                
                                        //here , We call the method that create Account
                                        accService = AccountSeviceFactory.getAccountService();
                                        result = accService.createAccount(holAcc);
                                        System.out.println("===============================");
                                        System.out.println(result);
                                        System.out.println("===============================");
                                        break;
                                    case 2:
                                        System.out.println("Enter the User Name :");
                                        userName = br.readLine();
                                        System.out.println("Enter the User Password :");
                                        password = br.readLine();
                                        System.out.println("Enter the User Account no :");
                                        holderAccount = Integer.parseInt(br.readLine());
                
                                        accService = AccountSeviceFactory.getAccountService();
                                        holAcc = accService.checkAccountDetails(userName, password, holderAccount);
                
                                        if(holAcc == null) {
                                            System.out.println("********!!!!Login Failure!!!!!********");
                                        }else {
                                            System.out.println("======================================================");
                                            System.out.println("Account HolderName :"+holAcc.getHolderName());
                                            System.out.println("Account Number :"+holAcc.getHolderAccount());
                                            System.out.println("Account Type :"+holAcc.getAccountType());
                                            System.out.println("Account Gmail :"+holAcc.getGmail());
                                            System.out.println("Account Balance :"+holAcc.getBalance());
                                            System.out.println("=======================================================");
                                        }
                                        
                                        break;
                                    case 3:
                                        System.out.println("Enter the User Name :");
                                        userName = br.readLine();
                                        System.out.println("Enter the User Password :");
                                        password = br.readLine();
                                        System.out.println("Enter the User Account no :");
                                        holderAccount = Integer.parseInt(br.readLine());
                                        System.out.println("Enter the Deposite Amount :");
                                        float deptamt = Float.parseFloat(br.readLine());
                
                                        accService = AccountSeviceFactory.getAccountService();
                                        result = accService.deposite(userName, password, holderAccount, deptamt);
                                        
                                        System.out.println("===============================");
                                        System.out.println(result);
                                        System.out.println("===============================");
                                        break;
                                    case 4:
                                        System.out.println("Enter the User Name :");
                                        userName = br.readLine();
                                        System.out.println("Enter the User Password :");
                                        password = br.readLine();
                                        System.out.println("Enter the User Account no :");
                                        holderAccount = Integer.parseInt(br.readLine());
                                        System.out.println("Enter the Withdraw Amount :");
                                        float withdraw = Float.parseFloat(br.readLine());
                
                                        accService = AccountSeviceFactory.getAccountService();
                                        result = accService.withdraw(userName, password, holderAccount, withdraw);
                
                                        System.out.println("==============================================");
                                        System.out.println(result);
                                        System.out.println("===============================================");
                                        break;
                                    case 5:
                                        System.out.println("Enter the User Name :");
                                        userName = br.readLine();
                                        System.out.println("Enter the User Password :");
                                        password = br.readLine();
                                        System.out.println("Enter the User Account no :");
                                        holderAccount = Integer.parseInt(br.readLine());
                
                                        accService = AccountSeviceFactory.getAccountService();
                                        result = accService.checkAccountBalance(userName, password, holderAccount);
                                        System.out.println("===============================");
                                        System.out.println(result);
                                        System.out.println("===============================");
                                        break;
                                    case 6:
                                        System.out.println("****************************!Thanku for visiting our HDFC web-site!********************");
                                        ConnectionFactory.cleanUp();
                                        System.exit(0);
                                        break;
                                    default :
                                        System.out.println("Select from given option[1/2/3/4/5] :");
                                    break;
                                }
                            }
                        }else {
                            System.out.println("*******************!!!"+resul+"!!!******************");
                        }
                        break;
                    case 1:
                        System.out.println("!!!!****Fill the From****!!!!");
                        System.out.println("Enter the Username :->");
                        user = br.readLine();

                        System.out.println("Enter the Password :->");
                        pass = br.readLine();

                        System.out.println("ReEnter the Password :->");
                        String repass = br.readLine();
                        
                        accSer = AccountSeviceFactory.getAccountService();

                        if(pass.equals(repass)) {
                            resul = accSer.signUp(user, repass);
                            if(resul.equalsIgnoreCase("SignUp Sucessfully!")) {
                                System.out.println("*****************!!!"+resul+"!!!****************");
                            }else {
                                System.out.println("****************!!!"+resul+"!!!******************");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("****************************!Thanku for visiting our HDFC web-site!********************");
                        ConnectionFactory.cleanUp();
                        System.exit(0);
                        break;
                    default :
                        System.out.println("Select the valid choice(1/2/3)");         
                }
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
