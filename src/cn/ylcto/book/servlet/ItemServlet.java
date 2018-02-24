package cn.ylcto.book.servlet;

import cn.ylcto.book.factory.ServiceFactory;
import cn.ylcto.book.vo.Item;
import cn.ylcto.util.validate.ValidateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "ItemServlet",urlPatterns = "/pages/back/ItemServlet/*")
public class ItemServlet extends HttpServlet {
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
                try {
                    path = this.insert(request);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        request.getRequestDispatcher(path).forward(request, response);
    }

    /**
     * 实现插入
     *
     * @param request
     * @return
     */
    public String insert(HttpServletRequest request) throws Exception {
        String msg = "";//表示提示信息
        String url = "";//表示跳转路径
        String name = request.getParameter("name");
        String note = request.getParameter("note");
        System.out.println(name);
        System.out.println(note);
        //数据验证
        if (ValidateUtils.validateEmpty(name) && ValidateUtils.validateEmpty(note)) {//表示数据存在
            Item vo = new Item();
            vo.setName(name);
            vo.setNote(note);
            try {
                if (ServiceFactory.getIItemServiceInstance().insert(vo)) {
                    msg = "数据增加成功";
                    url = "/pages/back/member/item_insert.jsp";

                }
            else {
                    msg = "数据添加失败，请重新添加！";
                    url = "/pages/back/item/item_insert.jsp";
                }

            }catch(Exception e){
                e.printStackTrace();
            }


        }else{
            msg = "数据不能为空";
            url = "/pages/back/member/item_insert.jsp";
        }
        request.setAttribute("msg",msg);
        request.setAttribute("url",url);

        return "/pages/forward.jsp";
    }
}

