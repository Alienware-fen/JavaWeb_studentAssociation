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
	
	//-----------------------����������ص���Ϣ------------------
		//�ٸ������ŵ����ָ����Ÿ�����ʦ��ѯ���������Ϣ����������Ŵ��ڣ��򷵻�true�����򷵻�false
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
			//�ڲ��Ҹ����ŵ�ȫ����¼������һ����������
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
				
	//------------------------�����������ŵ���Ϣ---------------------
			      //�������ű�ţ��������֣�������ϯ������ָ����ʦ
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
					
					//------------------�������ŵĻ�����Ϣ----------------
					  //����ÿ��Ҫ�������죬���Ը������ŵı�Ÿ���������ϯ��������³ɹ�������true
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

					//-----------------------ɾ�����ŵĻ�����Ϣ-------------------
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
							//�����ȸ������ű��ɾ��Ժϵ��������ŵ���Ϣ
							prep1 =conn.prepareStatement
									("delete from academic where ano = ?");
							prep1.setString(1,_ano);
							prep1.executeUpdate();
							//����θ������ű��ɾ�����ű�������ŵĻ�����Ϣ
							prep =conn.prepareStatement
									("delete from association where ano = ?");
							prep.setString(1,_ano);
							prep.executeUpdate();
							//�����ɾ����ѧ���Ļ�����Ϣ
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
