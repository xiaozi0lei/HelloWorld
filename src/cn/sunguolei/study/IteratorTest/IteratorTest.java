package cn.sunguolei.study.IteratorTest;

import cn.sunguolei.study.IteratorTest.Impl.ChineseFoodMenu;

/**
 * 迭代器模式练习
 */
public class IteratorTest {
    public static void main(String[] args) {
        Menu chineseFoodMenu = new ChineseFoodMenu();
        chineseFoodMenu.add("guolei0");
        chineseFoodMenu.add("guolei1");
        chineseFoodMenu.add("guolei2");
        chineseFoodMenu.add("guolei3");

        Iterator iterator = chineseFoodMenu.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
