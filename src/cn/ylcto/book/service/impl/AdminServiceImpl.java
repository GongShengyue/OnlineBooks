package cn.ylcto.book.service.impl;

import cn.ylcto.book.vo.Admin;
import cn.ylcto.book.dbc.DatabaseConnection;
import cn.ylcto.book.factory.DAOFactory;
import cn.ylcto.book.service.IAdminService;

public class AdminServiceImpl implements IAdminService{
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean login(Admin vo) throws Exception {
        try{
            //如果登录成功
            if (DAOFactory.getAdminDAOInstance(this.dbc.getConn()).findLogin(vo)) {
                return DAOFactory.getAdminDAOInstance(this.dbc.getConn()).doUpdateByLastDate(vo.getAid());
            }
            return false;

        }
        catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }

    }

    @Override
    public boolean updateByLastDate(String aid) throws Exception {
        return false;
    }
}
