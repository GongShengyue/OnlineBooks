package cn.ylcto.book.servlet;

import cn.ylcto.book.factory.ServiceFactory;
import cn.ylcto.book.vo.Admin;
import cn.ylcto.book.vo.Books;
import cn.ylcto.book.vo.Lenbook;
import cn.ylcto.book.vo.Member;
import cn.ylcto.util.validate.ValidateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;

import cn.ylcto.util.validate.ValidateUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "lenbookServlet",urlPatterns = "/pages/back/lenbook/LenbookServlet/*")
public class LenbookServlet extends HttpServlet {

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
            if ("insert".equals(status)) {
                path = this.insert(request);
            }else if("insertPro".equals(status)){
                path = this.insertPro(request);
            }
        }

        request.getRequestDispatcher(path).forward(request, response);
    }


    public String insert(HttpServletRequest request) {
        String msg = "";
        String url = "";
        //接受参数
        int bid = Integer.parseInt(request.getParameter("bid"));
        String mid = request.getParameter("mid");
        if(ValidateUtils.validateEmpty(mid)) {
            Lenbook vo = new Lenbook();
            Books books = new Books();
            books.setBid(bid);
            vo.setBooks(books);//设置图书编号
            Member member = new Member();
            member.setMid(mid);
            vo.setMember(member);
            vo.setCredate(new Date());//表示当前日期
            try {
                if (ServiceFactory.getILenbooksServiceInstance().insert(vo)) {
                    msg = "数据增加成功!";
                } else {
                    msg = "数据增加失败，请重新添加";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            msg = "输入的内容不允许为空";
        }
        request.setAttribute("msg",msg);
        request.setAttribute("url","/pages/back/lenbook/lenbook_insert.jsp");

        return "/pages/forward.jsp";
    }

    public String insertPro(HttpServletRequest request) {
        String msg = "";
        String url = "";
        //接受参数
        int bid = Integer.parseInt(request.getParameter("bid"));
        String mid = request.getParameter("mid");
        if(ValidateUtils.validateEmpty(mid)) {
            Lenbook vo = new Lenbook();
            Books books = new Books();
            books.setBid(bid);
            vo.setBooks(books);//设置图书编号
            Member member = new Member();
            member.setMid(mid);
            vo.setMember(member);
            vo.setCredate(new Date());//表示当前日期
            try {
                if (ServiceFactory.getILenbooksServiceInstance().insert(vo)) {
                    msg = "数据增加成功!";
                } else {
                    msg = "数据增加失败，请重新添加";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            msg = "输入的内容不允许为空";
        }
        request.setAttribute("msg",msg);
        request.setAttribute("url","/pages/back/lenbook/lenbook_insert.jsp");

        return "/pages/forward.jsp";
    }


}


