package cn.ylcto.book.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
* 这个借口表示一个公共的DAO借口
* @param <K>表示主键
* @param <V>表示要操作的对象
* */
public interface IDAO<K,V> {
    /**
    *实现数据增加操作
     * @param vo 表示要执行操作的对象
     * @return 成功返回true，失败返回false
     *  @throws SQLException
    * */
    public boolean doCreate(V vo)throws SQLException;

    /**
     *实现数据更新操作
     * @param vo 表示要执行更新的对象
     * @return 成功返回true，失败返回false
     * @throws SQLException
     */
    public boolean doUpdate(V vo)throws SQLException;

    /**
     * 实现数据批量删除
     * @param ids 表示要执行删除的数据集合
     * @return 成功返回true，失败返回false
     * @throws SQLException
     */
    public boolean doRemove(Set<?> ids)throws SQLException;

    /**
     * 根据用户提供的id进行查询
     * @param id 表使用执行查询的行
     * @return 查询成功返回该数据行中的记录，失败返回null
     * @throws SQLException
     */
    public V findById(K id)throws SQLException;

    /**
     * 实现数据全部查询
     * @return成功返回所有数据，失败返回null
     * @throws SQLException
     */
    public List<V> findAll()throws SQLException;

    /**
     * 实现数据分页操作
     * @param column 表示要执行查询列
     * @param keyWord 表示查询关键字
     * @param currentPage 表示当前页
     * @param lineSize 表示每页记录数
     * @return 成功返回满足条件的数据，失败时返回null
     * @throws SQLException
     */
    public List<V> findAllBySplit(String column,String keyWord,Integer currentPage,Integer lineSize)throws SQLException;

    /**
     * 实现数据量统计操作
     * @param column 表示要执行统计列
     * @param keyWord 表示统计查询关键字
     * @return 成功返回数据量，失败返回null
     * @throws SQLException
     */
    public Integer getAllCount(String column,String keyWord)throws SQLException;


}
