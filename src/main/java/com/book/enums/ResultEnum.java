package com.book.enums;

import com.google.common.collect.Lists;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 一点点
 * @Date: 2018/10/4 14:15
 * @Version 1.0
 */
public enum ResultEnum {

     JOBNUMER_OR_IDCARD_NULL(1000,"工号或者身份证号为空"),
     JOBNUMER_OR_IDCARD_ERROR(1001,"证件号不正确"),
     PARAMETER_ERROR(1003,"系统参数错误"),
     FILE_IS_NOT_EXCEL(1004,"文件不是Excel"),
     DATA_IS_NULL(1005,"数据为空，请填写数据"),
    USERNAME_IS_ERROR(1006,"用户名错误"),
    PASSWORD_IS_ERROR(1007,"密码错误");
     Integer code;
     String message;
    ResultEnum(Integer code, String message){
       this.code = code;
       this.message = message;
    }

    private static final Map<Integer, ResultEnum> valueLookup = new ConcurrentHashMap<>(values().length);

    static {
        for (ResultEnum type : EnumSet.allOf(ResultEnum.class)) {
            valueLookup.put(type.code, type);
        }
    }

    public static ResultEnum resolve(Integer value) {

        return (value != null ? valueLookup.get(value) : null);
    }

    public static ResultEnum fromValue(Integer value) {
        ResultEnum data = valueLookup.get(value);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + value + "]不正确，没有找到对应的Enum");
        }
        return data;
    }

    //将枚举转换成list格式，这样前台遍历的时候比较容易，列如 下拉框 后台调用toList方法，便可以得到code 和name
    public static List<Map> typeEnumList() {
        //javac通过自动推导尖括号里的数据类型.
        List list = Lists.newArrayList();
        for (ResultEnum airlineTypeEnum : ResultEnum.values()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", airlineTypeEnum.getCode());
            map.put("name", airlineTypeEnum.getMessage());
            list.add(map);
        }
        return list;
    }

    /**
     * 获取枚举的所有code
     * @return
     */
    public static List enumCodeList(){
        List list = Lists.newArrayList();
        for (ResultEnum airlineTypeEnum : ResultEnum.values()) {
            list.add(airlineTypeEnum.getCode());
        }
        return list;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
