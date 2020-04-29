package com.book;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

/**
 * @Author: luoxian
 * @Date: 2020/4/26 14:12
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class FileTest extends LearnApplicationTests {

    @Test
    public void fileTest(){
        String pathName = "C://E://photo/self.jpg";
        String fileName = pathName.substring(0,pathName.lastIndexOf("."));
        log.info("获取到的文件名字结果：{}",fileName);
    }
}
