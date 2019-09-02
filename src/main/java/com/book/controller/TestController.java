package com.book.controller;

import com.book.entity.UserInfo;
import com.book.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 一点点
 * @Date: 2019/1/29 21:35
 * @Version 1.0
 */
@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserInfoService userInfoService;

}
