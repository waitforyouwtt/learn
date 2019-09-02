package com.book.service;

import com.book.entity.ProductInfo;
import com.book.entity.SourceTable;
import com.book.view.RequestVO;

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
}
