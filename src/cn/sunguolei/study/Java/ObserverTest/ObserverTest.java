package src.cn.sunguolei.study.Java.ObserverTest;

import src.cn.sunguolei.study.Java.ObserverTest.Impl.Feed;
import src.cn.sunguolei.study.Java.ObserverTest.Impl.Guardian;
import src.cn.sunguolei.study.Java.ObserverTest.Impl.LeMonde;
import src.cn.sunguolei.study.Java.ObserverTest.Impl.NYTimes;

/**
 * @author GuoLei Sun
 * Date: 2018/10/11 6:34 PM
 */
public class ObserverTest {
    public static void main(String[] args) {
        Subject f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());

        f.registerObserver((String s) -> {
            if (s != null && s.contains("money")) {
                System.out.println("breaking hello");
            }
        });

        f.notifyObservers("The queen said her favourite book is java 8 in action");
    }
}
