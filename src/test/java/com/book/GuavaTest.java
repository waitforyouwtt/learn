package com.book;

import com.book.entity.UserInfo;
import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: luoxian
 * @Date: 2020/5/8 15:40
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class GuavaTest  extends LearnApplicationTests{

    @Test
    public void guavaTest(){
        List<UserInfo> userInfoList  = Arrays.asList(new UserInfo("小明"),new UserInfo("小红"));
        String join = Joiner.on(" ").join(userInfoList.stream().map(UserInfo::getUserName).collect(Collectors.toList()));
        log.info("guava listToString：{}",join);
    }
}
