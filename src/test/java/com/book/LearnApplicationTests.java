package com.book;

import com.book.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnApplicationTests {

	@Autowired
	UserInfoService userInfoService;
	@Test
	public void queryUser(){
		String userId = "0111";
		String result = userInfoService.findUser(userId);
		System.out.println("得到的结果："+result);
	}

	@Test
	public void contextLoads() {

	}

}
