package cn.edu.lingnan.servlet;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginOutServlet extends HttpServlet {
	protected void doGet (HttpServletRequest req,HttpServletResponse resp)
			  throws ServletException,IOException{
				HttpSession s = req.getSession();
				s.invalidate();
				resp.sendRedirect(req.getContextPath()+"/login.html");
			}
			
			protected void doPost (HttpServletRequest req,HttpServletResponse resp)
					  throws ServletException,IOException{
				doGet(req,resp);
						
					}

}
