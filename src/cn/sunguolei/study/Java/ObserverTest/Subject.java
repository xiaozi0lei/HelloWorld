package src.cn.sunguolei.study.Java.ObserverTest;

public interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}
