package cn.edu.lingnan.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DataAccess {
	//�����������
	private static String driver = null; 
	private static String url = null; 
	private static String user = null; 
	private static String password = null; 
	private static String xmlPath = "database.conf.xml" ; 
	private static String xsdPath = "database.conf.xsd" ; 
		
	public static Connection getConnection() {
		Connection conn =null;
		if (XmlValidator.validate(xmlPath,xsdPath)){
			HashMap<String,String> hm = XmlParser.parser(xmlPath);
			driver = hm.get("driver");
			url = hm.get("url");
			user = hm.get("user");
			password = hm.get("password");
				}
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection
					(url,user, password);
		}catch (ClassNotFoundException e) {
			System.out.println("��������ʧ�ܣ�jar���Ҳ���");
		} catch (SQLException e) {
			System.out.println("�������ݿ����Ӳ����������Ƿ���ȷ");
		}
		return conn;
	}
	
	//������Ĳ���
	public static void closeConnection(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null) 
				rs.close();
			if (stmt != null) 
				stmt.close();
			if (conn != null) 
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
	//������ĸ���
	public static void closeConnection(PreparedStatement prep, Connection conn) {
		try {
			if (prep != null) 
				prep.close();
			if (conn != null) 
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}

	//Ժϵ��Ĳ���
	public static void closeConnection
	( PreparedStatement prep,PreparedStatement prep1,PreparedStatement prep2,
			ResultSet rs,ResultSet rs1,ResultSet rs2,Connection conn) {
		try {
			if (prep != null) 
				prep.close();
			if (prep1 != null) 
				prep1.close();
			if (prep2 != null) 
				prep2.close();
			if (rs != null) 
				rs.close();
			if (rs1 != null) 
				rs1.close();
			if (rs2 != null) 
				rs2.close();
			if (conn != null) 
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
	//�������ɾ��
	public static void closeConnection
	( PreparedStatement prep,PreparedStatement prep1,PreparedStatement prep2,
	  PreparedStatement prep3,PreparedStatement prep4,  Connection conn) {
		try {
			if (prep != null) 
				prep.close();
			if (prep1 != null) 
				prep1.close();
			if (prep2 != null) 
				prep2.close();
			if (prep3 != null) 
				prep3.close();
			if (prep4 != null) 
				prep4.close();
			if (conn != null) 
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

