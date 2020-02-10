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
		//调用DAO查找所有用户信息
		Associationdao m = new Associationdao();
		Vector<Association> v = m.findAll();
		HttpSession s = req.getSession();
		s.setAttribute("allAso", v);  //前面的名字随便取，后面是一个对象
		//返回到Association.jsp页面并显示查找到所有用户的信息
		resp.sendRedirect(req.getContextPath()+"/admin/allAso.jsp");
			}

}
