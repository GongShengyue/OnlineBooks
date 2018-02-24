package cn.ylcto.book.service.impl;

import cn.ylcto.book.dbc.DatabaseConnection;
import cn.ylcto.book.factory.DAOFactory;
import cn.ylcto.book.service.IItemService;
import cn.ylcto.book.vo.Item;

import java.util.List;

public class ItemServiceImpl implements IItemService{
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean insert(Item vo) throws Exception {
        try {
            return DAOFactory.getIItemDAOInstance(this.dbc.getConn()).doCreate(vo);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }


    }

    @Override
    public List<Item> list() throws Exception {
        try {
            return DAOFactory.getIItemDAOInstance(this.dbc.getConn()).findAll();
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }

    }
}
