package com.book.pattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/3/21 11:08
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service("operationAddTransferProduct")
public class OperationAddTransferProduct implements StrategyAddProduct {
    @Override
    public int addProductOnlineYyh(ProductOnline online) {
        log.info("添加转标品");
        return 1;
    }
}
