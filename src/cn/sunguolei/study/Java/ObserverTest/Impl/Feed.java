package src.cn.sunguolei.study.Java.ObserverTest.Impl;

import src.cn.sunguolei.study.Java.ObserverTest.Observer;
import src.cn.sunguolei.study.Java.ObserverTest.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GuoLei Sun
 * Date: 2018/10/11 6:33 PM
 */
public class Feed implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }
}