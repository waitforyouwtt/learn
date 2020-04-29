package com.book;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
}
