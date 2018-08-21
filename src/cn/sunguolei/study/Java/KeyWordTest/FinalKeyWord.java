package cn.sunguolei.study.KeyWordTest;

public class FinalKeyWord {
    public static void main(String[] args)  {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println("a=" + System.identityHashCode(a));
        System.out.println("b=" + System.identityHashCode(b));
        System.out.println("c=" + System.identityHashCode(c));
        System.out.println("d=" + System.identityHashCode(d));
        System.out.println("e=" + System.identityHashCode(e));
        System.out.println("a==c 为 " + (a == c));
        System.out.println("b==d 为 " + (b == d));
        System.out.println("a==e 为 " + (a == e));

    }
}