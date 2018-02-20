package cn.ylcto.book.DAO;

import cn.ylcto.book.vo.Admin;

import java.sql.SQLException;

//定义IAdminDAO借口并继承IDAO借口
public interface IAdminDAO extends IDAO<String,Admin> {
    /**
     * 实现用户登录检查操作
     * @param vo 表示要执行检查的对象（aid，password，flag
     * @return 成功返回true，失败返回
     * @throws SQLException
     */
    public boolean findLogin(Admin vo)throws SQLException;

    /**
     * 实现用户数据更新操作
     * @param aid 表示要更新的主键
     * @return
     * @throws SQLException
     */
    public boolean doUpdateByLastDate(String aid) throws SQLException;

}
