package com.code.jdk.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.util.comparator.ComparableComparator;

/**
 * @author tianwei
 * @since 2019-10-29 10:54 上午
 */
public class LambdaDemo {

    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println("hello world");
            System.out.println("hello world");
        };
        new Thread(r).start();

        //Old way:
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        for (Integer n : list) {
            System.out.println(n);
        }
        list.forEach(n -> System.out.println(n));
        //or we can use :: double colon operator in Java 8
        list.forEach(System.out::println);
        list.forEach(n -> System.out.println(n));
        list.stream().map((x) -> x * x).forEach(System.out::println);

        //大于5的
        System.out.println(list.stream().filter(e -> e > 5).collect(Collectors.toList()));
        //前3个
        System.out.println(list.stream().limit(3).collect(Collectors.toList()));
        //跳过前3个
        System.out.println(list.stream().skip(3).collect(Collectors.toList()));
        //最大
        System.out.println(list.stream().max(new ComparableComparator()).get());
        //计数
        System.out.println(list.stream().count());
        //排序
        System.out.println(list.stream().sorted((p1, p2) -> p2.compareTo(p1)).collect(
            (Collector<? super Integer, Object, TreeSet<Object>>)Collectors.toCollection(TreeSet::new)));
    }
}
