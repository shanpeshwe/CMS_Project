/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cablecms.dao;

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author COM
 */
@WebServlet(name = "AddAdminDao", urlPatterns = {"/AddAdminDao"})
public class AddAdminDao extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            Statement stmt = null;
            String res1 = null;

            HttpSession session = request.getSession();
            AdminLoginDto admin = (AdminLoginDto) session.getAttribute("adminlogindetail");

            try {
                Connection con = DbConnect.getConnection();
                String qr = "insert into admin (companyname,username,emailaddress,contactnumber,password) values ('" + admin.getCompanyname() + "','" + admin.getUsername() + "','" + admin.getEmail() + "','" + admin.getContactnumber() + "','" + admin.getPassword() + "')";
                stmt = con.createStatement();
                stmt.executeUpdate(qr);
                res1 = "record inserted successfully";
            } catch (Exception e) {
                System.out.println(e);
            }

            out.print("Admin Registered Successfully!!");
            RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
            rd.include(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
