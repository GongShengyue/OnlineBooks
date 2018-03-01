package cn.ylcto.book.service.impl;

import cn.ylcto.book.dbc.DatabaseConnection;
import cn.ylcto.book.factory.DAOFactory;
import cn.ylcto.book.service.IBooksService;
import cn.ylcto.book.vo.Books;

import java.util.HashMap;
import java.util.Map;

public class BooksServiceImpl implements IBooksService{
    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public boolean insert(Books vo) throws Exception {
        try {
            return DAOFactory.getIBooksDAOInstance(this.dbc.getConn()).doCreate(vo);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }

    }

    @Override
    public Map<String, Object> findByAdminAndItem() throws Exception {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("allAdmins",DAOFactory.getAdminDAOInstance(this.dbc.getConn()).findAll());
            map.put("allItems",DAOFactory.getIItemDAOInstance(this.dbc.getConn()).findAll());
            return map;
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();

        }
    }
}
