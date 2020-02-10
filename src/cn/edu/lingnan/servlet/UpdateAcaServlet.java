package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.edu.lingnan.dao.Academicdao;
import cn.edu.lingnan.dto.Academic;

public class UpdateAcaServlet extends HttpServlet {
	protected void doGet (HttpServletRequest req,HttpServletResponse resp)
			  throws ServletException,IOException{
		req.setCharacterEncoding("GB2312");
		String f = req.getParameter("f");//根据客户端传入的参数判断是删除还是修改：f=null->修改；否则为删除
		boolean flag = false;
		Academicdao sd = new Academicdao();
		if(f==null){//更新
		String sno =req.getParameter("sno");
		String ano =req.getParameter("ano");//乱码处理
		String profname =new String(req.getParameter("profname").getBytes("ISO-8859-1"),"GB2312");
		String profpresident =new String(req.getParameter("profpresident").getBytes("ISO-8859-1"),"GB2312");
		Academic s = new Academic();
		s.setSno(ano);
		s.setAno(ano);
		s.setProfname(profname);
		s.setProfpresident(profpresident);
		sd=new Academicdao();
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
		Vector<Academic> v = sd.findAll();
		HttpSession session = req.getSession();
		session.setAttribute("allAca", v);
		if(flag==true){
			resp.sendRedirect(req.getContextPath()+"/admin/allAca.jsp");
		}else{
			resp.sendRedirect(req.getContextPath()+"/error.html");
		}
			} 
}
