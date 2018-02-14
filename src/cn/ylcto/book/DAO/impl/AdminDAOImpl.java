package cn.ylcto.book.DAO.impl;

import cn.ylcto.book.Admin;
import cn.ylcto.book.DAO.IAdminDAO;
import cn.ylcto.book.DAO.IDAO;
import cn.ylcto.util.test.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class AdminDAOImpl extends AbstractDAOImpl implements IAdminDAO{
    public AdminDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean findLogin(Admin vo) throws SQLException {
        boolean flag = false;
        String sql = "SELECT lastdate FROM admin WHERE  aid=? AND PASSWORD=? AND flag=1";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getAid());
        super.pstmt.setString(2,vo.getPassword());
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            flag = true;
            vo.setLastdate(rs.getTimestamp(1));//这行是啥？？
        }

        return false;
    }

    @Override
    public boolean doCreate(Admin vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doUpdate(Admin vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Admin findById(String id) throws SQLException {
        return null;
    }

    @Override
    public List<Admin> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Admin> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }
}
