<%@ taglib prefix="c" uri="http://www.ylcto.cn/c" %>
<%--
  Created by IntelliJ IDEA.
  User: gsy
  Date: 2018/2/6
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path ;
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>优乐图书管理系统</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/css/basic.css" rel="stylesheet" />
    <link href="assets/css/custom.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
<div id="wrapper">
    <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                <span class="sr-only">优乐图书管理系统</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="pages/back/index.jsp">优乐图书管理系统</a>
        </div>
        <!--顶部-->
        <div class="header-right">
            <a href="login.html" class="btn btn-danger" title="Logout"> 退出系统</a>
        </div>
    </nav>
    <!-- 导航 -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li>
                    <div class="user-img-div">
                        <img src="assets/img/user.png" class="img-thumbnail" />

                        <div class="inner-text">
                            管理员:<c:if test = "${aid != null}">
                            ${aid}
                        </c:if>
                            <br />
                            <small>上次登录日期:
                            <c:if test= "${lastdate != null}">
                                ${lastdate}
                            </c:if>
                            </small>
                        </div>
                    </div>
                </li>

                <li>
                    <a class="active-menu" href="index.html"><i class="fa fa-dashboard "></i>导航</a>
                </li>
                <!--用户信息-->
                <li>
                    <a href="#"><i class="fa fa-desktop "></i>用户管理 <span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="#"><i class="fa fa-toggle-on"></i>用户录入</a>
                        </li>
                    </ul>
                </li>
                <!--图书信息-->
                <li>
                    <a href="#"><i class="fa fa-yelp "></i>图书管理 <span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="invoice.html"><i class="fa fa-coffee"></i>增加图书</a>
                        </li>
                        <li>
                            <a href="pricing.html"><i class="fa fa-flash "></i>图书列表</a>
                        </li>
                    </ul>
                </li>
                <!--借书登记-->
                <li>
                    <a href="#"><i class="fa fa-bicycle "></i>借书登记 <span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="form.html"><i class="fa fa-desktop "></i>借书信息录入 </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>


    <!-- 此处编写内容  -->
    <div id="page-wrapper">
        <div id="page-inner">


        </div>
    </div>
</div>


<div id="footer-sec" style="text-align: center">
    &copy; 2014 YourCompany | More Templates <a href="http://www.ylcto.cn/" target="_blank" title="优乐网校">优乐网校</a> - Collect from <a href="http://www.ylcto.cn/" title="优乐编程" target="_blank">优乐编程</a>
</div>
<script src="assets/js/jquery-1.10.2.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/jquery.metisMenu.js"></script>
<script src="assets/js/custom.js"></script>
</body>
</html>