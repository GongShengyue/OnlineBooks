package cn.ylcto.book.servlet;

import cn.ylcto.util.validate.ValidateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "AdminServlet",urlPatterns = "/pages/back/AdminServlet/*")
public class template extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/pages/errors.jsp";//定义错误页面
        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
        //表示截取的最后一个字符串
        if (status != null) {
            if ("login".equals(status)) {
                path = this.login(request);
            }
        }

        request.getRequestDispatcher(path).forward(request, response);
    }

    /**
     * 实现登录
     *
     * @param request
     * @return
     */
    public String login(HttpServletRequest request) {
        String msg = "";//表示提示信息
        String url = "";//表示跳转路径
        String aid = request.getParameter("aid");
        String password = request.getParameter("password");
        //判断数据是否为空
        if (ValidateUtils.validateEmpty(aid) && ValidateUtils.validateEmpty(password)) {//表示数据存在

        } else {
            msg = "数据不能为空";
            url = "login.jsp";
        }

        return "/pages/forward.jsp";
    }
}

