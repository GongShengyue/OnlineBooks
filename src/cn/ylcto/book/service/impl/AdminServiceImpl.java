package cn.ylcto.book.service.impl;

import cn.ylcto.book.Admin;
import cn.ylcto.book.DAO.IAdminDAO;
import cn.ylcto.book.dbc.DatabaseConnection;
import cn.ylcto.book.factory.DAOFactory;
import cn.ylcto.book.service.IAdminService;

public class AdminServiceImpl implements IAdminService{
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean login(Admin vo) throws Exception {
        try{
            return DAOFactory.getAdminDAOInstance(this.dbc.getConn()).findLogin(vo);

        }
        catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }

    }
}
