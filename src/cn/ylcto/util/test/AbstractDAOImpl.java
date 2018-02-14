package cn.ylcto.util.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AbstractDAOImpl {
    protected Connection conn;
    protected PreparedStatement pstmt;
    //定义一个构造方法
    public AbstractDAOImpl(Connection conn){
        this.conn = conn;
    }
}
