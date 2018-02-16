package cn.ylcto.book.factory;

import cn.ylcto.book.service.IAdminService;
import cn.ylcto.book.service.impl.AdminServiceImpl;
import cn.ylcto.book.servlet.AdminServlet;

//服务层工厂类
public class ServiceFactory {
    public static IAdminService getIAdminServiceInstance() {
    return new AdminServiceImpl();
    }


}
