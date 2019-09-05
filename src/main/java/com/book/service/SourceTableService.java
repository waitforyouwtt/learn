package com.book.service;

import com.book.entity.ProductInfo;
import com.book.entity.SourceTable;
import com.book.view.RequestVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/2 19:10
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public interface SourceTableService {

    List<ProductInfo> findList();

    void updateTableColumnToCopy(RequestVO vo);

    void updateTableNameToCopy(RequestVO vo);

    void createTableCopy(RequestVO vo);

    void updateSynchroBatchById(@Param("vos") List<String> ids);

}
