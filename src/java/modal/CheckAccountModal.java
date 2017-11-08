/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import Controller.GetImageDefault;
import data.Account;
import database.DbConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
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
    String imagedefault = new GetImageDefault().getImageDefault();

    public CheckAccountModal() {
        loadData();

    }

    public void loadData() {

        try {
            con = DbConnect.getConnection();
            s = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CheckAccountModal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkUserName(String username) {
        try {
            rs = s.executeQuery("select username from Account where username like '" + username + "'");
            if (rs.next()) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckAccountModal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public void listAccount() {
        try {
            rs = s.executeQuery("select * from Account");
            while (rs.next()) {
                String username = rs.getString(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                String sex = rs.getString(4);
                String email = rs.getString(5);
                String phoneNumber = rs.getString(6);
                String image = rs.getString("Image");
                Account account = new Account(username, name, password, sex, email, phoneNumber, image);
                array.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckAccountModal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void adddAccount(Account account) {
        try {
            String url = "INSERT INTO Account (UserName,name,password,sex,email,phone) values (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(url);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getName());
            ps.setString(3, account.getPassword());
            ps.setString(4, account.getSex());
            ps.setString(5, account.getEmail());
            ps.setString(6, account.getPhoneNumber());
            ps.executeUpdate();
            ps.close();
            setImagedefualt(account.getUsername());
        } catch (SQLException ex) {
            Logger.getLogger(CheckAccountModal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setImagedefualt(String userName) {
        try {
            String url = "update Account set Image=(select Image from Account where UserID=3) where UserName='"+userName+"'";
            Statement s = con.createStatement();
            s.executeUpdate(url);
        } catch (SQLException ex) {
            Logger.getLogger(CheckAccountModal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkLogin(String username, String password) {
        try {
            rs = s.executeQuery("select * from Account where username like'" + username + "' and password like '" + password + "'");
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckAccountModal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public data.Account getAccount(String username) {
        data.Account getAcc = null;
        try {
            Statement st = DbConnect.getConnection().createStatement();
            rs = st.executeQuery("select * from Account where UserName = '" + username + "'");
            if (rs.next()) {
                String usernameX = rs.getString("UserName");
                String name = rs.getString("Name");
                String password = rs.getString("PassWord");
                String sex = rs.getString("Sex");
                String email = rs.getString("Email");
                String phoneNumber = String.valueOf(rs.getInt("Phone"));
                String image = rs.getString("Image");
                getAcc = new Account(username, name, password, sex, email, phoneNumber, image);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CheckAccountModal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getAcc;
    }

}
