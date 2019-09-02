package com.book.serviceimpl;

import com.book.dao.SourceTableDao;
import com.book.entity.ProductInfo;
import com.book.entity.SourceTable;
import com.book.service.SourceTableService;
import com.book.view.RequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/2 19:11
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class SourceTableServiceImpl implements SourceTableService {

    @Autowired
    SourceTableDao sourceTableDao;
    @Override
    public List<ProductInfo> findList() {
        return sourceTableDao.findList();
    }

    @Override
    public void updateTableColumnToCopy(RequestVO vo) {
        String column = "lengjing";
        log.info( "增加列为:{}",column );
        sourceTableDao.updateTableColumnToCopy( column );
    }

    @Override
    public void updateTableNameToCopy(RequestVO vo){
        String tableName = "product_info"+"copy";
        log.info( "表名字：{}",tableName );
        sourceTableDao.updateTableNameToCopy(tableName);
    }
}
