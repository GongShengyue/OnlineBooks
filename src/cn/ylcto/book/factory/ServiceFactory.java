package cn.ylcto.book.factory;

import cn.ylcto.book.service.*;
import cn.ylcto.book.service.impl.*;
import cn.ylcto.book.servlet.AdminServlet;

//服务层工厂类
public class ServiceFactory {
    public static IAdminService getIAdminServiceInstance() {
    return new AdminServiceImpl();
    }
    public static IMemberService getIMemberServiceInstance(){return new MemberServiceImpl();}
    public static IItemService getIItemServiceInstance(){return new ItemServiceImpl(); }
    public static IBooksService getIBooksServiceInstance(){
        return new BooksServiceImpl();
    }
    public static ILenbookService getILenbooksServiceInstance(){return new LenbookServiceImpl();}

}
