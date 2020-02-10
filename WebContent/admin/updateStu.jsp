<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@page import="java.util.*,cn.edu.lingnan.dto.Member" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
        <title>Student Information</title>    
        <!-- ����Ű� -->
        <link href="assets/css/icons.css" rel="stylesheet" />
        <!-- ���λ��-->
        <link href="assets/css/bootstrap.css" rel="stylesheet" />
        <!-- ��Ҫ�Ű� -->
        <link href="assets/css/main.css" rel="stylesheet" />
</head>
<body>
  <div id="header">
            <div class="container-fluid">
                <div class="navbar">
                    <nav class="top-nav" role="navigation">
                        <ul class="nav navbar-nav pull-left">
                            <li id="toggle-sidebar-li">
                                <a href="#" id="toggle-sidebar"><i class="en-arrow-left2"></i></a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav pull-right">
                            <li class="dropdown">
                                <a href="#" data-toggle="dropdown">
                                    <img class="user-avatar" src="assets/img/avatars/59.jpg">�޻�</a>
                                <ul class="dropdown-menu right" role="menu">
                                    <li><a href="loginout"><i class="im-exit"></i> Logout</a></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div> 
            </div>
        </div>
        <div id="sidebar">
            <div class="sidebar-inner">
                <ul id="sideNav" class="nav nav-pills nav-stacked">
                    <li class="top-search">
                        <form>
                            <input type="text" name="search" placeholder="Search ...">
                            <button type="submit"><i class="ec-search s20"></i></button>
                        </form>
                    </li>
                    <li><a href="#"> ������Ϣ<i class="im-table2"></i></a>
                        <ul class="nav sub">
                            <li><a href="tableStu.html"><i class="en-arrow-right7"></i>ѧ����Ϣ</a></li>
                            <li><a href="tableAso.html"><i class="en-arrow-right7"></i>������Ϣ</a></li>
                            <li><a href="tableAca.html"><i class="en-arrow-right7"></i>ѧԺ��Ϣ</a></li>
                        </ul>
                    </li>
                    <li><a><i class="im-images"></i> ���Ż</a></li>
                    <li><a href="#">���Ź���<i class="im-table2"></i></a>
                        <ul class="nav sub">
                        	<li><a href="findAllStu"><i class="en-arrow-right7"></i>ѧ��������</a></li>
                            <li><a href="findAllAso"><i class="en-arrow-right7"></i>���Ż�����</a></li>
                            <li><a href="findAllAca"><i class="en-arrow-right7"></i>ѧԺ������</a></li>
                        </ul>
                    </li>
                    <li><a><i class="st-diamond"></i> ����Э��</a></li>
                </ul>
            </div>
        </div>
        <div id="content">
            <div class="content-wrapper">
                    <div class="col-lg-12 heading">
                        <h1 class="page-header"><i class="im-screen"></i> ѧ�����Ź���ϵͳ</h1>
                    </div>
            </div>
            <!-- Start .content-wrapper -->
            <div class="content-wrapper">
                <div class="row">
                <div class="outlet">
                    <!-- Start .outlet -->
                    <!-- Page start here ( usual with .row ) -->
                    <div class="row">
                        <div class="col-lg-12">
                            <!-- col-lg-12 start here -->
                            <div class="panel panel-default plain toggle panelClose panelRefresh">
                                <!-- Start .panel -->
                                <div class="panel-heading white-bg">
                                <h4 class="panel-title">ѧ��������Ϣ</h4>
                                </div>
                                <div class="panel-body">
                                    <form action="updateStu">
										<table>
										<tr>
											<td>ѧ��</td>
											<td>����</td>
											<td>�Ա�</td>
											<td>�༶</td>
											<td>רҵ</td>
											<td></td>
										</tr>
										<%
											Vector<Member> v = (Vector<Member>)session.getAttribute("allStu");//��ȡѧ����������
											Iterator<Member> it = v.iterator();
											String sno = request.getParameter("sno");//��ȡ����-ѧ��
											Member m = null;//����Member.dto�еķ���һ�λ�ȡ��ֵ
											while(it.hasNext()){
												m = it.next();
												if(m.getSno().equals(sno)){
										%>	
										<tr>
											<td><input type="text" name="sno"  readonly="true" value=<%=m.getSno() %>></td>
											<td><input type="text" name="sname"  value=<%=m.getSname() %>></td>
											<td><input type="text" name="sex"  value=<%=m.getSex() %>></td>
											<td><input type="text" name="classes"  value=<%=m.getClasses() %>></td>
											<td><input type="text" name="specialty"  value=<%=m.getSpecialty() %>></td>
											<td><input type="submit" value="�޸�"></td>
										</tr>
										<%		
											}}
											%>
										</table>
										</form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>   
        <!-- ���������� -->
        <script>
      	  window.jQuery || document.write('<script src="assets/js/libs/jquery-2.1.1.min.js">\x3C/script>')
        </script>
       			 <!-- �����˳��� -->
        <script src="assets/js/bootstrap/bootstrap.js"></script>
       			 <!-- ��������ͷ�Ķ��� -->
        <script src="assets/js/jRespond.min.js"></script>
       			 <!-- �������ͷ��������� -->
        <script src="assets/plugins/core/quicksearch/jquery.quicksearch.js"></script>
        <script src="assets/plugins/misc/highlight/highlight.pack.js"></script>
        <script src="assets/js/jquery.sprFlat.js"></script>
        <script src="assets/js/app.js"></script>
</body>
</html>