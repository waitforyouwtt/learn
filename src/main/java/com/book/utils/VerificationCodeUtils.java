package com.book.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 一点点
 * @Date: 2018/10/20 23:47
 * @Version 1.0
 */
public class VerificationCodeUtils {
    /**
     * 生成二维码方法
     *
     * @param url  访问链接
     * @param resp response对象
     * @throws Exception 抛出异常
     */
    public void getQrcode(String url, HttpServletResponse resp) throws Exception {
        ServletOutputStream stream = null;
        try {
            stream = resp.getOutputStream();
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bm = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 30, 30);
            MatrixToImageWriter.writeToStream(bm, "png", stream);
        } catch (WriterException e) {
            e.getStackTrace();
        } finally {
            if (stream != null) {
                stream.flush();
                stream.close();
            }
        }
    }

}
