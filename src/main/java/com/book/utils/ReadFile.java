package com.book.utils;

import com.book.entity.ContinentRepaymentPlan;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author${罗显}
 * @date 2018/12/10
 * @time 10:59
 */
public class ReadFile {

    private Logger logger = LoggerFactory.getLogger(ReadFile.class);

    /**
     * 使用FileReader实现将文本文件读取至一维数组
     * @param name
     * @return
     */
    public static String[] toArrayByFileReader(String name) {
        // 使用ArrayList来存储每行读取到的字符串
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            FileReader fr = new FileReader(name);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 对ArrayList中存储的字符串进行处理
        int length = arrayList.size();
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            String s = arrayList.get(i);
            array[i] = s;
        }
        // 返回数组
        return array;
    }

    /**
     * 用InputStreamReader方式：
     * @param name
     * @return
     */
    public static String[] toArrayByInputStreamReader(String name) {
        // 使用ArrayList来存储每行读取到的字符串
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            File file = new File(name);
            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bf = new BufferedReader(inputReader);
            // 按行读取字符串
            String str;
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            inputReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对ArrayList中存储的字符串进行处理
        int length = arrayList.size();
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            String s = arrayList.get(i);
            array[i] = s;
        }
        // 返回数组
        return array;
    }

    /**
     * 使用RandomAccessFile方式：
     * @param name
     * @return
     */
    public static String[] toArrayByRandomAccessFile(String name) {
        // 使用ArrayList来存储每行读取到的字符串
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            File file = new File(name);
            RandomAccessFile fileR = new RandomAccessFile(file,"r");
            // 按行读取字符串
            String str = null;
            while ((str = fileR.readLine())!= null) {
                arrayList.add(str);
            }
            fileR.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对ArrayList中存储的字符串进行处理
        int length = arrayList.size();
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            String s = arrayList.get(i);
            array[i] = s;
        }
        // 返回数组
        return array;
    }

    @Test
    public  void main2() {
        String fileName = "E:\\putong\\Multiple file uploads\\src\\main\\java\\com\\book\\util\\HA007_20190604.txt";
        String[] result = toArrayByFileReader(fileName);
        String replace;
        String[] strSplit;
        ContinentRepaymentPlan plan = new ContinentRepaymentPlan();
        for (String s: result){
            replace = s.replace("@|@"," ");
            strSplit = replace.split(" ");
            plan.setLoanId(strSplit[0]);
            plan.setTerm(Integer.parseInt(strSplit[1]));
            plan.setShouldPayDate(strSplit[2]);
            plan.setShouldPayAmount(new BigDecimal(strSplit[3]));
            plan.setShouldPayInterest(new BigDecimal(strSplit[4]));
            plan.setShouldPayPenaltyInterest(new BigDecimal(strSplit[5]));
            plan.setShouldPayCompoundInterest(new BigDecimal(strSplit[6]));
            plan.setActualPayDate(strSplit[7]);
            plan.setRealRepayPrincipal(new BigDecimal(strSplit[8]));
            plan.setRealRepayProfit(new BigDecimal(strSplit[9]));
            plan.setRealFinedInterest(new BigDecimal(strSplit[10]));
            plan.setRealCompoundInterest(new BigDecimal(strSplit[11]));
            logger.info("解析文件得到的结果是{}",plan.toString());
        }
    }

}
