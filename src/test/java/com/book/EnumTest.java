package com.book;

import com.alibaba.fastjson.JSON;
import com.book.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: luoxian
 * @Date: 2020/4/26 14:12
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class EnumTest extends LearnApplicationTests {

    @Test
    public void enumTest(){
        List<Map> list = ResultEnum.typeEnumList();
        log.info("获取枚举的集合list:{}", JSON.toJSONString(list));

        List list1 = ResultEnum.enumCodeList();
        log.info("获取枚举的code list:{}",list1);

        String message = ResultEnum.fromValue(1006).getMessage();
        log.info("根据code 获取枚举的对应message:{}",message);
    }

    @Test
    public void enumIterationTest(){
        List<Map> list = ResultEnum.typeEnumList();
        list.forEach( m->{
            String name = m.get("name").toString();
            log.info("获取的name:{}",name);
        });
    }
}
