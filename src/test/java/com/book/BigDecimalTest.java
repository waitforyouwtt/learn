package com.book;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @Author: luoxian
 * @Date: 2020/4/24 18:49
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class BigDecimalTest extends LearnApplicationTests{

    @Test
    public void compareZeroToTest(){
        BigDecimal number = new BigDecimal("-3.33");

        if (number.compareTo(BigDecimal.ZERO) == 0){
            log.info("等于");
        }else if(number.compareTo(BigDecimal.ZERO) == 1){
            log.info("大于");
        }else if(number.compareTo(BigDecimal.ZERO) == -1) {
            log.info("小于");
        }
    }

    @Test
    public void multiplyTest(){
        BigDecimal price = BigDecimal.valueOf(10.23);
        BigDecimal amount = price.multiply(BigDecimal.valueOf(100));
        int productPrice = amount.intValue();
        System.out.println("bigDecimal乘积："+productPrice);
    }

    @Test
    public void subtractTest(){
        BigDecimal lastAmount = new BigDecimal(18929.69);
        BigDecimal thisAmount = new BigDecimal(18783.98);
        BigDecimal subtract = lastAmount.subtract(thisAmount).setScale(3,BigDecimal.ROUND_UP);
        log.info("bigDecimal差额：{}",subtract);
    }

    @Test
    public void retainNumberTest(){
        Double number = 7832.5675789;
        DecimalFormat decimalFormat = new DecimalFormat("#.000");
        log.info("四舍五入保留三位小数：{}",decimalFormat.format(number));
    }

    @Test
    public void bigDecimalgetTest(){
        BigDecimal decimal = new BigDecimal("1.12345");
        String setScale = decimal.setScale(2,BigDecimal.ROUND_DOWN).toString();
        log.info("金额保留2位小数："+setScale);

        Integer discountPrice = 2;
        Integer oldSellingPrice = 2;
        DecimalFormat df = new DecimalFormat("###.#");
        BigDecimal discountRate =  new BigDecimal(discountPrice).multiply(new BigDecimal(10)).divide(new BigDecimal(oldSellingPrice),1,BigDecimal.ROUND_DOWN);
        log.info(" bigDecimal 先乘积，再除以，再保留1位小数：{}",df.format(discountRate));

       /*
        BigDecimal setScale1 = decimal.setScale(4,BigDecimal.ROUND_HALF_UP);
        System.out.println(setScale1);*/
    }

}
