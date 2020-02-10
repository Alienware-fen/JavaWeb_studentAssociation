<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@page import="java.util.*,cn.edu.lingnan.dto.Association" %> 
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
        <script type="text/javascript" src="allAso.js"></script>
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
                    <li><a href="#"> ���Ź���<i class="im-table2"></i></a>
                        <ul class="nav sub">
                            <li><a href="tableStu.html"><i class="en-arrow-right7"></i>ѧ��������</a></li>
                            <li><a href="tableAso.html"><i class="en-arrow-right7"></i>���Ż�����</a></li>
                            <li><a href="tableAca.html"><i class="en-arrow-right7"></i>ѧԺ������</a></li>
                        </ul>
                    </li>
                    <li><a><i class="im-images"></i> ���Ż</a></li>
                    <li><a href="#">������Ϣ<i class="im-table2"></i></a>
                        <ul class="nav sub">
                        	<li><a href="findAllStu"><i class="en-arrow-right7"></i>ѧ����Ϣ</a></li>
                            <li><a href="findAllAso"><i class="en-arrow-right7"></i>������Ϣ</a></li>
                            <li><a href="findAllAca"><i class="en-arrow-right7"></i>ѧԺ��Ϣ</a></li>
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
                                <h4 class="panel-title">���Ż�����Ϣ</h4>
                                </div>
                                <div class="panel-body">
                                    <table class="table">
                                        <thead>
                                            <tr onmouseover="this.style.backgroundColor='#F0F8FF';" onmouseout="this.style.backgroundColor='#FFFFFF';">
                                                <td><input id="btn1" type ="button" value="ȫѡ" onclick="allcheck();"/></td>
                                                <th class="per15">���ź�</th>
                                                <th class="per15">������</th>
                                                <th class="per15">���Ÿ�����</th>
                                                <th class="per15">����ָ����ʦ</th>
                                                <th><input id="btn2" type ="button" value="����ɾ��" onclick="delAllAso();"/></th>
                                            </tr>
                                            <%
												Vector<Association> v = (Vector<Association>)session.getAttribute("allAso");//�õ������û�����Ϣ
												Iterator<Association> it = v.iterator();
												Association m = null;
												while(it.hasNext()){
													m = it.next();
											%>	
                                        </thead>
                                        <tbody>
                                            <tr onmouseover="this.style.backgroundColor='#F0F8FF';" onmouseout="this.style.backgroundColor='#FFFFFF';">
                                            	<td><input type="checkbox" name="check" value=<%=m.getAno() %>></td>
                                                <td><%=m.getAno() %></td>
												<td><%=m.getAname() %></td>
												<td><%=m.getAchair() %></td>
												<td><%=m.getAteacher() %></td>
												<td>
													<a href="updateAso.jsp?ano=<%=m.getAno()%>">�޸�</a>
													<a href="updateAso?f=del&ano=<%=m.getAno() %>" onclick="return confirm('ȷ��ɾ����');">ɾ��</a>
												</td>
                                            </tr>
											<%		
												}
											%>
                                        </tbody>
                                    </table>
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