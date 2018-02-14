package cn.ylcto.book.factory;

import cn.ylcto.book.DAO.IAdminDAO;
import cn.ylcto.book.DAO.impl.AdminDAOImpl;

import java.sql.Connection;
//工厂类
public class DAOFactory {
    public static IAdminDAO getAdminDAOInstance(Connection conn){
        return new AdminDAOImpl(conn);
    }
}
