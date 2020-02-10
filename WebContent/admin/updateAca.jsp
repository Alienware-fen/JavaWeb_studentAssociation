<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@page import="java.util.*,cn.edu.lingnan.dto.Academic" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>
<body>
<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@page import="java.util.*,cn.edu.lingnan.dto.Member" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
        <title>Student Information</title>    
        <!-- 左边排版 -->
        <link href="assets/css/icons.css" rel="stylesheet" />
        <!-- 相对位置-->
        <link href="assets/css/bootstrap.css" rel="stylesheet" />
        <!-- 主要排版 -->
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
                                    <img class="user-avatar" src="assets/img/avatars/59.jpg">霓凰</a>
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
                    <li><a href="#"> 社团信息<i class="im-table2"></i></a>
                        <ul class="nav sub">
                            <li><a href="tableStu.html"><i class="en-arrow-right7"></i>学生信息</a></li>
                            <li><a href="tableAso.html"><i class="en-arrow-right7"></i>社团信息</a></li>
                            <li><a href="tableAca.html"><i class="en-arrow-right7"></i>学院信息</a></li>
                        </ul>
                    </li>
                    <li><a><i class="im-images"></i> 社团活动</a></li>
                    <li><a href="#">社团管理<i class="im-table2"></i></a>
                        <ul class="nav sub">
                        	<li><a href="findAllStu"><i class="en-arrow-right7"></i>学生基本表</a></li>
                            <li><a href="findAllAso"><i class="en-arrow-right7"></i>社团基本表</a></li>
                            <li><a href="findAllAca"><i class="en-arrow-right7"></i>学院基本表</a></li>
                        </ul>
                    </li>
                    <li><a><i class="st-diamond"></i> 社团协会</a></li>
                </ul>
            </div>
        </div>
        <div id="content">
            <div class="content-wrapper">
                    <div class="col-lg-12 heading">
                        <h1 class="page-header"><i class="im-screen"></i> 学生社团管理系统</h1>
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
                                <h4 class="panel-title">学生基本信息</h4>
                                </div>
                                <div class="panel-body">
                                    <form action="updateAca">
										<table>
										<tr>
											<td>学生号</td>
											<td>社团号</td>
											<td>学院名</td>
											<td>院长名</td>
											<td></td>
										</tr>
										<%
											Vector<Academic> v = (Vector<Academic>)session.getAttribute("allAca");//
											Iterator<Academic> it = v.iterator();
											String sno = request.getParameter("sno");
											Academic m = null;
											while(it.hasNext()){
												m = it.next();
												if(m.getSno().equals(sno)){
										%>	
										<tr>
											<td><input type="text" name="sno"  readonly="true" value=<%=m.getSno() %>></td>
											<td><input type="text" name="ano"  readonly="true" value=<%=m.getAno() %>></td>
											<td><input type="text" name="profname"  value=<%=m.getProfname() %>></td>
											<td><input type="text" name="profpresident"  value=<%=m.getProfpresident() %>></td>
											<td><input type="submit" value="修改"></td>
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
        <!-- 左边下拉表格 -->
        <script>
      	  window.jQuery || document.write('<script src="assets/js/libs/jquery-2.1.1.min.js">\x3C/script>')
        </script>
       			 <!-- 弹出退出框 -->
        <script src="assets/js/bootstrap/bootstrap.js"></script>
       			 <!-- 导航栏箭头的动作 -->
        <script src="assets/js/jRespond.min.js"></script>
       			 <!-- 左边栏箭头的相关设置 -->
        <script src="assets/plugins/core/quicksearch/jquery.quicksearch.js"></script>
        <script src="assets/plugins/misc/highlight/highlight.pack.js"></script>
        <script src="assets/js/jquery.sprFlat.js"></script>
        <script src="assets/js/app.js"></script>
</body>
</html>