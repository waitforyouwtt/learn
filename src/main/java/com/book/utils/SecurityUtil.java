package com.book.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.IOUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author${罗显}
 * @date 2018/12/6
 * @time 15:46
 */
public class SecurityUtil {

    private static final String ALGORITHM_RSA = "RSA";
    private static final int ALGORITHM_RSA_PRIVATE_KEY_LENGTH = 2048;

    /***
     * MD5 加密
     */
    public static String MD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes("UTF-8"));
            byte[] digest = md5.digest();
            StringBuffer hexString = new StringBuffer();
            String strTemp;
            for (int i = 0; i < digest.length; i++) {
                strTemp = Integer.toHexString((digest[i] & 0x000000FF) | 0xFFFFFF00).substring(6);
                hexString.append(strTemp);
            }
            return hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    // ==Base64加解密==================================================================

    /**
     * Base64加密
     */
    public static String base64Encode(String str) {
        try {
            return Encodes.encodeBase64(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    /**
     * 解密
     */
    public static String base64Decode(String str) {
        try {
            return new String(Encodes.decodeBase64(str), "UTF-8");
        } catch (IOException e) {
            return "";
        }
    }

    // ==Aes加解密==================================================================

    /**
     * aes解密-128位
     */
    public static String aesDecrypt(String encryptContent, String password) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(password) || password.length() != 16) {
            throw new RuntimeException("密钥长度为16位");
        }
        try {
            String key = password;
            String iv = password;
            byte[] encrypted1 = hex2Bytes(encryptContent);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted1);
            return new String(original, "UTF-8").trim();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("aes解密发生错误", e);
        }
    }

    /**
     * aes加密-128位
     */
    public static String aesEncrypt(String content, String key) {
        if (StringUtils.isEmpty(key) || key.length() != 16) {
            throw new RuntimeException("密钥长度为16位");
        }
        try {
            String iv = key;
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = content.getBytes("utf-8");
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return byte2Hex(encrypted);

        } catch (Exception e) {
            throw new RuntimeException("aes加密发生错误", e);
        }
    }


    /**
     * 将byte[] 转换成字符串
     */
    public static String byte2Hex(byte[] srcBytes) {
        StringBuilder hexRetSB = new StringBuilder();
        for (byte b : srcBytes) {
            String hexString = Integer.toHexString(0x00ff & b);
            hexRetSB.append(hexString.length() == 1 ? 0 : "").append(hexString);
        }
        return hexRetSB.toString();
    }

    /**
     * 将16进制字符串转为转换成字符串
     */
    public static byte[] hex2Bytes(String source) {
        byte[] sourceBytes = new byte[source.length() / 2];
        for (int i = 0; i < sourceBytes.length; i++) {
            sourceBytes[i] = (byte) Integer.parseInt(source.substring(i * 2, i * 2 + 2), 16);
        }
        return sourceBytes;
    }

    /**
     * DES加密
     */
    public static String desEncrypt(String source, String desKey) throws Exception {
        try {
            // 从原始密匙数据创建DESKeySpec对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(new DESKeySpec(desKey.getBytes()));
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey);
            // 现在，获取数据并加密
            byte[] destBytes = cipher.doFinal(source.getBytes());
            StringBuilder hexRetSB = new StringBuilder();
            for (byte b : destBytes) {
                String hexString = Integer.toHexString(0x00ff & b);
                hexRetSB.append(hexString.length() == 1 ? 0 : "").append(hexString);
            }
            return hexRetSB.toString();
        } catch (Exception e) {
            throw new Exception("DES加密发生错误", e);
        }
    }

    /**
     * DES解密
     */
    public static String desDecrypt(String source, String desKey) throws Exception {
        // 解密数据
        byte[] sourceBytes = new byte[source.length() / 2];
        for (int i = 0; i < sourceBytes.length; i++) {
            sourceBytes[i] = (byte) Integer.parseInt(source.substring(i * 2, i * 2 + 2), 16);
        }
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(new DESKeySpec(desKey.getBytes()));
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey);
            // 现在，获取数据并解密
            byte[] destBytes = cipher.doFinal(sourceBytes);
            return new String(destBytes);
        } catch (Exception e) {
            throw new Exception("DES解密发生错误", e);
        }
    }

    /**
     * 3DES加密
     */
    public static byte[] threeDesEncrypt(byte[] src, byte[] keybyte) throws Exception {
        try {
            // 生成密钥
            byte[] key = new byte[24];
            if (keybyte.length < key.length) {
                System.arraycopy(keybyte, 0, key, 0, keybyte.length);
            } else {
                System.arraycopy(keybyte, 0, key, 0, key.length);
            }
            SecretKey deskey = new SecretKeySpec(key, "DESede");
            // 加密
            Cipher c1 = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (Exception e) {
            throw new Exception("3DES加密发生错误", e);
        }
    }

    /**
     * 3DES解密
     */
    public static byte[] threeDesDecrypt(byte[] src, byte[] keybyte) throws Exception {
        try {
            // 生成密钥
            byte[] key = new byte[24];
            if (keybyte.length < key.length) {
                System.arraycopy(keybyte, 0, key, 0, keybyte.length);
            } else {
                System.arraycopy(keybyte, 0, key, 0, key.length);
            }
            SecretKey deskey = new SecretKeySpec(key, "DESede");
            // 解密
            Cipher c1 = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (Exception e) {
            throw new Exception("3DES解密发生错误", e);
        }
    }

    /**
     * 3DES加密
     */
    public static String threeDesEncrypt(String src, String key) throws Exception {
        return byte2Hex(threeDesEncrypt(src.getBytes(), key.getBytes()));
    }

    /**
     * 3DES加密
     */
    public static String threeDesDecrypt(String src, String key) throws Exception {
        return new String(threeDesDecrypt(hex2Bytes(src), key.getBytes()));
    }


    /**
     * sha1计算后进行16进制转换
     *
     * @param data     待计算的数据
     * @param encoding 编码
     * @return 计算结果
     * @throws UnsupportedEncodingException
     */
    public static String sha1X16(String data, String encoding) {
        try {
            byte[] bytes = sha1(data.getBytes(encoding));
            return byte2Hex(bytes);
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    /**
     * sha1计算.
     *
     * @param data 待计算的数据
     * @return 计算结果
     */
    public static byte[] sha1(byte[] data) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            md.reset();
            md.update(data);
            return md.digest();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * RSA算法分段加解密数据
     */
    private static byte[] rsaSplitCodec(Cipher cipher, int opmode, byte[] datas) {
        int maxBlock = 0;
        if (opmode == Cipher.DECRYPT_MODE) {
            maxBlock = ALGORITHM_RSA_PRIVATE_KEY_LENGTH / 8;
        } else {
            maxBlock = ALGORITHM_RSA_PRIVATE_KEY_LENGTH / 8 - 11;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] buff;
        int i = 0;
        try {
            while (datas.length > offSet) {
                if (datas.length - offSet > maxBlock) {
                    buff = cipher.doFinal(datas, offSet, maxBlock);
                } else {
                    buff = cipher.doFinal(datas, offSet, datas.length - offSet);
                }
                out.write(buff, 0, buff.length);
                i++;
                offSet = i * maxBlock;
            }
        } catch (Exception e) {
            throw new RuntimeException("加解密阀值为[" + maxBlock + "]的数据时发生异常", e);
        }
        byte[] resultDatas = out.toByteArray();
        IOUtils.closeQuietly(out);
        return resultDatas;
    }


    /**
     * RSA算法公钥加密数据
     *
     * @param data 待加密的明文字符串
     * @param key  RSA公钥字符串
     * @return RSA公钥加密后的经过Base64编码的密文字符串
     */
    public static String buildRSAEncryptByPublicKey(String data, String key) {
        try {
            //通过X509编码的Key指令获得公钥对象
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(key));
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
            Key publicKey = keyFactory.generatePublic(x509KeySpec);
            //encrypt
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            //return Base64.encodeBase64URLSafeString(cipher.doFinal(data.getBytes(CHARSET)));
            return Base64.encodeBase64URLSafeString(rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE,
                    data.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
        }
    }

    /**
     * RSA算法私钥加密数据
     *
     * @param data 待加密的明文字符串
     * @param key  RSA私钥字符串
     * @return RSA私钥加密后的经过Base64编码的密文字符串
     */
    public static String buildRSAEncryptByPrivateKey(String data, String key) {
        try {
            //通过PKCS#8编码的Key指令获得私钥对象
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(key));
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
            Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
            //encrypt
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            //return Base64.encodeBase64URLSafeString(cipher.doFinal(data.getBytes(CHARSET)));
            return Base64.encodeBase64URLSafeString(rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
        }
    }



    /**
     * RSA算法公钥解密数据
     *
     * @param data 待解密的经过Base64编码的密文字符串
     * @param key  RSA公钥字符串
     * @return RSA公钥解密后的明文字符串
     */
    public static String buildRSADecryptByPublicKey(String data, String key) {
        try {
            //通过X509编码的Key指令获得公钥对象
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(key));
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
            Key publicKey = keyFactory.generatePublic(x509KeySpec);
            //decrypt
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            //return new String(cipher.doFinal(Base64.decodeBase64(data)), CHARSET);
            return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.decodeBase64(data)), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
        }
    }


    /**
     * RSA算法私钥解密数据
     *
     * @param data 待解密的经过Base64编码的密文字符串
     * @param key  RSA私钥字符串
     * @return RSA私钥解密后的明文字符串
     */
    public static String buildRSADecryptByPrivateKey(String data, String key) {
        try {
            //通过PKCS#8编码的Key指令获得私钥对象
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(key));
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
            Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
            //decrypt
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            //return new String(cipher.doFinal(Base64.decodeBase64(data)), CHARSET);
            return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.decodeBase64(data)), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
        }
    }

}
