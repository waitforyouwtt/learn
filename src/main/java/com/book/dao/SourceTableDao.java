package com.book.dao;

import com.book.entity.ProductInfo;
import com.book.entity.SourceTable;
import com.book.view.RequestVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/2 19:13
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Mapper
public interface SourceTableDao {

    List<ProductInfo> findList();

    void updateTableColumnToCopy(@Param( "column" ) String column);

    void updateTableNameToCopy(@Param( "tableName" ) String tableName);

    void createTable(@Param( "tableName" ) String tableName);

    void updateSynchroBatchById(@Param("vos") List<String> ids);
}
