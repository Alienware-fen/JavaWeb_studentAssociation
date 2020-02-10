package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.edu.lingnan.dao.Associationdao;
import cn.edu.lingnan.dto.Association;

public class AllAssociationServlet extends HttpServlet {
	protected void doGet (HttpServletRequest req,HttpServletResponse resp)
			  throws ServletException,IOException{
		//����DAO���������û���Ϣ
		Associationdao m = new Associationdao();
		Vector<Association> v = m.findAll();
		HttpSession s = req.getSession();
		s.setAttribute("allAso", v);  //ǰ����������ȡ��������һ������
		//���ص�Association.jspҳ�沢��ʾ���ҵ������û�����Ϣ
		resp.sendRedirect(req.getContextPath()+"/admin/allAso.jsp");
			}

}
