package cn.ylcto.book.factory;

import cn.ylcto.book.service.IAdminService;
import cn.ylcto.book.service.IBooksService;
import cn.ylcto.book.service.IItemService;
import cn.ylcto.book.service.IMemberService;
import cn.ylcto.book.service.impl.AdminServiceImpl;
import cn.ylcto.book.service.impl.BooksServiceImpl;
import cn.ylcto.book.service.impl.ItemServiceImpl;
import cn.ylcto.book.service.impl.MemberServiceImpl;
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

}
