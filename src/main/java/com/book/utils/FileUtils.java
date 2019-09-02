package com.book.utils;

import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

/**
 * @author${罗显}
 * @date 2018/12/6
 * @time 15:53
 */
public class FileUtils {
    private static Logger log = LoggerFactory.getLogger(FileUtils.class);
    /**
     * 下载远程文件保存并读取 网络地址
     */
    public static String downAndReadFile(String filePath) throws IOException {
        log.info("开始下载读取文件");
        URL url = new URL(filePath);
        HttpURLConnection uc = (HttpURLConnection) url.openConnection();
        //设置是否要从 URL 连接读取数据,默认为true
        uc.setDoInput(true);
        uc.connect();
        try(InputStream iputstream = uc.getInputStream()) {
            byte[] res = IOUtils.toByteArray(iputstream);
            uc.disconnect();
            return Base64.getEncoder().encodeToString(res);
        }

    }
}
