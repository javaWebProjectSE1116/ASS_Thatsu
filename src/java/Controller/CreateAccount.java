/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import data.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.CheckAccountModal;

/**
 *
 * @author NamNV
 */
public class CreateAccount extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CheckAccountModal checkAccount = new CheckAccountModal();

        boolean checkUser = true;

        boolean checkPhone;
        String username = request.getParameter("username");
        checkUser = checkAccount.checkUserName(username);
        
        if(checkUser ==false){
            response.sendRedirect("CreateAccount?checkUser=false");
            return;
        }
        
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String name = firstName + " " + lastName;

        String password = request.getParameter("password");
        String sex = request.getParameter("sex");

        String phoneNumberString = request.getParameter("phoneNumber");
        checkPhone = checkPhoneNumber(phoneNumberString);
        if(checkPhone ==false){
            response.sendRedirect("CreateAccount?checkPhone=false");
            return;
        }
        
        
        String email = request.getParameter("email");

        if (checkUser == false || checkPhone == false) {
            request.getSession().setAttribute("checkUser", checkUser);
            response.sendRedirect("SignUp.jsp");
        } else {
            Account account = new Account(username, name, password, sex, email, phoneNumberString);
            checkAccount.adddAccount(account);
            response.sendRedirect("SuccessSignUp.jsp");
        }

    }

    public boolean checkPhoneNumber(String phoneNumberString) {
        try {
            if (10 > phoneNumberString.length() && phoneNumberString.length() > 13) {
                return false;
            }
            int phoneNumber = Integer.parseInt(phoneNumberString);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
