package cn.ylcto.book.service.impl;

import cn.ylcto.book.dbc.DatabaseConnection;
import cn.ylcto.book.factory.DAOFactory;
import cn.ylcto.book.service.IMemberService;
import cn.ylcto.book.vo.Member;

public class MemberServiceImpl implements IMemberService{
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean insert(Member vo) throws Exception {
        try{
            if(DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).findById(vo.getMid()) == null)
            return DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).doCreate(vo);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return false;
    }
}
