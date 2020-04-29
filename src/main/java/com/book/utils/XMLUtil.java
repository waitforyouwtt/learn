package com.book.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: luoxian
 * @Date: 2020/4/29 15:57
 * @Email: 15290810931@163.com
 */
@Slf4j
public class XMLUtil {

    /**
     * 解析xml
     * @param xml
     * @param key
     * @return
     */
    public static String getXMLValue(Object xml, String key){
        String value = "";
        if (xml != null) {
            String data = xml.toString();
            if (data.contains(key)) {
                String keyStart = new StringBuffer("<").append(key).append(">").toString();
                String keyEnd = new StringBuffer("</").append(key).append(">").toString();
                value = data.substring(data.indexOf(keyStart), data.indexOf(keyEnd)).replace(keyStart, "");
                log.info("读取XML返回的参数value:"+value);
            }
        }
        return value;
    }
}
