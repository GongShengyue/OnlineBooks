<%@ page pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="mldn.css">
<%--
<div id="splitBarDiv" style="float:right">
	<jsp:include page="/pages/split_page_plugin_bars.jsp"/>
</div>
--%>
<%
	request.setCharacterEncoding("UTF-8") ;
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<%
	String url = null ;
	int currentPage = 1 ;
	int lineSize = 5 ;
	String column = null ;
	String keyWord = null ;
	int allRecorders = 0 ;
	int pageSize = 0 ;
	int lsData [] = new int [] {1,5,10,15,20,30,50,100} ;
	int seed = 3 ;	// 种子数
	String paramName = request.getParameter("paramName") ;
	String paramValue = request.getParameter("paramValue") ;
%>

<%	// 接收传递的参数
	try {
		currentPage = (Integer) request.getAttribute("currentPage") ;
	} catch (Exception e) {}
	try {
		allRecorders = (Integer)request.getAttribute("allRecorders") ;
	} catch (Exception e) {}
	try {
		lineSize = (Integer) request.getAttribute("lineSize") ;
	} catch (Exception e) {}
	column = (String) request.getAttribute("column") ;
	keyWord = (String) request.getAttribute("keyWord") ;
	url = basePath + request.getAttribute("url") ;
%>
<%
	if (allRecorders > 0) {
		pageSize = (allRecorders + lineSize - 1) / lineSize ;
	} else {	// 没有记录
		pageSize = 1 ;
	}
%>

<script type="text/javascript">
	function goSplit(vcp) {	// 根据外部传递的cp内容进行操作
		try {
			var eleKw = document.getElementById("kw").value ;
			var eleCol = document.getElementById("colSel").value ;
			window.location = "<%=url%>?cp=" + vcp + "&ls=" + <%=lineSize%> + "&kw=" + eleKw + "&col=" + eleCol + "&<%=paramName%>=<%=paramValue%>" ;
		} catch (Exception) {
			window.location = "<%=url%>?cp=" + vcp + "&ls=" + <%=lineSize%> + "&<%=paramName%>=<%=paramValue%>" ;
		}
	}
</script>
<ul class="pagination"> 
<%
if (pageSize > seed * 3) {
%>
	<li class="<%=currentPage == 1?"active":""%>"><a onclick="goSplit(1)">1</a></li>
	
<%
	if (currentPage > seed * 2) {
%>
		<li class="disabled"><span>...</span></li>
<%
		int startPage = currentPage - seed ;
		int endPage = currentPage + seed ;
		for (int x = startPage ; x <= endPage ; x ++) {
			if(x < pageSize) {
%>
				<li class="<%=currentPage == x?"active":""%>"><a onclick="goSplit(<%=x%>)"><%=x%></a></li>
<%
			}
		}
		if ((currentPage + seed * 2) <= pageSize) {
%>
			<li class="disabled"><span>...</span></li>
<%		
		}
	} else {	// 还在6页以前
		for (int x = 2 ; x <= currentPage + seed ; x ++) {
%>
			<li class="<%=currentPage == x?"active":""%>"><a onclick="goSplit(<%=x%>)"><%=x%></a></li>
<%
		}
				if ((currentPage + seed * 2) <= pageSize) {
%>
			<li class="disabled"><span>...</span></li>
<%		
		}
	}
%>
	<li class="<%=currentPage == pageSize?"active":""%>"><a onclick="goSplit(<%=pageSize%>)"><%=pageSize%></a></li>
<%
} else {
	for (int x = 1 ; x <= pageSize ; x ++) {
%>
		<li class="<%=currentPage == x?"active":""%>"><a onclick="goSplit(<%=x%>)"><%=x%></a></li>
<%
	}
}
%>
</ul>