package cn.ylcto.book.DAO.impl;

import cn.ylcto.book.DAO.IBooksDAO;
import cn.ylcto.book.vo.Books;
import cn.ylcto.util.test.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BooksDAOImpl extends AbstractDAOImpl implements IBooksDAO{
    public BooksDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Books vo) throws SQLException {
        String sql = "INSERT INTO books(iid,aid,name,credate,status,note)VALUES(?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,vo.getItem().getIid());
        super.pstmt.setString(2,vo.getAdmin().getAid());
        super.pstmt.setString(3,vo.getName());
        super.pstmt.setTimestamp(4, new Timestamp(vo.getCredate().getTime()));
        super.pstmt.setInt(5,vo.getStatus());
        super.pstmt.setString(6,vo.getNote());
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doUpdate(Books vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Books findById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Books> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Books> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }
}
