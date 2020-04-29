package com.book;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author: luoxian
 * @Date: 2020/4/26 14:15
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class StringTest extends LearnApplicationTests {

    @Test
    public void stringTest(){
        String str = "hi支付宝";
        if ("支付".indexOf("支付") ==1){
            log.info("含有：{}");
        }
    }

    @Test
    public void stringNullSetDefault(){
        String testUrl = null;
        String url = Optional.ofNullable(testUrl).orElse("http:www.jd.com");
        log.info("字符串为空则设置默认值：{}",url);
    }
}
