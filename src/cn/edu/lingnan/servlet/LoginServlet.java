package cn.edu.lingnan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.edu.lingnan.dao.Memberdao;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
		throws ServletException,IOException{
		//1����ȡ�ͻ����ύ�Ĳ���(����ѧ�ź������½)
		String sno = req.getParameter("sno");
		String password = req.getParameter("password");
		System.out.println("LoginServlet:"+sno+ "   "+password);
		//2������һ�²���������ҵ���߼�
		Memberdao st = new Memberdao();
		int power = st.login(sno,password);
		HttpSession s =req.getSession();
		s.setAttribute("power",power);
		//3�����ݷ��صĽ������
		if(power !=0){
			resp.sendRedirect(req.getContextPath()+"/ok.html");
		}else{
			resp.sendRedirect(req.getContextPath()+"/error.html");
		}
		
	}
}
