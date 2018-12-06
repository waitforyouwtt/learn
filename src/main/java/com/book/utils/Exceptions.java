package com.book.utils;

/**
 * @author${罗显}
 * @date 2018/12/6
 * @time 15:49
 */
public class Exceptions {
    public static RuntimeException unchecked(Throwable ex) {
        if (ex instanceof RuntimeException) {
            return (RuntimeException) ex;
        } else {
            return new RuntimeException(ex);
        }
    }
}
