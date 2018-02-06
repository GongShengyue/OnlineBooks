package cn.itcast.test;
import cn.itcast.commons.CommonUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试CommonUtils类
 */
public class CommonUtilsTest {
/*
* 测试uuid返回一个随机的32位长的字符串
* */
    @Test
    public void testUunid(){

        String s = CommonUtils.uuid();
        System.out.println(s);
    }
    /**
     * 作用:把一个map中的数据封装到javaBean中
     * 要求：
     * 1.要求map中的key名称与javaBean中的属性名称相同
     *
     */

    public void testToBean(){
        /*创建MAP*/

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("pid","123");
        map.put("pname","张三");
        map.put("age","23");
        map.put("xxx","XXX");

        //通过map的数据来创建Person类型的JavaBean对象
        Person p = CommonUtils.toBean(map,Person.class);
        System.out.println(p);

    }


}
