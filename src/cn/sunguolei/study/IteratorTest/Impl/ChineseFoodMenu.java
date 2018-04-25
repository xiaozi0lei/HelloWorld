package cn.sunguolei.study.IteratorTest.Impl;

import cn.sunguolei.study.IteratorTest.Iterator;
import cn.sunguolei.study.IteratorTest.Menu;


public class ChineseFoodMenu implements Menu {
    private String[] foods = new String[4];

    private int position = 0;

    @Override
    public void add(String name) {
        foods[position] = name;
        position += 1;
    }

    @Override
    public Iterator getIterator() {
        return new MenuIterator(this.foods);
    }
}
