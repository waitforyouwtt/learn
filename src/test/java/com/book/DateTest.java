package com.book;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: luoxian
 * @Date: 2020/4/26 14:12
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class DateTest extends LearnApplicationTests {

    @Test
    public void getNowTest(){
        long systemTime = System.currentTimeMillis();
        log.info("系统时间：{}",systemTime);
        long now = new Date().getTime();
        log.info("当前时间：{}",now);
    }


}
