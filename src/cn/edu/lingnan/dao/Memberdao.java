package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import cn.edu.lingnan.until.DataAccess;
import cn.edu.lingnan.dto.Member;

public class Memberdao {
	ResultSet rs = null;
	//-----------------------�������ų�Ա����Ϣ------------------
	//�ڸ���ѧ����ѧ�ź��������ѧ��,����0��ʾ�û��ĳ�ʼֵû���ҵ�������ҵ��򷵻���Ӧ��Ȩ��
		public int login(String _sno,String _password){
			int flag =0;
			Connection conn = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				prep =conn.prepareStatement
						("select * from member where sno =? and password=?");
				prep.setString(1,_sno);
				prep.setString(2,_password);
				rs= prep.executeQuery();
				if(rs.next()){
					flag = rs.getInt("power");
				}
			}  catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataAccess.closeConnection(rs,prep,conn);
			}
		return flag;
	}
	
	//�ٸ���ѧ�Ÿ������������ų�Ա�Ƿ���ڣ����ڷ���true�����򷵻�false
	public boolean findMemberBysnoAndsname(String _sno,String _name){
		boolean flag =false;
			Connection conn = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				prep =conn.prepareStatement
						("select * from member where sno =? and sname=?");
				prep.setString(1,_sno);
				prep.setString(2,_name);
				rs= prep.executeQuery();
				if(rs.next())
					flag =true;
			}  catch (SQLException e) {
				//e.printStackTrace();
			} finally {
				DataAccess.closeConnection(rs,prep,conn);
			}
		return flag;
	}
	
	//�۲�������ȫ����Ա�ļ�¼������һ����������
		public Vector<Member> findAll(){
			Vector<Member> v =new Vector<Member>();
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				stat = conn.createStatement();
				String sql ="select * from member";
				rs = stat.executeQuery(sql);
				while(rs.next()) {
					Member m =new Member();
					m.setSno(rs.getString("Sno"));
					m.setSname(rs.getString("Sname"));
					m.setSex(rs.getString("Sex"));
					m.setClasses(rs.getString("Classes"));
					m.setSpecialty(rs.getString("Specialty"));
					v.add(m);
				}
			}catch (SQLException e) {
//				e.printStackTrace();
			} finally {
				DataAccess.closeConnection(rs,stat,conn);
			}
			return v;
		}
		
		
		
		
		
	//----------------------��������������Ϣ------------------
		  //����������ѧ�ţ��������Ա����䣬�༶��רҵ
		public int insertMember(Member m) {
				int flag = 0;
				String sno = m.getSno();
				String sname = m.getSname();
				String sex = m.getSex();
				String classes =m.getClasses();
				String specialty = m.getSpecialty();
				String password =m.getPassword();
				int power = m.getPower();
				Connection conn = null;
				PreparedStatement prep = null;
				try {
					conn = DataAccess.getConnection();
					prep =conn.prepareStatement
							("insert into member values(?,?,?,?,?,?,?)");
					prep.setString(1,sno);
					prep.setString(2,sname);
					prep.setString(3,sex);
					prep.setString(4,classes);
					prep.setString(5,specialty);
					prep.setString(6,password);
					prep.setInt(7,power);
					prep.executeUpdate();
				    flag = 1;
			}catch (SQLException e) {
				flag=4;
				e.printStackTrace();
			} finally {
				try {
					if(prep!=null)
						prep.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
				return flag;
		}
		
		
		
		
		
		
		//------------------����ѧ���Ļ�����Ϣ----------------
		  //��ͬѧ���ܻ�תרҵ�����Ը���ѧ����ѧ�Ÿ���רҵ��������³ɹ�������true
		public boolean update(Member m){
			boolean flag =false;
			Connection conn = null;   
			PreparedStatement prep = null;
				try {
					conn = DataAccess.getConnection();
					prep =conn.prepareStatement
							("update member set sname = ? ,sex = ?,classes = ? ,specialty = ? where sno = ?");
					prep.setString(1,m.getSname());
					prep.setString(2,m.getSex());
					prep.setString(3,m.getClasses());
					prep.setString(4,m.getSpecialty());
					prep.setString(5,m.getSno());
					prep.executeUpdate();
					flag =true;
				}  catch (SQLException e) {
					//e.printStackTrace();
				} finally {
					DataAccess.closeConnection(prep,conn);
				}
			return flag;
		}
		
		//------------------ɾ��ѧ���Ļ�����Ϣ----------------
		public boolean delete(String _sno) {
			boolean flag =false;
			Connection conn = null;
			PreparedStatement prep = null;
			PreparedStatement prep1 = null;
			PreparedStatement prep2 = null;
			PreparedStatement prep3 = null;
			PreparedStatement prep4 = null;
			ResultSet rs = null;
			ResultSet rs3 = null;
			try {
				conn = DataAccess.getConnection();
				prep2 =conn.prepareStatement
						("select * from academic where sno = ?");
				prep2.setString(1,_sno);
				rs = prep2.executeQuery();
				Vector<String> v = new Vector<String>();
				while(rs.next()) {
					//�ж���������ǲ���ֻ��һλѧ��ѡ������ǣ���ɾ����ѧ��ѡ�������
					prep3 =conn.prepareStatement
						("select count(*) as num  from academic where ano = ?");
					prep3.setString(1,rs.getString("ano"));
					rs3 = prep3.executeQuery();
					rs3.next();
					if (Integer.parseInt(rs3.getString("num")) == 1) {
						v.add(rs.getString("ano"));//Vector������Ҫɾ�������ű��
					}
				}
				conn.setAutoCommit(false);
				//�����ȸ���ѧ��ɾ��Ժϵ���������Ժϵ
				prep1 =conn.prepareStatement
						("delete from academic where sno = ?");
				prep1.setString(1,_sno);
				prep1.executeUpdate();
				//����θ���ѧ��ɾ����Ա��������Ļ�����Ϣ
				prep =conn.prepareStatement
						("delete from member where sno = ?");
				prep.setString(1,_sno);
				prep.executeUpdate();
				//�����ɾ����ѧ����������Ϣ
				for(String a : v) {
				prep4 =conn.prepareStatement
						("delete from association where ano = ?");
				prep4.setString(1,a);
				prep4.executeUpdate();
				}
				conn.commit();
				conn.setAutoCommit(true);
					flag =true;
			}  catch (SQLException e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			} finally {
				DataAccess.closeConnection(prep,prep1,prep2,prep3,prep4,conn);
			}
			return flag;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}


