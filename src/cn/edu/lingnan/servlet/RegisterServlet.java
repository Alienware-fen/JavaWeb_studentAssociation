package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.Memberdao;
import cn.edu.lingnan.dto.Member;

public class RegisterServlet extends HttpServlet {
	protected void doGet (HttpServletRequest req,HttpServletResponse resp)
			  throws ServletException,IOException{
		
		//1.��ȡ�ͻ����ṩ�Ĳ���
				req.setCharacterEncoding("GB2312");
				String sno = req.getParameter("sno");
				String sname =new String(req.getParameter("sname").getBytes("ISO-8859-1"),"GB2312");
				String sex  =new String (req.getParameter("sex").getBytes("ISO-8859-1"),"GB2312");
				String classes =new String(req.getParameter("classes").getBytes("ISO-8859-1"),"GB2312");
				String specialty =new String(req.getParameter("specialty").getBytes("ISO-8859-1"),"GB2312");
				String password = req.getParameter("password1");
				String power =req.getParameter("power");
				//2������Ӧ��ҵ���߼�
				Member s = new Member();
				s.setSno(sno);
				s.setSname(sname);
				s.setSex(sex);
				s.setClasses(classes);
				s.setSpecialty(specialty);
				s.setPassword(password);
				s.setPower(Integer.parseInt(power));
				Memberdao sd =new Memberdao();
				int flag = sd.insertMember(s);
				//3 �Խ���Ĵ������flag��Ϊ�տ�ֱ�ӵ�¼��������Ҫע�᣻
				if(flag == 1)
					resp.sendRedirect(req.getContextPath()+"/login.html");
			else
					resp.sendRedirect(req.getContextPath()+"/register.html");
	}
}
