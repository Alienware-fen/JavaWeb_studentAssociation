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

public class DeleteStuServlet extends HttpServlet {
	protected void doGet (HttpServletRequest req,HttpServletResponse resp)
			  throws ServletException,IOException{
//		//1��ȡ�ͻ��˵Ĳ�����ѧ�ţ�
//		String sno =req.getParameter("sno");
//		//2�������������ҵ���߼�
//		Memberdao sd =new Memberdao();
//		boolean flag = sd.delete(sno);
//		//3��������ɾ���ɹ�������������ѧ����Ϣҳ�棬ɾ��ʧ�ܷ���ʧ��ҳ��
//		Vector<Member> v = sd.findAll();
//		HttpSession session = req.getSession();
//		session.setAttribute("allStu", v);
//		if(flag){
//			resp.sendRedirect(req.getContextPath()+"/admin/allStu.jsp");
//		}else{
//			resp.sendRedirect(req.getContextPath()+"/error.html");
//		}		
			}

}
