package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import cn.edu.lingnan.until.DataAccess;
import cn.edu.lingnan.dto.Academic;

public class Academicdao {
	
	//-----------------------查找社团成员有关学院的信息------------------
	//①根据学号查询该社团成员在那个院系，如果存在，则返回true，否则返回false
		public boolean findacademic(String _sno){
			boolean flag =false;
				Connection conn = null;
				PreparedStatement prep = null;
				ResultSet rs = null;
				try {
					conn = DataAccess.getConnection();
					prep =conn.prepareStatement
							("select * from academic where sno =? ");
					prep.setString(1,_sno);
					rs= prep.executeQuery();
					if(rs.next())
						flag =true;
				}  catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DataAccess.closeConnection(rs,prep,conn);
				}
			return flag;
		}
		
		
		//②查找该学院的全部学生记录，返回一个对象数组
		public Vector<Academic> findAll(){
			Vector<Academic> v =new Vector<Academic>();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				stmt = conn.createStatement();
				String sql ="select * from academic";
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					Academic a =new Academic();
					a.setSno(rs.getString("sno"));
					a.setAno(rs.getString("ano"));
					a.setProfname(rs.getString("profname"));
					a.setProfpresident(rs.getString("profpresident"));
					v.add(a);
				}
			}catch (SQLException e) {
				//e.printStackTrace();
			} finally {
				DataAccess.closeConnection(rs,stmt,conn);
			}	
			return v;
		}
		
		
		
		
		//------------------插入新生学院的信息----------------
				//根据成员表和社团表新插入的学生学号和社团编号，插入该新生的学院信息
					public int insertAcademic(Academic ac) {
						int flag = 0;
						String sno = ac.getSno();
						String ano = ac.getAno();
						String profname = ac.getProfname();
						String profpresident =ac.getProfpresident();
						Connection conn = null;
						PreparedStatement prep = null;
						PreparedStatement prep1 = null;
						PreparedStatement prep2 = null;
						ResultSet rs = null;
						ResultSet rs1 = null;
						ResultSet rs2 = null;
						try {
							conn = DataAccess.getConnection();
							//假设学号不存在，返回2；
							prep1 = conn.prepareStatement
									("select * from member where sno =?");
							prep1.setString(1,sno);
							rs1=prep1.executeQuery();
							while(!rs1.next()) {
								flag = 2;
								return flag;
							}
							//假设社团编号不存在，返回3；
							prep2 = conn.prepareStatement
									("select * from association where ano =?");
							prep2.setString(1,ano);
							rs2=prep2.executeQuery();
							while(!rs2.next()) {
								flag = 3;
								return flag;
							}
							//成员的学号和社团的编号都存在时，插入学院信息操作如下：
							prep =conn.prepareStatement
									("insert into academic values(?,?,?,?)");
							prep.setString(1,sno);
							prep.setString(2,ano);
							prep.setString(3,profname);
							prep.setString(4,profpresident);
							prep.executeUpdate();
						    flag = 1;
					}catch (SQLException e) {
						flag=4;
						e.printStackTrace();
					} finally {
						DataAccess.closeConnection(prep,prep1,prep2,rs,rs1,rs2,conn);
					}
						return flag;
				}
					
					
					
					
					
					
					//------------------更新学院的基本信息----------------
					  //根据学院名字，更新学院的院长，如果更新成功，返回true
					public boolean update(Academic ac){
						boolean flag =false;
						String sno = ac.getSno();
						String ano = ac.getAno();
						String profname = ac.getProfname();
						String profpresident = ac.getProfpresident();
						Connection conn = DataAccess.getConnection();   
						PreparedStatement prep = null;
						ResultSet rs = null;
							try {
								conn = DataAccess.getConnection();
								prep =conn.prepareStatement
										("update academic set profpresident = ? where profname = ?");
								prep.setString(1,profpresident);
								prep.setString(2,profname);
								prep.executeUpdate();
								flag =true;
							}  catch (SQLException e) {
								//e.printStackTrace();
							} finally {
								DataAccess.closeConnection(prep,conn);
							}
						return flag;
					}		
					
					
					//根据学号更新学院信息，如果更新成功，返回true
					public boolean update1(String _sno){
						boolean flag =false;
						Academic ac = new Academic();
						String sno = ac.getSno();
						String ano = ac.getAno();
						String profname = ac.getProfname();
						String profpresident = ac.getProfpresident();
						Connection conn = null;   
						PreparedStatement prep = null;
						ResultSet rs = null;
							try {
								conn = DataAccess.getConnection();
								prep =conn.prepareStatement
										("update academic set profpresident = ? ,profname = ? where sno = ?");
								prep.setString(1,profpresident);
								prep.setString(2,profname);
								prep.setString(3,sno);
								prep.executeUpdate();
								flag =true;
							}  catch (SQLException e) {
								//e.printStackTrace();
							} finally {
								DataAccess.closeConnection(prep,conn);
							}
						return flag;
					}		
					
					
	//------------------------删除学院的信息--------------------
					//根据学号删除学院信息
					public boolean delete(String _sno) {
						boolean flag =false;
						Connection conn = null;
						PreparedStatement prep = null;
						try {
							conn = DataAccess.getConnection();
							conn.setAutoCommit(false);
							prep =conn.prepareStatement
									("delete from academic where sno = ?");
							prep.setString(1,_sno);
							prep.executeUpdate();
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
							try {
								if(prep!=null)
									prep.close();
							}catch (SQLException e) {
								e.printStackTrace();
							}
						}
						return flag;
					}			
}
