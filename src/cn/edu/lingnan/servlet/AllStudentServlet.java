package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.edu.lingnan.dao.Memberdao;
import cn.edu.lingnan.dto.Member;

public class AllStudentServlet extends HttpServlet {
	protected void doGet (HttpServletRequest req,HttpServletResponse resp)
			  throws ServletException,IOException{
		//����DAO���������û���Ϣ
		Memberdao m = new Memberdao();
		Vector<Member> v = m.findAll();
		HttpSession s = req.getSession();
		s.setAttribute("allStu", v);  //���ڴ洢����
		//���ص�student.jspҳ�沢��ʾ���ҵ������û�����Ϣ
		resp.sendRedirect(req.getContextPath()+"/admin/allStu.jsp");
			}

}

