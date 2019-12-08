package cn.ylcto.book.DAO.impl;

import cn.ylcto.book.DAO.ILenbookDAO;
import cn.ylcto.book.vo.Lenbook;
import cn.ylcto.util.test.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public class LenbookDAOimpl extends AbstractDAOImpl implements ILenbookDAO{
    public LenbookDAOimpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Lenbook vo) throws SQLException {
        String sql = "INSERT INTO lenbook(bid,mid,credate) VALUES(?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,vo.getBooks().getBid());
        super.pstmt.setString(2,vo.getMember().getMid );
        super.pstmt.setTimestamp(3,new Timestamp(vo.getCredate().getTime()));

        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doUpdate(Lenbook vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Lenbook findById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Lenbook> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Lenbook> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }
}
