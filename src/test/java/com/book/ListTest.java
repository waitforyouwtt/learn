package com.book;

import com.book.entity.Person;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: luoxian
 * @Date: 2020/4/29 16:57
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class ListTest extends LearnApplicationTests{


    @Test
    public  void listMethod(){
        List<String> list1 = Arrays.asList("a","b","c","d","a");
        List<String> list2 = Arrays.asList("c","d","e","f");
        Set<String> setOne = new HashSet<>(list1);
        Set<String> setTwo = new HashSet<>(list2);
        //交集
        Sets.SetView<String> intersection = Sets.intersection(setOne, setTwo);
        List<String> intersectionList = intersection.parallelStream().collect(Collectors.toList());
        log.info("集合list的交集数据：{}",intersectionList);

        //差集
        Sets.SetView<String> diff = Sets.difference(setOne, setTwo);
        List<String> differenceList = diff.parallelStream().collect(Collectors.toList());
        log.info("集合list的差集数据：{}",differenceList);

        //并集
        Sets.SetView<String> union =Sets.union(setOne, setTwo);
        List<String> unionList = union.parallelStream().collect(Collectors.toList());
        log.info("集合list的并集数据：{}",unionList);
    }

    @Test
    public void stringbuilder(){
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setUserName("张三");
        person.setAge(20);

        Person person1 = new Person();
        person1.setUserName("李四");
        person1.setAge(25);

        personList.add(person);
        personList.add(person1);

        personList.sort(Comparator.comparing(Person::getAge).reversed());
        log.info("sb:{}");
    }

    private String StringBufferOne(List<Person> personList){
        if (org.springframework.util.CollectionUtils.isEmpty(personList)) {
            return StringUtils.EMPTY;
        }
        StringBuffer sb = new StringBuffer();
        for (Person person : personList) {
                sb.append("|").append(person.getUserName()).append("^").append(person.getAge());
        }
        return sb.length() > 0 ? sb.toString().substring(1) : "";
    }

    private String stringBufferTwo(List<Person> personList){

        StringBuffer sb = new StringBuffer();

        for(int i = 0 ; i < personList.size();i++){
            Person  person = personList.get(i);
            sb.append(person.getUserName());
            sb.append("^");
            sb.append(person.getAge());
            if(i <personList.size()-1  ){
                sb.append("|");
            }
        }
        return sb.toString();
    }
}
