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

public class UpdateStuServlet extends HttpServlet {
	protected void doGet (HttpServletRequest req,HttpServletResponse resp)
			  throws ServletException,IOException{
		req.setCharacterEncoding("GB2312");
		String f = req.getParameter("f");//根据客户端传入的参数判断是删除还是修改：f=null->修改；否则为删除
		boolean flag = false;
		Memberdao sd = new Memberdao();
		if(f==null){//更新
		String sno =req.getParameter("sno");
		String sname =new String(req.getParameter("sname").getBytes("ISO-8859-1"),"GB2312");//乱码处理
		String sex =new String(req.getParameter("sex").getBytes("ISO-8859-1"),"GB2312");
		String classes =new String(req.getParameter("classes").getBytes("ISO-8859-1"),"GB2312");
		String specialty =new String(req.getParameter("specialty").getBytes("ISO-8859-1"),"GB2312");
		Member s = new Member();
		s.setSno(sno);
		s.setSname(sname);
		s.setSex(sex);
		s.setClasses(classes);
		s.setSpecialty(specialty);
		sd=new Memberdao();
		flag = sd.update(s);
		}else{//删除
			if(f.equals("delall")){//批量删除
				String[] allsno = req.getParameterValues("allsno");//取出来的数是一个数组，所以取数时用了parameterValues
				String[] temp = allsno[0].split(",");//取出来的所有学号全放在0号数组里面并且用逗号分隔开，
				for(String a:temp){                  //所以要将0号数组里面的数分割成一个一个的学号
					sd.delete(a);
				}
				flag = true;
			}else{//删除一条记录
				String sno = req.getParameter("sno");
				flag = sd.delete(sno);
			}
		}
		Vector<Member> v = sd.findAll();//需要重新查找一次学生的记录，才能显示修改或删除后的数据
		HttpSession session = req.getSession();
		session.setAttribute("allStu", v);
		if(flag==true){
			resp.sendRedirect(req.getContextPath()+"/admin/allStu.jsp");
		}else{
			resp.sendRedirect(req.getContextPath()+"/error.html");
		}
			} 

}
