package com.Controller;

import java.io.IOException;

import com.Dao.Dao;
import com.Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class AddStudentController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User u = new User();
		
		u.setFname(req.getParameter("fname"));
		u.setLname(req.getParameter("lname"));
		u.setEmail(req.getParameter("email"));
		u.setMobile(req.getParameter("mobile"));
		u.setAddress(req.getParameter("address"));
		u.setGender(req.getParameter("gender"));
		u.setPassword(req.getParameter("password"));
		
		Dao d = new Dao();
		int i = d.addStudent(u);
		
		if(i > 0) {
			req.setAttribute("msg", "Registration Successfull.....");
			req.getRequestDispatcher("reg.jsp").forward(req, resp);
		}
	}

}
