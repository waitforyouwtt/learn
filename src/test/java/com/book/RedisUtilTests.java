package com.book;

import com.book.utils.DateUtil;
import com.book.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilTests {

	@Autowired
	RedisUtils redisUtils;

	@Test
	public void redisTest() {
		DateUtil.getDateForDayBefor(15,"yyyy-MM-dd");
	}

}
