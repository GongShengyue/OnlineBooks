package cn.ylcto.book.servlet;

import cn.ylcto.book.Admin;
import cn.ylcto.book.factory.ServiceFactory;
import cn.ylcto.util.MD5Code;
import cn.ylcto.util.validate.ValidateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminServlet",urlPatterns = "/pages/back/AdminServlet/*")
public class AdminServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/pages/errors.jsp";//定义错误页面
        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        System.out.println(status);
        if(status != null){
            if("login".equals(status)){
                path = this.login(request);
            }
        }

        request.getRequestDispatcher(path).forward(request,response);
    }
    public String login(HttpServletRequest request) {
        String msg = "";//表示提示信息
        String url = "";//表示跳转路径
        //取得页面中传递过来的数据
        String aid = request.getParameter("aid");
        String password = request.getParameter("password");

        //判断数据是否为空
        if(ValidateUtils.validateEmpty(aid) && ValidateUtils.validateEmpty(password)){//表示数据存在
            Admin vo = new Admin();
            vo.setAid(aid);//取得参数
            vo.setPassword(new MD5Code().getMD5ofStr(password+aid));//需要加盐处理
            System.out.println(vo.getPassword());//用于测试输出加盐密码
            try{
                if(ServiceFactory.getIAdminServiceInstance().login(vo)) {
                    request.getSession().setAttribute("aid",aid);//保存aid
                    msg = "登录成功";
                    url = "/pages/back/index.jsp";
                }else{
                    msg = "登录失败，错误的ID或密码";
                    url = "/login.jsp";
                }
                }catch (Exception e){
                e.printStackTrace();
            }

            }

        else{
            msg = "数据不能为空";
            url = "/kong.jsp";
        }

        request.setAttribute("msg",msg);
        request.setAttribute("url",url);
        return "/pages/forward.jsp";

        }
}
