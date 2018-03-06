package cn.ylcto.book.DAO.impl;

import cn.ylcto.book.DAO.IMemberDao;
import cn.ylcto.book.vo.Member;
import cn.ylcto.util.test.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MemberDaoImpl extends AbstractDAOImpl implements IMemberDao{
    public MemberDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Member vo) throws SQLException {
        String sql = "INSERT INTO member(mid,name,age,sex,phone) VALUES(?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getMid());
        super.pstmt.setString(2,vo.getName());
        super.pstmt.setInt(3,vo.getAge());
        super.pstmt.setInt(4,vo.getSex());
        super.pstmt.setString(5,vo.getPhone());
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doUpdate(Member vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Member findById(String id) throws SQLException {
        Member vo = null;
        String sql = "SELECT mid,name,age,sex,phone FROM member WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,id);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            vo = new Member();
            vo.setMid(rs.getString(1));
            vo.setName(rs.getString(2));
            vo.setAge(rs.getInt(3));
            vo.setSex(rs.getInt(4));
            vo.setPhone(rs.getString(5));
        }
        return vo;
    }

    @Override
    public List<Member> findAll() throws SQLException {
        List<Member> all = new ArrayList<Member>();
        String sql = "select mid,name from member";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs =super.pstmt.executeQuery();
        while(rs.next()){
            Member vo = new Member();
            vo.setMid(rs.getString(1));
            vo.setName(rs.getString(2));
            all.add(vo);
        }
        return all;
    }

    @Override
    public List<Member> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }
}
