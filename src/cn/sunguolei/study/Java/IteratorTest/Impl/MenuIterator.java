package cn.sunguolei.study.IteratorTest.Impl;

import cn.sunguolei.study.IteratorTest.Iterator;

public class MenuIterator implements Iterator {

    String[] foods;
    int      position = 0;

    public MenuIterator(String[] foods){
        this.foods = foods;
    }

    @Override
    public boolean hasNext() {
        return position != foods.length;
    }

    @Override
    public Object next() {
        String food = foods[position];
        position += 1;
        return food;
    }
}
