/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.InputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class GetImageDefault {
  
    private String imageDefault;

    public String getImageDefault() {
       Connection con = database.DbConnect.getConnection();
       String x = null;
         try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select image from Account where UserID="+3);
            String imgLen = "";
            if (rs.next()) {
                imgLen = rs.getString(1);
                System.out.println(imgLen);
                return imgLen;
            }
        } catch (SQLException ex) {
            Logger.getLogger(getImage.class.getName()).log(Level.SEVERE, null, ex);
        }
       return x;
    }

    public void setImageDefault(String imageDefault) {
        this.imageDefault = imageDefault;
    } 
    public static void main(String[] args) {
        String imageDefault1 = new GetImageDefault().imageDefault;
        System.out.println(imageDefault1);
    }
    
    
}
