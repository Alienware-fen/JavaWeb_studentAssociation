package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import cn.edu.lingnan.until.DataAccess;
import cn.edu.lingnan.dto.Association;

public class Associationdao {
	
	//-----------------------查找社团相关的信息------------------
		//①根据社团的名字跟社团负责老师查询社团相关信息，如果该社团存在，则返回true，否则返回false
			public boolean findAssociation(String _ateacher,String _aname){
				boolean flag =false;
					Connection conn = null;
					PreparedStatement prep = null;
					ResultSet rs = null;
					try {
						conn = DataAccess.getConnection();
						prep =conn.prepareStatement
								("select * from association where ateacher =? and aname=?");
						prep.setString(1,_ateacher);
						prep.setString(2,_aname);
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
			//②查找该社团的全部记录，返回一个对象数组
			public Vector<Association> findAll(){
				Vector<Association> v =new Vector<Association>();
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				try {
					conn = DataAccess.getConnection();
					stmt = conn.createStatement();
					String sql ="select * from association";
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						Association as =new Association();
						as.setAno(rs.getString("ano"));
						as.setAname(rs.getString("aname"));
						as.setAchair(rs.getString("achair"));
						as.setAteacher(rs.getString("ateacher"));
						v.add(as);
					}
				}catch (SQLException e) {
					//e.printStackTrace();
				} finally {
					DataAccess.closeConnection(rs,stmt,conn);
				}
				return v;
			}
				
	//------------------------插入新生社团的信息---------------------
			      //插入社团编号，社团名字，社团主席，社团指导老师
					public int insertAssociation(Association as) {
						int flag = 0;
						String ano = as.getAno();
						String aname = as.getAname();
						String achair = as.getAchair();
						String ateacher = as.getAteacher();
						Connection conn = null;
						PreparedStatement prep = null;
						try {
							conn = DataAccess.getConnection();
							prep =conn.prepareStatement
									("insert into association values(?,?,?,?)");
							prep.setString(1,ano);
							prep.setString(2,aname);
							prep.setString(3,achair);
							prep.setString(4,ateacher);
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
					
					//------------------更新社团的基本信息----------------
					  //社团每年要经历换届，所以根据社团的编号更新社团主席，如果更新成功，返回true
					public boolean update(Association as){
						boolean flag =false;
						String ano = as.getAno();
						String aname = as.getAname();
						String achair = as.getAchair();
						String ateacher = as.getAteacher();
						Connection conn = DataAccess.getConnection();   
						PreparedStatement prep = null;
						ResultSet rs = null;
						try {
							conn = DataAccess.getConnection();
							prep = conn.prepareStatement
									("update association set achair = ? where ano = ? ");
								prep.setString(1,achair);
								prep.setString(2,ano);
								prep.executeUpdate();
								flag =true;
							}  catch (SQLException e) {
								//e.printStackTrace();
							} finally {
								DataAccess.closeConnection(prep,conn);
							}
						return flag;
					}

					//-----------------------删除社团的基本信息-------------------
					public boolean delete(String _ano) {
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
									("select * from academic where ano = ?");
							prep2.setString(1,_ano);
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
							//①首先根据社团编号删除院系表里该社团的信息
							prep1 =conn.prepareStatement
									("delete from academic where ano = ?");
							prep1.setString(1,_ano);
							prep1.executeUpdate();
							//②其次根据社团编号删除社团表里该社团的基本信息
							prep =conn.prepareStatement
									("delete from association where ano = ?");
							prep.setString(1,_ano);
							prep.executeUpdate();
							//③最后删除该学生的基本信息
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
