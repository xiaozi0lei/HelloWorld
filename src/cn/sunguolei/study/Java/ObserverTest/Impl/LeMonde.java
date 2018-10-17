package src.cn.sunguolei.study.Java.ObserverTest.Impl;

import src.cn.sunguolei.study.Java.ObserverTest.Observer;

/**
 * @author GuoLei Sun
 * Date: 2018/10/11 6:32 PM
 */
public class LeMonde implements Observer {
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("wine")) {
            System.out.println("Today cheese, wine and news! " + tweet);
        }
    }
}
