package com.abc.signup.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chandu
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String n = request.getParameter("Name");
        String e = request.getParameter("Email");
        String p = request.getParameter("Password");
        String nb= request.getParameter("Number");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.4:3306/amiya", "root", "root");
            PreparedStatement stmt = con.prepareStatement("insert into userlogin values(?,?,?,?)");
            stmt.setString(1, n);
            stmt.setString(2, e);
            stmt.setString(3, p);
            stmt.setString(4, nb);
            int i = stmt.executeUpdate();
            if (i > 0) {
                out.println("You are successfully registered.....");
            }
        } catch (Exception ey) {
            System.out.println(ey);
        }
        out.close();
    }
}