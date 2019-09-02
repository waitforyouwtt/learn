package com.book.dao;

import com.book.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 一点点
 * @Date: 2018/10/2 15:54
 * @Version 1.0
 */
@Mapper
public interface UserInfoDao {
    /**
     * 批量导入数据
     * @param
     */
    void batchInsert(List<UserInfo> userInfoList);

    void addUserInfo(UserInfo userInfo);

    UserInfo findUser(String userId);
}
