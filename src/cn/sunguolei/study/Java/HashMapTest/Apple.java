package cn.sunguolei.study.HashMapTest;

import java.util.HashMap;

public class Apple {
    private String color;

    public Apple(String color) {
        this.color = color;
    }

    public boolean equals(Object obj) {
        if(obj==null) return false;
        if (!(obj instanceof Apple))
            return false;
        if (obj == this)
            return true;
        return this.color.equals(((Apple) obj).color);
    }

    // 该类主要取决于 hashCode 方法是否重写
    // 1. 如果注释掉这个方法，会造成 HashMap 在 put 时按照自己的 hash 算法计算 hash 值
    // 2. 如果使用该方法，HashMap 在 put 时会直接取该类存在的 hash 值，作为 hash 值查找
    // 3. HashMap 在存取值时都是根据 hash 值查找对应的记录
    public int hashCode() {
        return this.color.hashCode();
    }

    public static void main(String[] args) {
        Apple a1 = new Apple("green");
        Apple a2 = new Apple("red");

        //hashMap stores apple type and its quantity
        HashMap<Apple, Integer> m = new HashMap<Apple, Integer>();
        m.put(a1, 10);
        m.put(a2, 20);
        System.out.println(m.get(new Apple("green")));
    }
}