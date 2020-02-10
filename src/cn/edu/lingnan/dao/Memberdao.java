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
	//-----------------------查找社团成员的信息------------------
	//②根据学生的学号和密码查找学生,返回0表示用户的初始值没有找到，如果找到则返回相应的权限
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
	
	//①根据学号跟姓名查找社团成员是否存在，存在返回true，否则返回false
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
	
	//③查找社团全部成员的记录，返回一个对象数组
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
		
		
		
		
		
	//----------------------插入新生基本信息------------------
		  //插入新生的学号，姓名，性别，年龄，班级，专业
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
		
		
		
		
		
		
		//------------------更新学生的基本信息----------------
		  //有同学可能会转专业，所以根据学生的学号更新专业，如果更新成功，返回true
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
		
		//------------------删除学生的基本信息----------------
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
					//判断这个社团是不是只有一位学生选，如果是，则删除该学生选择的社团
					prep3 =conn.prepareStatement
						("select count(*) as num  from academic where ano = ?");
					prep3.setString(1,rs.getString("ano"));
					rs3 = prep3.executeQuery();
					rs3.next();
					if (Integer.parseInt(rs3.getString("num")) == 1) {
						v.add(rs.getString("ano"));//Vector里面是要删除的社团编号
					}
				}
				conn.setAutoCommit(false);
				//①首先根据学号删除院系表里该生的院系
				prep1 =conn.prepareStatement
						("delete from academic where sno = ?");
				prep1.setString(1,_sno);
				prep1.executeUpdate();
				//②其次根据学号删除成员表里该生的基本信息
				prep =conn.prepareStatement
						("delete from member where sno = ?");
				prep.setString(1,_sno);
				prep.executeUpdate();
				//③最后删除该学生的社团信息
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


