package com.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: luoxian
 * @Date: 2020/5/20 13:51
 * @Email: 15290810931@163.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    private String userName;

    private Integer age;

    private Date birthday;


}
