package com.cputech.demo.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by song on 2017/9/23.
 */
public class StreamDemo {
//    https://my.oschina.net/luoyezhuifeng/blog/798212
    public static void main(String args[]){
        List<String> l = Stream.of("a","b","c","b").distinct().collect(Collectors.toList());
        System.out.println(l);
        List<Integer> l2 = IntStream.range(1,10).filter(i -> i % 2 == 0).boxed().collect(Collectors.toList());
        System.out.println(l2);
        /*
        * map方法将流中的元素映射成另外的值，新的值类型可以和原来的元素的类型不同。
作用就是把 input Stream 的每一个元素，映射成 output Stream 的另外一个元素。
下面的代码中将字符元素映射成它的哈希码(ASCII值)。
        * */
        List<Integer> l3 = Stream.of('a','b','c').map( c -> c.hashCode()).collect(Collectors.toList());
        System.out.println(l3);

        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        List<Integer> outputList = inputStream.flatMap((childList) -> childList.stream())
                .collect(Collectors.toList());
        System.out.println(outputList);

//        peek 对每个元素执行操作并返回一个新的 Stream

        Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());



        Integer total = Stream.of(2,1,3,4,5).reduce( (x, y) -> x +y).get();
        System.out.println(total);
        Integer total2 = Stream.of(2,1,3,4,5).reduce(2, (x, y) -> x +y);
        System.out.println(total2);


        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));

        long t2 = System.nanoTime();
        long count2 = values.parallelStream().sorted().count();
        System.out.println(count2);
        long t3 = System.nanoTime();
        long millis2 = TimeUnit.NANOSECONDS.toMillis(t3 - t2);
        System.out.println(String.format("parallel sort took: %d ms", millis2));
    }

}
