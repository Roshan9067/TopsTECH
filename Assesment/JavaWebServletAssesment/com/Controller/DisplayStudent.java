package com.Controller;

	import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

	import com.Dao.Dao;
	import com.Model.User;

	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

	@WebServlet("/display")
	public class DisplayStudent  extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//			PrintWriter out = resp.getWriter();			
			User u = new User();
			u.setEmail(req.getParameter("email"));
			u.setPassword(req.getParameter("password"));
		
			
			Dao d = new Dao();
		    User user =  d.UserLogin(u);
			
		    if(user!=null) {
		    	HttpSession session = req.getSession();
		    	session.setAttribute("user", user);
				resp.sendRedirect("LoggedUserDisplay.jsp");	
		    }else {
		    	req.setAttribute("msg", "Invalid Creditional!!");
				req.getRequestDispatcher("login.jsp").forward(req, resp);	
		    }
			
		}

	}



