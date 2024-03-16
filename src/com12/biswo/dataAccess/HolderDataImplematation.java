package com12.biswo.dataAccess;

import com.biswo.beans.HolderAccount;

import com24.biswo.factoryClass.ConnectionFactory;

import java.sql.*;

public class HolderDataImplematation implements HolderData {
    //Implemented all Interface method
    String status;
    HolderAccount holderAcc = null;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    @Override
    public String createAccount(HolderAccount holderAcco) {

        boolean b = exit_account(holderAcco.getUserName(), holderAcco.getUserPass());
        if(b == true) {
            status = "Account Existed";
            return status;
        }

        b = resistration(holderAcco.getUserName(), holderAcco.getUserPass(), holderAcco.getHolderAccount());

        if(b == true) {
            try {
                status =creation(holderAcco) ;
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    @Override
    public String checkAccountBalance(String userName , String passd ,int accountNo) {
        boolean b = login(userName, passd);
        if(b == true) {
            String query = "select balance from Account where acc_no = ?";
            try {
                con = ConnectionFactory.getConnection();
                pst = con.prepareStatement(query);
                pst.setInt(1, accountNo);
                rs = pst.executeQuery();

                if(rs.next()) {
                    status = "*****!Login Successfully!*****";
                    status = status +"\n Balance is :"+rs.getFloat(1);
                }else {
                    status = "!!!!There is No balance !!!!";
                    return status;
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }else {
            status = "*******!Login denied!******";
            return status;
        }
        return status;
    }

    @Override
    public HolderAccount checkAccountDetails(String userName , String passd ,int accountNo) {
        boolean b = login(userName, passd);
        if(b == true) {
            String query = "select * from Account where acc_no = ?";
            try {
                con = ConnectionFactory.getConnection();
                pst = con.prepareStatement(query);
                pst.setInt(1, accountNo);
                rs = pst.executeQuery();
                holderAcc = new HolderAccount();
                if(rs.next()) {
                    holderAcc.setHolderAccount(rs.getInt(1));
                    holderAcc.setHolderName(rs.getString(2));
                    holderAcc.setAccountType(rs.getString(3));
                    holderAcc.setGmail(rs.getString(4));
                    holderAcc.setBalance(rs.getFloat(5));
                }else {
                    return holderAcc;
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }else {
            return holderAcc;
        }
       return holderAcc;
    }

    @Override
    public String deposite(String userName , String passd ,int accountNo,float depamount) {
        boolean b =exit_account(userName, passd);

        if(b == true) {
            String query = "Update Account set balance = balance + ? where acc_no = ?";
            try {
                con = ConnectionFactory.getConnection();
                pst = con.prepareStatement(query);
                pst.setFloat(1, depamount);
                pst.setInt(2, accountNo);
                int rowCount = pst.executeUpdate();

                if(rowCount > 0) {
                    status = "Amount credited Successfully";
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }else {
            status = "Account is not Existed";
            return status;
        }
        return status;
    }

    @Override
    public String withdraw(String userName , String passd ,int accountNo,float Withdwamount) {
        boolean b =exit_account(userName, passd);

        if(b == true) {
            String query = "Update Account set balance = balance - ? where acc_no = ?";
            try {
                con = ConnectionFactory.getConnection();
                pst = con.prepareStatement(query);
                pst.setFloat(1, Withdwamount);
                pst.setInt(2, accountNo);
                int rowCount = pst.executeUpdate();

                if(rowCount > 0) {
                    status = "Amount Debited Successfully";
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }else {
            status = "Account is not Existed";
            return status;
        }
        return status;
    }

    public boolean exit_account(String userName,String pasWrd) {
        String query = "select * from Authontication where USER_NAME = ? and PASS_WORD = ? ";
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1, userName);
            pst.setString(2, pasWrd);
            rs = pst.executeQuery();

            if(rs.next()) {
                return true;
            }


        }catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public  boolean resistration(String userName,String passwd,int accountNo) {

        String query = "insert into Authontication values(?,?,?)";

        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1, userName);
            pst.setString(2, passwd);
            pst.setInt(3, accountNo);
            int rowCount = pst.executeUpdate();

            if(rowCount > 0) {
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }
    public String creation(HolderAccount holdAcc) {
        String query = "insert into Account values(?,?,?,?,?)";

        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(query);
            pst.setInt(1, holdAcc.getHolderAccount());
            pst.setString(2, holdAcc.getHolderName());
            pst.setString(3, holdAcc.getAccountType());
            pst.setString(4, holdAcc.getGmail());
            pst.setFloat(5, holdAcc.getBalance());

            int rowCount = pst.executeUpdate();
            if(rowCount > 0) {
                status = "Creation Successfully!";
            }else {
                status = "Creation denied";
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean login(String userName,String password) {
        String query = "select * from Authontication where USER_NAME = ? and PASS_WORD = ? ";
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1, userName);
            pst.setString(2, password);
            rs = pst.executeQuery();

            if(rs.next()) {
                return true;
            }


        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String loginPage(String userName,String passWord) {
        String query = "select * from Validtion_tbl where USER_NAME = ? and PASSWORD = ? ";
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1, userName);
            pst.setString(2, passWord);
            rs = pst.executeQuery();
            if(rs.next()) {
                status = "Log in Sucessfully!";
            }else {
                status = "Invalid UserName And Password";
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public String signInPage(String UserName,String passWord) {
        String query = "insert into Validtion_tbl values(?,?)";

        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1, UserName);
            pst.setString(2, passWord);

            int rowCount = pst.executeUpdate();

            if( rowCount > 0 ) {
                status = "SignUp Sucessfully!";
            }else {
                status = "Account Already Exist";
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}