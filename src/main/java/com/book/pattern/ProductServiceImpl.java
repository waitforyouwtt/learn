package com.book.pattern;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: luoxian
 * @Date: 2020/4/24 18:33
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService{

    @Resource
    @Qualifier("operationAddBaseProduct")
    private StrategyAddProduct operationAddBaseProduct;

    @Resource
    @Qualifier("operationAddTransferProduct")
    private StrategyAddProduct operationAddTransferProduct;

    @Resource
    @Qualifier("operationAddItemProduct")
    private StrategyAddProduct operationAddItemProduct;

    @Override
    public int addProduct(ProductOnline online) {
        log.info("添加商品信息请求参数[咏悦汇]:{}", JSON.toJSONString(online));
        int r = 0;
        try {
            switch (online.getTransformType()) {
                case 1:
                    ContextProduct contextProductBase = new ContextProduct(operationAddBaseProduct);
                    r = contextProductBase.executeStrategy(online);
                    break;
                case 2:
                    ContextProduct contextProductTransfer = new ContextProduct(operationAddTransferProduct);
                    r = contextProductTransfer.executeStrategy(online);
                    break;
                case 3:
                    ContextProduct contextProductItem = new ContextProduct(operationAddItemProduct);
                    r = contextProductItem.executeStrategy(online);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            log.error("创建商品信息失败：{}", e);
            return r;
        }
        return r;
    }
}
