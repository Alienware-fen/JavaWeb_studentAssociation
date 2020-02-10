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
//		//1获取客户端的参数（学号）
//		String sno =req.getParameter("sno");
//		//2处理参数，调用业务逻辑
//		Memberdao sd =new Memberdao();
//		boolean flag = sd.delete(sno);
//		//3处理结果：删除成功返回所有所有学生信息页面，删除失败返回失败页面
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
