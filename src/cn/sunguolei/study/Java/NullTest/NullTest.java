package cn.sunguolei.study.NullTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SunGuo lei
 * @date 2018/4/28 10:42
 * @description 伐木累
 */
public class NullTest {
    public static void main(String[] args) throws InterruptedException {
        Map numberAndCount = new HashMap<>();
        int[] numbers = {3, 5, 7, 9, 11, 13, 17, 19, 2, 3, 5, 33, 12, 5};

        for (int i : numbers) {
            Integer count = (Integer) numberAndCount.get(i);
            numberAndCount.put(i, count++); // NullPointerException here
        }
    }
}
