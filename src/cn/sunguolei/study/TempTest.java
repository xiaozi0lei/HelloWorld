package src.cn.sunguolei.study;

import java.util.*;


public class TempTest {

    enum Color {RED, BLUE, GREEN}

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("one", "1");
//        int[] a = new int[8];
//        Object obj = a; //数组的父类也是Object,可以将a向上转型到Object
//
////2     那么能向下转型吗?
//        int[] b = (int[]) obj;  //可以进行向下转型
//
////3     能使用instanceof关键字判定吗?
//        if (obj instanceof int[]) {  //可以用instanceof关键字进行类型判定
//            System.out.println("obj的真实类型是int[]");
//        }
//
//        Runtime runtime = Runtime.getRuntime();
//        List<String> list = new ArrayList<>();
//
//        for (String i : list) {
//            System.out.println(i);
//        }
//
////        String[] result = null;
////        String testString = result[0];
////        System.out.println(testString);
//
//        LinkedList linkedList = new LinkedList();
//
//        Hashtable<String, String> hashtable = new Hashtable<>();
//        hashtable.put("hello", "你好");
//
//        System.out.println(hashtable.elements());
//        System.out.println(hashtable.remove("hello"));
//        System.out.println(hashtable.keySet());
//
//
//        String test = "Substitute";
//        String[] temp = test.split(",");
//        System.out.println(Arrays.toString(temp));

        int number = 10;
        //原始数二进制
        printInfo(number);
        number = number << 1;
        //左移一位
        printInfo(number);
        number = number >> 1;
        //右移一位
        printInfo(number);
    }

    /**
     * 输出一个int的二进制数
     *
     * @param num
     */
    private static void printInfo(int num) {
        System.out.println(Integer.toBinaryString(num));
    }
}
