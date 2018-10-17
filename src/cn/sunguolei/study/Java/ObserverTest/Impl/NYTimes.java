package src.cn.sunguolei.study.Java.ObserverTest.Impl;

import src.cn.sunguolei.study.Java.ObserverTest.Observer;

/**
 * @author GuoLei Sun
 * Date: 2018/10/11 6:31 PM
 */
public class NYTimes implements Observer {
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("Breaking news in NY! " + tweet);
        }
    }
}
