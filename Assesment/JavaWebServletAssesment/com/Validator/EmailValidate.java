package com.Validator;

import java.io.IOException;
import java.io.PrintWriter;

import com.Dao.Dao;
import com.Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/emailCheck")
public class EmailValidate extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		
		Dao dao = new Dao();
		User u = dao.getUserByEmail(email);
		PrintWriter out = resp.getWriter();
		
		if(u!=null) {
			out.append("");
		}else {
			out.append("Email Already Exist!!");
		}
	}
}
