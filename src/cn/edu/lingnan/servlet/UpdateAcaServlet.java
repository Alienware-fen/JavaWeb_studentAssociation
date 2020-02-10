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
		String f = req.getParameter("f");//���ݿͻ��˴���Ĳ����ж���ɾ�������޸ģ�f=null->�޸ģ�����Ϊɾ��
		boolean flag = false;
		Academicdao sd = new Academicdao();
		if(f==null){//����
		String sno =req.getParameter("sno");
		String ano =req.getParameter("ano");//���봦��
		String profname =new String(req.getParameter("profname").getBytes("ISO-8859-1"),"GB2312");
		String profpresident =new String(req.getParameter("profpresident").getBytes("ISO-8859-1"),"GB2312");
		Academic s = new Academic();
		s.setSno(ano);
		s.setAno(ano);
		s.setProfname(profname);
		s.setProfpresident(profpresident);
		sd=new Academicdao();
		flag = sd.update(s);
		}else{//ɾ��
			if(f.equals("delall")){//����ɾ��
				String[] allsno = req.getParameterValues("allsno");//ȡ����������һ�����飬����ȡ��ʱ����parameterValues
				String[] temp = allsno[0].split(",");//ȡ����������ѧ��ȫ����0���������沢���ö��ŷָ�����
				for(String a:temp){                  //����Ҫ��0��������������ָ��һ��һ����ѧ��
					sd.delete(a);
				}
				flag = true;
			}else{//ɾ��һ����¼
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
