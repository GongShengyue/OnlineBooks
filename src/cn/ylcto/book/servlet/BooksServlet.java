package cn.ylcto.book.servlet;

import cn.ylcto.book.factory.ServiceFactory;
import cn.ylcto.book.vo.Admin;
import cn.ylcto.book.vo.Books;
import cn.ylcto.book.vo.Item;
import cn.ylcto.util.validate.ValidateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "BooksServlet",urlPatterns = "/pages/back/books/BooksServlet/*")
public class BooksServlet extends HttpServlet {
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
            if ("insertPro".equals(status)) {
                path = this.insertPro(request);
            }else if("insert".equals(status)){
                try {
                    path = this.insert(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        request.getRequestDispatcher(path).forward(request, response);
    }
    public String insert(HttpServletRequest request,HttpServletResponse response) throws Exception {
        //msg url;
        String msg ="";
        String url ="";
        //取得页面中的数据
        String name = request.getParameter("name");
        String aid = request.getParameter("aid");
        Integer iid = Integer.parseInt(request.getParameter("iid"));
        String note = request.getParameter("note");
        //判断数据是否为空
        if(ValidateUtils.validateEmpty(name)&&ValidateUtils.validateEmpty(aid)&&ValidateUtils.validateEmpty(note)) {
            Books vo = new Books();
            vo.setName(name);
            Admin admin = new Admin();
            admin.setAid(aid);
            vo.setAdmin(admin);
            Item item = new Item();
            item.setIid(iid);
            vo.setCredate(new Date());
            vo.setStatus(1);//1 表示上架，0表示下架操作
            vo.setNote(note);
            try {
                if (ServiceFactory.getIBooksServiceInstance().insert(vo)) {
                    msg = "数据已经增加成功！";
                    url = "/pages/back/AdminServlet/insertPro";
                } else {
                    msg = "你输入的信息有误，请重新输入";
                    url = "/pages/back/AdminServlet/insertPro";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    else {
        msg = "你输入的内容为空，请重新输入";
        url = "/pages/back/AdminServlet/insertPro";
        }
        request.setAttribute("msg",msg);
        request.setAttribute("url",url);

        return "/pages/forward.jsp";
    }
    /**
     *
     *
     * @param request
     * @return
     */
    public String insertPro(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<String,Object>();
        request.setAttribute("allItems",map.get("allItems"));
        request.setAttribute("allAdmins",map.get("allAdmins"));


        return "/pages/back/books/books_insert.jsp";
    }
}

