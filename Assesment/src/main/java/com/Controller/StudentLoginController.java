package com.Controller;

import java.io.IOException;

import com.Dao.Dao;
import com.Model.User;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class StudentLoginController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User u = new User();
		
		u.setEmail(req.getParameter("email"));
		u.setPassword(req.getParameter("password"));
		
		Dao d = new Dao();
		
		User user = d.UserLogin(u);
		
		
		
		
		
	}
}
