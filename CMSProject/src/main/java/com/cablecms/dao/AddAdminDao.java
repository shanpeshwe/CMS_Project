/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cablecms.dao;

import com.cablecms.DbConnect;
import com.cablecms.dto.AdminLoginDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author COM
 */
@WebServlet(name = "AddAdminDao", urlPatterns = {"/AddAdminDao"})
public class AddAdminDao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String companyname, username, email, contactnumber, password;
        try (PrintWriter out = response.getWriter()) {

            Statement stmt = null;
            String res1 = null;

            AdminLoginDto admin = new AdminLoginDto();

            try {
                Connection con = DbConnect.getConnection();
                companyname = admin.getCompanyname();
                username = admin.getUsername();
                email = admin.getEmail();
                contactnumber = admin.getContactnumber();
                password = admin.getPassword();
                String qr = "insert into admin (companyname,username,emailaddress,contactnumber,password) values ('" + companyname + "','" + username + "','" + email + "','" + contactnumber + "','" + password + "')";
                stmt = con.createStatement();
                stmt.executeUpdate(qr);
                res1 = "record inserted successfully";
            } catch (Exception e) {
                System.out.println(e);
            }

            out.print("Admin Registered Successfully!!");
            RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
            rd.include(request, response);

            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet AddAdminDao</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet AddAdminDao at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
