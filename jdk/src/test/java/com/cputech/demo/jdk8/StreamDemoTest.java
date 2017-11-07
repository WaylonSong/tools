package com.cputech.demo.jdk8;

import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by song on 2017/9/23.
 */
public class StreamDemoTest {
    //    https://my.oschina.net/luoyezhuifeng/blog/798212
    @Test
    public void testPeek(){
        List<String> stringList1 = Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
                .peek(e -> {System.out.println("Filtered value: " + e);})
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        System.out.println(stringList1);

        List<String> stringList2 = Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        Optional<String> string = Stream.of("one", "two", "three", "four").findAny();
        System.out.println(string);

    }

    @Test
    public void testReduce(){
        Integer total = Stream.of(2,1,3,4,5).reduce( (x, y) -> x +y).get();
        System.out.println(total);
        Integer total2 = Stream.of(2,1,3,4,5).reduce(2, (x, y) -> x +y);
        System.out.println(total2);
    }
}