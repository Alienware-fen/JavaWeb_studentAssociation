package cn.edu.lingnan.until;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import cn.edu.lingnan.dao.Academicdao;
import cn.edu.lingnan.dao.Associationdao;
import cn.edu.lingnan.dao.Memberdao;
import cn.edu.lingnan.dto.Academic;
import cn.edu.lingnan.dto.Association;
import cn.edu.lingnan.dto.Member;

public class Menu 
{
	public static void main(String[] args) 
	{
		System.out.println("    *****************************    ");
		System.out.println("    ******欢迎使用高校社团管理系统 ******    ");
		System.out.println("    *****************************    ");
		while(true) 
		{
			System.out.println("请选择：");
			System.out.println("1.成员信息");
			System.out.println("2.社团信息");
			System.out.println("3.学院信息");
			System.out.println("4.退出系统 ");
			System.out.println("请输入你需要查看内容的序号： ");
			
			//********************************* 学 生 信 息 ***************************************
			String s;
			int num,num1;
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			try 
			{
				s = buf.readLine();
				num = Integer.parseInt(s);
				switch (num) {
				case 1:
					System.out.println("①.查找学生信息；");
					System.out.println("②.插入学生信息；");
					System.out.println("③.删除学生信息；");
					System.out.println("④.修改学生信息；");
					System.out.println("请选择：");
					BufferedReader buf1 = new BufferedReader(new InputStreamReader(System.in));
					String s1;
					s1 = buf1.readLine();
					num1 = Integer.parseInt(s1);
					switch (num1) 
					{
					//----------------------------查找学生信息--根据学号和姓名查找---------------------------
						case 1:
								Memberdao m = new Memberdao();
								BufferedReader buf11 = new BufferedReader(new InputStreamReader(System.in));
								System.out.println("请输入学号：");
								String _sno ;
								_sno=buf11.readLine();
								System.out.println("请输入姓名：");
								String _sname;
								_sname=buf11.readLine();
								System.out.println(m.findMemberBysnoAndsname(_sno,_sname));
						break;
				 //-----------------------------------插入学生的信息--------------------------------------
						case 2 :
							BufferedReader buf22 = new BufferedReader(new InputStreamReader(System.in));
							String _sno2,_sname2,_sex,_classes,_speciality,s2;
							int _age;	
								System.out.println("请输入 学号：");
								_sno2=buf22.readLine();
								System.out.println("请输入 姓名：");
								_sname2=buf22.readLine();
								System.out.println("请输入 性别：");
								_sex=buf22.readLine();
								System.out.println("请输入 年龄：");
								s2 = buf22.readLine();
								_age=Integer.parseInt(s2);
								System.out.println("请输入 班级：");
								_classes=buf22.readLine();
								System.out.println("请输入 专业：");
								_speciality=buf22.readLine();
								Member m2 = new Member();
								m2.setSno(_sno2);
								m2.setSname(_sname2);
								m2.setSex(_sex);
								m2.setClasses(_classes);
								m2.setSpecialty(_speciality);
								Memberdao md = new Memberdao();
								md.insertMember(m2);
						break;
				//-------------------------------------根删除学生信息--根据学号删除-----------------------------------------	
						case 3:
							BufferedReader buf33 = new BufferedReader(new InputStreamReader(System.in));
							System.out.println("请输入学号：");
							Memberdao m3 =new Memberdao();
							String _sno3 ;
							_sno3=buf33.readLine();
							m3.delete(_sno3);
						break;
				//---------------------------------------修改学生信息--根据学号修改----------------------------------------	
						case 4:
								BufferedReader buf44 = new BufferedReader(new InputStreamReader(System.in));
								String _sno4 , _speciality4;
								
								System.out.println("请输入学号：");
								_sno4=buf44.readLine();
								System.out.println("请输入专业：");
								_speciality4=buf44.readLine();
								Member m4 = new Member();
								m4.setSno(_sno4);
								m4.setSpecialty(_speciality4);
								Memberdao ma = new Memberdao();
								ma.update(m4);
							break;
						default://switch num1
							break;
					}				
				break;
				
				
				//********************************* 社 团 信 息 ***************************************
				case 2:
					System.out.println("①.查找社团信息；");
					System.out.println("②.插入社团信息；");
					System.out.println("③.删除社团信息；");
					System.out.println("④.修改社团信息；");
					System.out.println("请选择：");
					BufferedReader buf2 = new BufferedReader(new InputStreamReader(System.in));
					String s2;
					s2 = buf2.readLine();
					num1 = Integer.parseInt(s2);
					switch (num1) 
					{
					//----------------------------查找社团信息--根据社员名字和社团指导老师查找---------------------------
						case 1:
								Associationdao ad = new Associationdao();
								BufferedReader buf11 = new BufferedReader(new InputStreamReader(System.in));
								System.out.println("请输入社团名字：");
								String _aname ,_ateacher;
								_aname=buf11.readLine();
								System.out.println("请输入社团指导老师：");
								_ateacher=buf11.readLine();
								System.out.println(ad.findAssociation(_ateacher,_aname));
						break;
				 //-----------------------------------插入社团的信息--------------------------------------
						case 2 :
							BufferedReader buf22 = new BufferedReader(new InputStreamReader(System.in));
							String _ano2,_aname2,_achair2,_ateacher2;
								System.out.println("请输入 社团编号：");
								_ano2=buf22.readLine();
								System.out.println("请输入 社团名字：");
								_aname2=buf22.readLine();
								System.out.println("请输入 社团主席：");
								_achair2=buf22.readLine();
								System.out.println("请输入 社团老师：");
								_ateacher2=buf22.readLine();
								Association as = new Association();
								as.setAno(_ano2);
								as.setAname(_aname2);
								as.setAchair(_achair2);
								as.setAteacher(_ateacher2);
								Associationdao ad2 = new Associationdao();
								ad2.insertAssociation(as);
						break;
				//-------------------------------------删除社团信息--根据学团编号删除-----------------------------------------	
						case 3:
							BufferedReader buf33 = new BufferedReader(new InputStreamReader(System.in));
							System.out.println("请输入学社团编号：");
							Associationdao a3 =new Associationdao();
							String _ano3 ;
							_ano3=buf33.readLine();
							a3.delete(_ano3);
						break;
				//---------------------------------------修改社团信息--根据社团编号修改社团主席----------------------------------------	
						case 4:
								BufferedReader buf44 = new BufferedReader(new InputStreamReader(System.in));
								String _ano4 , _achair4;
								System.out.println("请输入社团编号：");
								_ano4=buf44.readLine();
								System.out.println("请输入社团主席：");
								_achair4=buf44.readLine();
								Association m4 = new Association();
								m4.setAno(_ano4);
								m4.setAchair(_achair4);
								Associationdao ma = new Associationdao();
								ma.update(m4);
							break;
						default://switch num1
							break;
					}				
				break;
				
				//********************************* 学 院 信 息 ***************************************
				case 3:
					System.out.println("①.查找学院信息；");
					System.out.println("②.插入学院信息；");
					System.out.println("③.删除学院信息；");
					System.out.println("④.修改学院信息；");
					System.out.println("请选择：");
					BufferedReader buf3 = new BufferedReader(new InputStreamReader(System.in));
					String s3;
					s3 = buf3.readLine();
					num1 = Integer.parseInt(s3);
					switch (num1) 
					{
					//----------------------------查找学院--根据学号查找---------------------------
						case 1:
								Academicdao ad = new Academicdao();
								BufferedReader buf11 = new BufferedReader(new InputStreamReader(System.in));
								System.out.println("请输入学生学号：");
								String _sno3;
								_sno3=buf11.readLine();
								System.out.println(ad.findacademic(_sno3));
						break;
				 //-----------------------------------插入学院的信息--------------------------------------
						case 2 :
							BufferedReader buf22 = new BufferedReader(new InputStreamReader(System.in));
							String _ano2,_sno2,_profname2,_profpresident2;
								System.out.println("请输入 社团编号：");
								_ano2=buf22.readLine();
								System.out.println("请输入 学生学号：");
								_sno2=buf22.readLine();
								System.out.println("请输入 学院名字：");
								_profname2=buf22.readLine();
								System.out.println("请输入 学院院长：");
								_profpresident2=buf22.readLine();
								Academic as = new Academic();
								as.setAno(_ano2);
								as.setSno(_sno2);
								as.setProfname(_profname2);
								as.setProfpresident(_profpresident2);
								Academicdao ad2 = new Academicdao();
								ad2.insertAcademic(as);
						break;
				//-------------------------------------删除学院信息--根据学号删除-----------------------------------------	
						case 3:
							BufferedReader buf33 = new BufferedReader(new InputStreamReader(System.in));
							System.out.println("请输入学生学号：");
							Academicdao a3 =new Academicdao();
							String _sno33 ;
							_sno33=buf33.readLine();
							a3.delete(_sno33);
						break;
				//---------------------------------------修改学院信息--根据学院名字修改学院院长----------------------------------------	
						case 4:
								BufferedReader buf44 = new BufferedReader(new InputStreamReader(System.in));
								String _profname4 , _profpresident4;
								System.out.println("请输入学院名字：");
								_profname4=buf44.readLine();
								System.out.println("请输入学院院长：");
								_profpresident4=buf44.readLine();
								Academic m4 = new Academic();
								m4.setProfname(_profname4);
								m4.setProfpresident(_profpresident4);
								Academicdao ma = new Academicdao();
								ma.update(m4);
							break;
						default://switch num1
							break;
					}				
				break;
				
				//**********************************退 出 系 统 ***********************************************
				case 4:
					System.out.println("谢谢使用本系统！");
						return ;
				default://switch num
					break;
				}
			}catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
