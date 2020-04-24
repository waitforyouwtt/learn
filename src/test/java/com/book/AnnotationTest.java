package com.book;

import com.book.annotation.PersonService;
import com.book.annotation.PersonVO;
import com.book.pattern.ProductOnline;
import com.book.pattern.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: luoxian
 * @Date: 2020/4/24 18:16
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class AnnotationTest extends LearnApplicationTests{

    @Autowired
    PersonService personService;

    @Autowired
    ProductService productService;

    @Test
    public void AnnotationTest(){
        PersonVO person = new PersonVO();
        person.setId(1);
        person.setUserName("张杰");
        person.setGender(1);

        int i = personService.savePerson(person);
        log.info("得到的结果：{}",i);
    }

    @Test
    public void designTest(){
        ProductOnline online = new  ProductOnline();
        online.setTransformType((byte)2);
        online.setProductName("商品名称");
        productService.addProduct(online);
    }
}
