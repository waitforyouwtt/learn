package com.book.pattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/3/21 11:10
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service(value = "operationAddItemProduct")
public class OperationAddItemProduct implements StrategyAddProduct {

    @Override
    public int addProductOnlineYyh(ProductOnline online) {
        log.info("添加组合商品");
        return 1;
    }
}
