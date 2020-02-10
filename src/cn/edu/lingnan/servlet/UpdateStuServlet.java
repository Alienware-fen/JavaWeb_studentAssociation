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
		String f = req.getParameter("f");//���ݿͻ��˴���Ĳ����ж���ɾ�������޸ģ�f=null->�޸ģ�����Ϊɾ��
		boolean flag = false;
		Memberdao sd = new Memberdao();
		if(f==null){//����
		String sno =req.getParameter("sno");
		String sname =new String(req.getParameter("sname").getBytes("ISO-8859-1"),"GB2312");//���봦��
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
		Vector<Member> v = sd.findAll();//��Ҫ���²���һ��ѧ���ļ�¼��������ʾ�޸Ļ�ɾ���������
		HttpSession session = req.getSession();
		session.setAttribute("allStu", v);
		if(flag==true){
			resp.sendRedirect(req.getContextPath()+"/admin/allStu.jsp");
		}else{
			resp.sendRedirect(req.getContextPath()+"/error.html");
		}
			} 

}
