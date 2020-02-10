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
	
	//-----------------------�������ų�Ա�й�ѧԺ����Ϣ------------------
	//�ٸ���ѧ�Ų�ѯ�����ų�Ա���Ǹ�Ժϵ��������ڣ��򷵻�true�����򷵻�false
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
		
		
		//�ڲ��Ҹ�ѧԺ��ȫ��ѧ����¼������һ����������
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
		
		
		
		
		//------------------��������ѧԺ����Ϣ----------------
				//���ݳ�Ա������ű��²����ѧ��ѧ�ź����ű�ţ������������ѧԺ��Ϣ
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
							//����ѧ�Ų����ڣ�����2��
							prep1 = conn.prepareStatement
									("select * from member where sno =?");
							prep1.setString(1,sno);
							rs1=prep1.executeQuery();
							while(!rs1.next()) {
								flag = 2;
								return flag;
							}
							//�������ű�Ų����ڣ�����3��
							prep2 = conn.prepareStatement
									("select * from association where ano =?");
							prep2.setString(1,ano);
							rs2=prep2.executeQuery();
							while(!rs2.next()) {
								flag = 3;
								return flag;
							}
							//��Ա��ѧ�ź����ŵı�Ŷ�����ʱ������ѧԺ��Ϣ�������£�
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
					
					
					
					
					
					
					//------------------����ѧԺ�Ļ�����Ϣ----------------
					  //����ѧԺ���֣�����ѧԺ��Ժ����������³ɹ�������true
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
					
					
					//����ѧ�Ÿ���ѧԺ��Ϣ��������³ɹ�������true
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
					
					
	//------------------------ɾ��ѧԺ����Ϣ--------------------
					//����ѧ��ɾ��ѧԺ��Ϣ
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
