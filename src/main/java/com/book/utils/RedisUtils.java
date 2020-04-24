package com.book.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/26 15:44
 * @Email: 15290810931@163.com
 */
@Repository
public class RedisUtils {

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 操作字符串
     */
    public void setKey(String key, String value) {
        ValueOperations<String, String > ops = template.opsForValue();
        ops.set(key,value,1, TimeUnit.MINUTES);
    }

    /**
     * 根据key 获取value 值
     * @param key
     * @return
     */
    public String getValue(String key) {
        ValueOperations<String, String> ops = this.template.opsForValue();
        return ops.get(key);
    }


}
