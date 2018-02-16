package cn.ylcto.book.factory;

import cn.ylcto.book.service.IAdminService;
import cn.ylcto.book.service.impl.AdminServiceImpl;
//服务层工厂类
public class ServiceFactory {
    public static IAdminService getAdminServiceInstance() {
    return new AdminServiceImpl();
    }
}
