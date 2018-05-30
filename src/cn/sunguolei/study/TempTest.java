package cn.sunguolei.study;

import java.util.*;


public class TempTest {

    enum Color {RED, BLUE, GREEN}

    public static void main(String[] args) {
        int[] a = new int[8];
        Object obj = a; //数组的父类也是Object,可以将a向上转型到Object

//2     那么能向下转型吗?
        int[] b = (int[]) obj;  //可以进行向下转型

//3     能使用instanceof关键字判定吗?
        if (obj instanceof int[]) {  //可以用instanceof关键字进行类型判定
            System.out.println("obj的真实类型是int[]");
        }

        Runtime runtime = Runtime.getRuntime();
        List<String> list = new ArrayList<>();

        for (String i : list) {
            System.out.println(i);
        }

        String[] result = null;
        String testString = result[0];
        System.out.println(testString);

    }
}
