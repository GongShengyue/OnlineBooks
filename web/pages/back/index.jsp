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
  <jsp:include page="header.jsp"></jsp:include>

  <!-- 此处编写内容  -->
  <div id="page-wrapper">
    <div id="page-inner">
    <%--编写数据增加表单--%>


    </form>
</div>



</div>
</div>
</div>


<jsp:include page="footer.jsp"></jsp:include>
<script src="assets/js/jquery-1.10.2.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/jquery.metisMenu.js"></script>
<script src="assets/js/custom.js"></script>
</body>
</html>
