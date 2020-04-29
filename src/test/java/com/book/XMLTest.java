package com.book;

import com.book.utils.XMLUtil;
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
public class XMLTest extends LearnApplicationTests {

    @Test
    public void xmlTest(){
        Object o = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<alipay>\n" +
                "\n" +
                "<is_success>F</is_success>\n" +
                "<error>PURCHASE_TRADE_NOT_EXIST</error>\n" +
                "\n" +
                "<sign>QZRPvccyWUzKF+fz6K7tQJdDzfe84kxwuY/InI9g6/Lb9Uh9ltDGfkCVAhYMSLxOHcvdBY691S6CzwfBAiTHP36xu3m3H667f5PDacJ+uzPBCKjsRO4KBVU3zgxA0BNzD2ITRykdck3pFoaMz1ELhFbMMzYGngwq0vxosEFsV+6hh64pnxtzcbgWGod4mq76zN5kcsue7dAOF3d5JGrvqdAYTwIw+n8xTXQuHtEydxNiy9acm9i3we6USauJ7tFOyFWrofvc7up0NvaR+cdsh/0NstcA+3ZoYCu+mDozaSHUP2N4QUq1KSXJvdUDPlWRuzgudSFDC5pe1jFXiLQWGQ==</sign>\n" +
                "\n" +
                "<sign_type>RSA2</sign_type>\n" +
                "\n" +
                "</alipay>\n";
        String isSuccess = XMLUtil.getXMLValue(o,"is_success");
        log.info("is_success:{}",isSuccess);
    }
}
