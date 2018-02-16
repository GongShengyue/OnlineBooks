<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path ;
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>跳转页面</title>
</head>
<body>
<script type="text/javascript">
  	window.alert("${msg}") ;//使用了EL表达式
    window.location = "<%=basePath%>${url}" ;
</script>
</body>
</html>
