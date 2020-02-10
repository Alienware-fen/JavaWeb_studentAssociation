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
		System.out.println("    ******��ӭʹ�ø�У���Ź���ϵͳ ******    ");
		System.out.println("    *****************************    ");
		while(true) 
		{
			System.out.println("��ѡ��");
			System.out.println("1.��Ա��Ϣ");
			System.out.println("2.������Ϣ");
			System.out.println("3.ѧԺ��Ϣ");
			System.out.println("4.�˳�ϵͳ ");
			System.out.println("����������Ҫ�鿴���ݵ���ţ� ");
			
			//********************************* ѧ �� �� Ϣ ***************************************
			String s;
			int num,num1;
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			try 
			{
				s = buf.readLine();
				num = Integer.parseInt(s);
				switch (num) {
				case 1:
					System.out.println("��.����ѧ����Ϣ��");
					System.out.println("��.����ѧ����Ϣ��");
					System.out.println("��.ɾ��ѧ����Ϣ��");
					System.out.println("��.�޸�ѧ����Ϣ��");
					System.out.println("��ѡ��");
					BufferedReader buf1 = new BufferedReader(new InputStreamReader(System.in));
					String s1;
					s1 = buf1.readLine();
					num1 = Integer.parseInt(s1);
					switch (num1) 
					{
					//----------------------------����ѧ����Ϣ--����ѧ�ź���������---------------------------
						case 1:
								Memberdao m = new Memberdao();
								BufferedReader buf11 = new BufferedReader(new InputStreamReader(System.in));
								System.out.println("������ѧ�ţ�");
								String _sno ;
								_sno=buf11.readLine();
								System.out.println("������������");
								String _sname;
								_sname=buf11.readLine();
								System.out.println(m.findMemberBysnoAndsname(_sno,_sname));
						break;
				 //-----------------------------------����ѧ������Ϣ--------------------------------------
						case 2 :
							BufferedReader buf22 = new BufferedReader(new InputStreamReader(System.in));
							String _sno2,_sname2,_sex,_classes,_speciality,s2;
							int _age;	
								System.out.println("������ ѧ�ţ�");
								_sno2=buf22.readLine();
								System.out.println("������ ������");
								_sname2=buf22.readLine();
								System.out.println("������ �Ա�");
								_sex=buf22.readLine();
								System.out.println("������ ���䣺");
								s2 = buf22.readLine();
								_age=Integer.parseInt(s2);
								System.out.println("������ �༶��");
								_classes=buf22.readLine();
								System.out.println("������ רҵ��");
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
				//-------------------------------------��ɾ��ѧ����Ϣ--����ѧ��ɾ��-----------------------------------------	
						case 3:
							BufferedReader buf33 = new BufferedReader(new InputStreamReader(System.in));
							System.out.println("������ѧ�ţ�");
							Memberdao m3 =new Memberdao();
							String _sno3 ;
							_sno3=buf33.readLine();
							m3.delete(_sno3);
						break;
				//---------------------------------------�޸�ѧ����Ϣ--����ѧ���޸�----------------------------------------	
						case 4:
								BufferedReader buf44 = new BufferedReader(new InputStreamReader(System.in));
								String _sno4 , _speciality4;
								
								System.out.println("������ѧ�ţ�");
								_sno4=buf44.readLine();
								System.out.println("������רҵ��");
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
				
				
				//********************************* �� �� �� Ϣ ***************************************
				case 2:
					System.out.println("��.����������Ϣ��");
					System.out.println("��.����������Ϣ��");
					System.out.println("��.ɾ��������Ϣ��");
					System.out.println("��.�޸�������Ϣ��");
					System.out.println("��ѡ��");
					BufferedReader buf2 = new BufferedReader(new InputStreamReader(System.in));
					String s2;
					s2 = buf2.readLine();
					num1 = Integer.parseInt(s2);
					switch (num1) 
					{
					//----------------------------����������Ϣ--������Ա���ֺ�����ָ����ʦ����---------------------------
						case 1:
								Associationdao ad = new Associationdao();
								BufferedReader buf11 = new BufferedReader(new InputStreamReader(System.in));
								System.out.println("�������������֣�");
								String _aname ,_ateacher;
								_aname=buf11.readLine();
								System.out.println("����������ָ����ʦ��");
								_ateacher=buf11.readLine();
								System.out.println(ad.findAssociation(_ateacher,_aname));
						break;
				 //-----------------------------------�������ŵ���Ϣ--------------------------------------
						case 2 :
							BufferedReader buf22 = new BufferedReader(new InputStreamReader(System.in));
							String _ano2,_aname2,_achair2,_ateacher2;
								System.out.println("������ ���ű�ţ�");
								_ano2=buf22.readLine();
								System.out.println("������ �������֣�");
								_aname2=buf22.readLine();
								System.out.println("������ ������ϯ��");
								_achair2=buf22.readLine();
								System.out.println("������ ������ʦ��");
								_ateacher2=buf22.readLine();
								Association as = new Association();
								as.setAno(_ano2);
								as.setAname(_aname2);
								as.setAchair(_achair2);
								as.setAteacher(_ateacher2);
								Associationdao ad2 = new Associationdao();
								ad2.insertAssociation(as);
						break;
				//-------------------------------------ɾ��������Ϣ--����ѧ�ű��ɾ��-----------------------------------------	
						case 3:
							BufferedReader buf33 = new BufferedReader(new InputStreamReader(System.in));
							System.out.println("������ѧ���ű�ţ�");
							Associationdao a3 =new Associationdao();
							String _ano3 ;
							_ano3=buf33.readLine();
							a3.delete(_ano3);
						break;
				//---------------------------------------�޸�������Ϣ--�������ű���޸�������ϯ----------------------------------------	
						case 4:
								BufferedReader buf44 = new BufferedReader(new InputStreamReader(System.in));
								String _ano4 , _achair4;
								System.out.println("���������ű�ţ�");
								_ano4=buf44.readLine();
								System.out.println("������������ϯ��");
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
				
				//********************************* ѧ Ժ �� Ϣ ***************************************
				case 3:
					System.out.println("��.����ѧԺ��Ϣ��");
					System.out.println("��.����ѧԺ��Ϣ��");
					System.out.println("��.ɾ��ѧԺ��Ϣ��");
					System.out.println("��.�޸�ѧԺ��Ϣ��");
					System.out.println("��ѡ��");
					BufferedReader buf3 = new BufferedReader(new InputStreamReader(System.in));
					String s3;
					s3 = buf3.readLine();
					num1 = Integer.parseInt(s3);
					switch (num1) 
					{
					//----------------------------����ѧԺ--����ѧ�Ų���---------------------------
						case 1:
								Academicdao ad = new Academicdao();
								BufferedReader buf11 = new BufferedReader(new InputStreamReader(System.in));
								System.out.println("������ѧ��ѧ�ţ�");
								String _sno3;
								_sno3=buf11.readLine();
								System.out.println(ad.findacademic(_sno3));
						break;
				 //-----------------------------------����ѧԺ����Ϣ--------------------------------------
						case 2 :
							BufferedReader buf22 = new BufferedReader(new InputStreamReader(System.in));
							String _ano2,_sno2,_profname2,_profpresident2;
								System.out.println("������ ���ű�ţ�");
								_ano2=buf22.readLine();
								System.out.println("������ ѧ��ѧ�ţ�");
								_sno2=buf22.readLine();
								System.out.println("������ ѧԺ���֣�");
								_profname2=buf22.readLine();
								System.out.println("������ ѧԺԺ����");
								_profpresident2=buf22.readLine();
								Academic as = new Academic();
								as.setAno(_ano2);
								as.setSno(_sno2);
								as.setProfname(_profname2);
								as.setProfpresident(_profpresident2);
								Academicdao ad2 = new Academicdao();
								ad2.insertAcademic(as);
						break;
				//-------------------------------------ɾ��ѧԺ��Ϣ--����ѧ��ɾ��-----------------------------------------	
						case 3:
							BufferedReader buf33 = new BufferedReader(new InputStreamReader(System.in));
							System.out.println("������ѧ��ѧ�ţ�");
							Academicdao a3 =new Academicdao();
							String _sno33 ;
							_sno33=buf33.readLine();
							a3.delete(_sno33);
						break;
				//---------------------------------------�޸�ѧԺ��Ϣ--����ѧԺ�����޸�ѧԺԺ��----------------------------------------	
						case 4:
								BufferedReader buf44 = new BufferedReader(new InputStreamReader(System.in));
								String _profname4 , _profpresident4;
								System.out.println("������ѧԺ���֣�");
								_profname4=buf44.readLine();
								System.out.println("������ѧԺԺ����");
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
				
				//**********************************�� �� ϵ ͳ ***********************************************
				case 4:
					System.out.println("ллʹ�ñ�ϵͳ��");
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
