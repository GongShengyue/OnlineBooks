package cn.ylcto.book.factory;

import cn.ylcto.book.DAO.*;
import cn.ylcto.book.DAO.impl.*;

import java.sql.Connection;
//工厂类
public class DAOFactory {
    public static IAdminDAO getAdminDAOInstance(Connection conn){
        return new AdminDAOImpl(conn);
    }
    public static IMemberDao getIMemberDAOInstance(Connection conn){
        return new MemberDaoImpl(conn);
    }
    public static IItemDAO getIItemDAOInstance(Connection conn){
        return new ItemDAOImpl(conn);
    }
    public static IBooksDAO getIBooksDAOInstance(Connection conn){
        return new BooksDAOImpl(conn);
    }
    public static ILenbookDAO getILenbookDAOInstance(Connection conn){return new LenbookDAOimpl(conn);}
}
