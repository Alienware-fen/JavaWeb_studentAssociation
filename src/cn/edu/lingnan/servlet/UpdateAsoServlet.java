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

public class UpdateAsoServlet extends HttpServlet {
	protected void doGet (HttpServletRequest req,HttpServletResponse resp)
			  throws ServletException,IOException{
		req.setCharacterEncoding("GB2312");
		String f = req.getParameter("f");//根据客户端传入的参数判断是删除还是修改：f=null->修改；否则为删除
		boolean flag = false;
		Associationdao sd = new Associationdao();
		if(f==null){//更新
		String ano =req.getParameter("ano");
		String aname =new String(req.getParameter("aname").getBytes("ISO-8859-1"),"GB2312");//乱码处理
		String achair =new String(req.getParameter("achair").getBytes("ISO-8859-1"),"GB2312");
		String ateacher =new String(req.getParameter("ateacher").getBytes("ISO-8859-1"),"GB2312");
		Association s = new Association();
		s.setAno(ano);
		s.setAname(aname);
		s.setAchair(achair);
		s.setAteacher(ateacher);
		sd=new Associationdao();
		flag = sd.update(s);
		}else{//删除
			if(f.equals("delall")){//批量删除
				String[] allano = req.getParameterValues("allano");//取出来的数是一个数组，所以取数时用了parameterValues
				String[] temp = allano[0].split(",");//取出来的所有学号全放在0号数组里面并且用逗号分隔开，
				for(String a:temp){                  //所以要将0号数组里面的数分割成一个一个的学号
					sd.delete(a);
				}
				flag = true;
			}else{//删除一条记录
				String ano = req.getParameter("ano");
				flag = sd.delete(ano);
			}
		}
		Vector<Association> v = sd.findAll();
		HttpSession session = req.getSession();
		session.setAttribute("allAso", v);
		if(flag==true){
			resp.sendRedirect(req.getContextPath()+"/admin/allAso.jsp");
		}else{
			resp.sendRedirect(req.getContextPath()+"/error.html");
		}
			} 

}
