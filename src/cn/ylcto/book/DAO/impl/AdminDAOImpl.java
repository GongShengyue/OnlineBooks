package cn.ylcto.book.DAO.impl;

import cn.ylcto.book.vo.Admin;
import cn.ylcto.book.DAO.IAdminDAO;
import cn.ylcto.util.test.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class AdminDAOImpl extends AbstractDAOImpl implements IAdminDAO{
    public AdminDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean findLogin(Admin vo) throws SQLException {
        boolean flag = false;
        String sql = "SELECT lastdate FROM admin WHERE  aid=? AND password=? AND flag=1";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getAid());
        super.pstmt.setString(2,vo.getPassword());
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            flag = true;
            vo.setLastdate(rs.getTimestamp(1));//这行是啥？？
        }

        return flag;
    }

    @Override
    public boolean doUpdateByLastDate(String aid) throws SQLException {
        String sql = "UPDATE admin SET lastdate=?WHERE aid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        //登录成功后不直接使用当前日前为最后一次登录日期
        super.pstmt.setTimestamp(1,new Timestamp(new Date().getTime()));
        super.pstmt.setString(2,aid);
        return super.pstmt.executeUpdate()>0;
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
        List<Admin> all = new ArrayList<Admin>();
        String sql = "SELECT aid,password,lastdate,flag,status FROM admin";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()){
            Admin vo = new Admin();
            vo.setAid(rs.getString(1));
            vo.setPassword(rs.getString(2));
            vo.setLastdate(rs.getTimestamp(3));
            vo.setFlag(rs.getInt(4));
            vo.setStatus(rs.getInt(5));
            all.add(vo);

        }
        return all;
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
