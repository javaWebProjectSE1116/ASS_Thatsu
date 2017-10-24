/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import data.Account;
import database.DbConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NamNV
 */
public class CheckAccountModal {
    
    public ArrayList<Account> array;
    Connection con;
    Statement s;
    ResultSet rs;

    public CheckAccountModal() {
        loadData();
        
    }
    public void loadData(){
        
        try {
            con = DbConnect.getConnection();
            s = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CheckAccountModal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean checkUserName(String username){
        try {
            rs =s.executeQuery("select username from Account where username like '"+username+"'");
            if(rs.next()){
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckAccountModal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public void listAccount(){
        try {
            rs = s.executeQuery("select * from Account");
            while(rs.next()){
                String username = rs.getString(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                String sex = rs.getString(4);
                String email = rs.getString(5);
                String phoneNumber = rs.getString(6);
                Account account = new Account(username, name,password, sex, email, phoneNumber);
                array.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckAccountModal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void adddAccount(Account account){
        try {
            s.executeQuery("insert into Account(username,name,password,sex,email,phone)\n" +
                    "values('"+account.getUsername()+"','"+account.getName()+"','"
                    +account.getPassword()+"','"+account.getSex()+"','"+account.getEmail()+"','"+account.getPhoneNumber()+"')");
        } catch (SQLException ex) {
            Logger.getLogger(CheckAccountModal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean checkLogin(String username,String password){
        try {
            rs =s.executeQuery("select * from Account where username like'"+username+"' and password like '"+password+"'");
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckAccountModal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
