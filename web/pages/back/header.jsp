<%@ taglib prefix="c" uri="http://www.ylcto.cn/c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
            <span class="sr-only">优乐图书管理系统</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/pages/index.jsp">优乐图书管理系统</a>
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
                        管理员: <c:if test="${aid != null}">
                        ${aid}
                    </c:if>
                        <br />
                        <small>上次登录日期:
                            <c:if test="${lastdate != null}">
                                ${lastdate}
                            </c:if>
                        </small>
                    </div>
                </div>
            </li>

            <li>
                <a class="active-menu" href="pages/index.jsp"><i class="fa fa-dashboard "></i>导航</a>
            </li>
            <!--用户信息-->
            <li>
                <a href="#"><i class="fa fa-desktop "></i>用户管理 <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="/pages/back/member/member_insert.jsp"><i class="fa fa-toggle-on"></i>用户录入</a>
                    </li>
                </ul>
            </li>
            <!--分类信息-->
            <li>
                <a href="#"><i class="fa fa-desktop "></i>分类管理 <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="/pages/back/member/item_insert.jsp"><i class="fa fa-toggle-on"></i>增加分类</a>
                    </li>
                    <li>
                        <a href="/pages/back/item/ItemServlet/list"><i class="fa fa-flash "></i>列表分类</a>
                    </li>
                </ul>
            </li>
            <!--图书信息-->
            <li>
                <a href="#"><i class="fa fa-yelp "></i>图书管理 <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="/pages/back/books/BooksServlet/insertPro"><i class="fa fa-coffee"></i>增加图书</a>
                    </li>
                    <li>
                        <a href="/pages/back/books/BooksServlet/listSplit"><i class="fa fa-flash "></i>图书列表</a>
                    </li>
                </ul>
            </li>
            <!--借书登记-->
            <li>
                <a href="#"><i class="fa fa-bicycle "></i>借书登记 <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="/pages/back/lenbook/LenbookServlet/insertPro"><i class="fa fa-desktop "></i>借书信息录入 </a>
                    </li>
                    <li>
                        <a href="/pages/back/lenbook/LenbookServlet/listSplit"><i class="fa fa-desktop "></i>借书信息列表 </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
