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
            + path +"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>YF图书管理系统</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/css/basic.css" rel="stylesheet" />
    <link href="assets/css/custom.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
<div id="wrapper">
    <jsp:include page="/pages/back/header.jsp"></jsp:include>

    <!-- 此处编写内容  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="col-md-12">
                <div class="col-md-6 col-md-offset-4">
                    <h1 class="h1">增加用户操作</h1>
                </div>
                <div class="col-md-12">
                    <hr>
                </div>
            </div>
            <%--编写增加数据表单 --%>
                <form action="<%=basePath%>pages/back/MemberServlet/insert" method="post" class="form-horizontal" id="insertForm">
                    <%--编号--%>
                    <div class="form-group">
                        <label for="mid" class="col-md-3 control-label">编号</label>
                        <div class="col-md-6">
                            <input type="text" name="mid" id="mid" class="form-control input-sm">
                        </div>
                    </div>
                    <%--性别--%>
                    <div class="form-group">
                        <label for="name" class="col-md-3 control-label">姓名</label>
                        <div class="col-md-6">
                            <input type="text" name="name" id="name" class="form-control input-sm">
                        </div>
                    </div>
                    <%--年龄--%>
                    <div class="form-group">
                        <label for="age" class="col-md-3 control-label">年龄</label>
                        <div class="col-md-6">
                            <input type="text" name="age" id="age" class="form-control input-sm">
                        </div>
                    </div>


                    <!--性别-->
                    <div class="form-group">
                        <label for="sex" class="col-md-3 control-label">性别</label>
                        <div class="radio">
                            <div class="col-md-2 col-md-offset-1">
                                <input type="radio" name="sex" id="sex" value="1" checked >男
                            </div>
                            <div class="col-md-1">
                                <input type="radio" name="sex" id="sex"  value="2">女
                            </div>
                        </div>
                    </div>

                    <!--联系电话-->
                    <div class="form-group">
                        <label for="phone" class="col-md-3 control-label">联系电话</label>
                        <div class="col-md-6">
                            <input type="text" name="phone" id="phone" class="form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-5 col-md-offset-3">
                            <button type="submit" class="btn btn-success c">提交</button>
                            <button type="reset" class="btn btn-success">重置</button>
                        </div>
                    </div>
                </form>

        </div>
    </div>
</div>


<jsp:include page="/pages/back/footer.jsp"></jsp:include>
<script src="assets/js/jquery-1.10.2.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/jquery.metisMenu.js"></script>
<script src="assets/js/custom.js"></script>
<script type="text/javascript" src="validate/js/jquery-1.11.3.min.js" ></script>
<script type="text/javascript" src="validate/js/additional-methods.min.js" ></script>
<script type="text/javascript" src="validate/js/jquery.metadata.js" ></script>
<script type="text/javascript" src="validate/js/jquery.validate.min.js" ></script>
<script type="text/javascript" src="validate/js/Message_zh_CN.js"></script>
<script type="text/javascript" src="validate/member_insert.js"></script>
</body>
</html>
