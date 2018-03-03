package cn.ylcto.book.DAO.impl;

import cn.ylcto.book.DAO.IBooksDAO;
import cn.ylcto.book.vo.Admin;
import cn.ylcto.book.vo.Books;
import cn.ylcto.book.vo.Item;
import cn.ylcto.util.test.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BooksDAOImpl extends AbstractDAOImpl implements IBooksDAO {
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
        return super.pstmt.executeUpdate() > 0;
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
        List<Books> all = new ArrayList<Books>();
        String sql ="SELECT bid,iid,aid,name,credate,status,note FROM books";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            Books vo = new Books();
            vo.setBid(rs.getInt(1));
            Item item = new Item();
            item.setIid(rs.getInt(2));
            vo.setItem(item);
            Admin admin = new Admin();
            admin.setAid(rs.getString(3));
            vo.setAdmin(admin);
            vo.setName(rs.getString(4));
            vo.setCredate(rs.getDate(5));
            vo.setStatus(rs.getInt(6));
            vo.setNote(rs.getString(7));
            all.add(vo);
        }
        return all;
    }

    @Override
    public List<Books> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        List<Books> all = new ArrayList<Books>();
        String sql = " SELECT b.bid,b.name,b.credate,b.status,a.aid,i.name " +
                " FROM books b,admin a ,item i " +
                " WHERE b.iid= i.iid AND b.aid = a.aid AND b."+ column +" LIKE  ?  LIMIT ?,? ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%"+keyWord+"%");
        super.pstmt.setInt(2,(currentPage -1) *lineSize);
        super.pstmt.setInt(3,lineSize);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            Books vo = new Books();
            vo.setBid(rs.getInt(1));
            vo.setName(rs.getString(2));
            vo.setCredate(rs.getDate(3));
            vo.setStatus(rs.getInt(4));
            Admin admin = new Admin();
            admin.setAid(rs.getString(5));
            vo.setAdmin(admin);
            Item item = new Item();
            item.setName(rs.getString(6));
            vo.setItem(item);
            all.add(vo);
        }
        return all;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        String sql = "SELECT COUNT(*) FROM books WHERE "+column +" LIKE ?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%"+keyWord+"%");
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }
}
