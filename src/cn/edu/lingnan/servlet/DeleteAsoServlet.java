package cn.edu.lingnan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.edu.lingnan.dao.Associationdao;
import cn.edu.lingnan.dto.Association;

import java.util.*;

public class DeleteAsoServlet extends HttpServlet {
	protected void doGet (HttpServletRequest req,HttpServletResponse resp)
			  throws ServletException,IOException{
//		//1��ȡ�ͻ��˵Ĳ�����ѧ�ţ�
//		String ano =req.getParameter("ano");
//		//2�������������ҵ���߼�
//		Associationdao sd =new Associationdao();
//		boolean flag = sd.delete(ano);
//		//3��������ɾ���ɹ�������������ѧ����Ϣҳ�棬ɾ��ʧ�ܷ���ʧ��ҳ��
//		Vector<Association> v = sd.findAll();
//		HttpSession session = req.getSession();
//		session.setAttribute("allAso", v);
//		if(flag){
//			resp.sendRedirect(req.getContextPath()+"/admin/allAso.jsp");
//		}else{
//			resp.sendRedirect(req.getContextPath()+"/error.html");
//		}		
			}

}
