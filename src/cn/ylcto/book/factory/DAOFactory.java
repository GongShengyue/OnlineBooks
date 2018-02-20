package cn.ylcto.book.factory;

import cn.ylcto.book.DAO.IAdminDAO;
import cn.ylcto.book.DAO.IMemberDao;
import cn.ylcto.book.DAO.impl.AdminDAOImpl;
import cn.ylcto.book.DAO.impl.MemberDaoImpl;

import java.sql.Connection;
//工厂类
public class DAOFactory {
    public static IAdminDAO getAdminDAOInstance(Connection conn){
        return new AdminDAOImpl(conn);
    }
    public static IMemberDao getIMemberDAOInstance(Connection conn){
        return new MemberDaoImpl(conn);
    }
}
