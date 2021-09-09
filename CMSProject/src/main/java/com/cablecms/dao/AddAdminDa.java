/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cablecms.dao;

import com.cablecms.dto.AdminLoginDto;
import com.cablecms.DbConnect;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author COM
 */
public class AddAdminDa {

    public static String AddAdmindao() {
        Statement stmt = null;
        String res1 = null;
        AdminLoginDto admin=new AdminLoginDto();

        try {
            Connection con = DbConnect.getConnection();
            String qr = "insert into admin (companyname,username,emailaddress,contactnumber,password) values ('" + admin.getCompanyname() + "','" + admin.getUsername() + "','" + admin.getEmail() + "','" + admin.getContactnumber() + "','" + admin.getPassword() + "')";
            stmt = con.createStatement();
            stmt.executeUpdate(qr);
            res1 = "record inserted successfully";
        } catch (Exception e) {
            System.out.println(e);
        }
        return res1;
    }

}
