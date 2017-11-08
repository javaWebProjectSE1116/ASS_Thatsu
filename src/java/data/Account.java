/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.InputStream;

/**
 *
 * @author NamNV
 */
public class Account {
    private String username;
    private String name;
    private String password;
    private String sex;
    private String email;
    private String phoneNumber;
    private String date;
    private String image;
    private String description;

    public Account(String username, String name, String password, String sex, String email, String phoneNumber,String image) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.date=null;
        this.image = image;
        this.description = null;
    }

    public Account(String username, String name, String password, String sex, String email, String phoneNumber, String date, String image, String description) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.image = image;
        this.description = description;
    }
    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return this.email; //To change body of generated methods, choose Tools | Templates.
    }



    
  
    
}
