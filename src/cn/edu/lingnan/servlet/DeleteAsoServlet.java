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
//		//1获取客户端的参数（学号）
//		String ano =req.getParameter("ano");
//		//2处理参数，调用业务逻辑
//		Associationdao sd =new Associationdao();
//		boolean flag = sd.delete(ano);
//		//3处理结果：删除成功返回所有所有学生信息页面，删除失败返回失败页面
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
