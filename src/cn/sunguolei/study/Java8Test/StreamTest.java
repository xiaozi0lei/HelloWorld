package cn.sunguolei.study.Java8Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author SunGuo lei
 * @date 2018/4/28 13:03
 * @description 伐木累
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        // Filter 过滤
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

// "aaa2", "aaa1"
        // Sort 排序
        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

// "aaa1", "aaa2"

        System.out.println(stringCollection);
// ddd2, aaa2, bbb1, aaa1, bbb3, ccc, bbb2, ddd1

        // Map 映射
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

// "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"

        // Match 匹配
        boolean anyStartsWithA =
                stringCollection
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA =
                stringCollection
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ =
                stringCollection
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true

        // Count 计数
        long startsWithB =
                stringCollection
                        .stream()
                        .filter((s) -> s.startsWith("b"))
                        .count();

        System.out.println(startsWithB);    // 3

        // Reduce 规约
        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);
// "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"

        // 并行Streams
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        // 串行排序
        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));

// 串行耗时: 899 ms

        // 并行排序
        long t2 = System.nanoTime();

        long count1 = values.parallelStream().sorted().count();
        System.out.println(count1);

        long t3 = System.nanoTime();

        long millis1 = TimeUnit.NANOSECONDS.toMillis(t3 - t2);
        System.out.println(String.format("parallel sort took: %d ms", millis1));

// 并行排序耗时: 472 ms
    }
}
