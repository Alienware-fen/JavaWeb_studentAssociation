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
		String f = req.getParameter("f");//���ݿͻ��˴���Ĳ����ж���ɾ�������޸ģ�f=null->�޸ģ�����Ϊɾ��
		boolean flag = false;
		Associationdao sd = new Associationdao();
		if(f==null){//����
		String ano =req.getParameter("ano");
		String aname =new String(req.getParameter("aname").getBytes("ISO-8859-1"),"GB2312");//���봦��
		String achair =new String(req.getParameter("achair").getBytes("ISO-8859-1"),"GB2312");
		String ateacher =new String(req.getParameter("ateacher").getBytes("ISO-8859-1"),"GB2312");
		Association s = new Association();
		s.setAno(ano);
		s.setAname(aname);
		s.setAchair(achair);
		s.setAteacher(ateacher);
		sd=new Associationdao();
		flag = sd.update(s);
		}else{//ɾ��
			if(f.equals("delall")){//����ɾ��
				String[] allano = req.getParameterValues("allano");//ȡ����������һ�����飬����ȡ��ʱ����parameterValues
				String[] temp = allano[0].split(",");//ȡ����������ѧ��ȫ����0���������沢���ö��ŷָ�����
				for(String a:temp){                  //����Ҫ��0��������������ָ��һ��һ����ѧ��
					sd.delete(a);
				}
				flag = true;
			}else{//ɾ��һ����¼
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
