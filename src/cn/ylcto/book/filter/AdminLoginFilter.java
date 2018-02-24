package cn.ylcto.book.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(filterName = "AdminLoginFilter",urlPatterns = {"/pages/back/member/*","/pages/back/item/*","/pages/index.jsp"})
public class AdminLoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();//取得session借口对象
        if(session.getAttribute("aid")!=null) {//表示有内容存在
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            request.setAttribute("msg","您还未登录，请先登录后操作");
            request.setAttribute("url","/login.jsp");
            request.getRequestDispatcher("/pages/forward.jsp").forward(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
