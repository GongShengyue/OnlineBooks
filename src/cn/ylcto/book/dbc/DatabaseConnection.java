package cn.ylcto.book.dbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DBDRIVER = "com.jdbc.mysql.driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/booksystem";
    private static final String DBUSER = "root";
    private static final String DBPASS = "gsy199605";//数据库连接密码

    private Connection conn;

    public DatabaseConnection(){
        try {
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Connection getConn(){
        return this.conn;
    }
    public void close(){
        if(this.conn!=null) {
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
