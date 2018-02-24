package cn.ylcto.book.service;

import cn.ylcto.book.vo.Item;

public interface IItemService {
    /**
     * 实现分类的增加操作
     * @param vo 表示要执行的vod对象
     * @return 成功返回true，失败返回false
     * @throws Exception
     */
    public boolean insert(Item vo)throws Exception;
}
