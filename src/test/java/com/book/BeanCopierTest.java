package com.book;

import com.book.entity.Person;
import com.book.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;


/**
 * @Author: luoxian
 * @Date: 2020/5/20 14:01
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class BeanCopierTest extends LearnApplicationTests{

    @Test
    public void beanCopierTest(){

        UserInfo userInfo = UserInfo.builder().userName("张杰").build();

        Person person = new Person();
        BeanCopier beanCopier = BeanCopier.create(UserInfo.class,Person.class,false);
        beanCopier.copy(userInfo,person,null);
        long start = System.currentTimeMillis();
        long costTime = System.currentTimeMillis() - start;
        log.info("花费的时间是：{}",costTime);
    }
}
