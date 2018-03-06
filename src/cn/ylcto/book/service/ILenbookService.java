package cn.ylcto.book.service;

import cn.ylcto.book.vo.Lenbook;

import java.util.Map;

public interface ILenbookService {
    /**
     * 实现数据增加操作
     * @param vo
     * @return
     * @throws Exception
     */
    public boolean insert(Lenbook vo) throws Exception;

    /**
     * 取得books数据和member表中数据
     * @return
     * @throws Exception
     */
    public Map<String,Object> listByMemberAndBooks() throws Exception;
}
