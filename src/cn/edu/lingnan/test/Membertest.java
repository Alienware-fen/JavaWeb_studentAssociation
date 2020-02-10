package cn.edu.lingnan.test;

import java.util.Vector;
import java.util.Vector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import cn.edu.lingnan.until.DataAccess;
import cn.edu.lingnan.dao.Academicdao;
import cn.edu.lingnan.dao.Associationdao;
import cn.edu.lingnan.dao.Memberdao;
import cn.edu.lingnan.dto.Member;

public class Membertest {
	public static void main(String[] args) {
		
		//--------------------查找学生测试--------------------
//		Memberdao m1 =new Memberdao();
//	    System.out.println(m1.findMemberBysnoAndsname("201901","张三"));
//	    Vector<Member> v =new Vector<Member>();
//		v =m1.findAll();
//		System.out.println(v.size());
//		Memberdao m1 =new Memberdao();
//	    System.out.println(m1.login("201901","zhangsan"));
		
		//--------------------插入新生测试--------------------
//		Member m = new Member();
//		m.setSno("2019063");
//		m.setSname("阿斯顿3");
//		m.setSex("男");
//		m.setClasses("3班");
//		m.setSpecialty("教育技术学");
//		m.setPassword("asidun3");
//		m.setPower(2);
//		Memberdao md = new Memberdao();
//		System.out.println(md.insertMember(m));
		
		//--------------------删除学生测试--------------------
//		Memberdao m =new Memberdao();
//		m.delete("201901");
		
		//--------------------更新学生测试--------------------
		Member m = new Member();
		Memberdao asd = new Memberdao();
		m.setSname("嘻嘻");
		m.setSex("男");
		m.setClasses("3班");
		m.setSpecialty("aaaaaaaa");
		m.setPassword("password");
		m.setSno("201902");
	    System.out.println(asd.update(m));
	}
}
