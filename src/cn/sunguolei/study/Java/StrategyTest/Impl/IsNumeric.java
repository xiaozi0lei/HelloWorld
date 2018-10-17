package src.cn.sunguolei.study.Java.StrategyTest.Impl;

import src.cn.sunguolei.study.Java.StrategyTest.ValidationStrategy;

/**
 * @author GuoLei Sun
 * Date: 2018/10/11 5:55 PM
 */
public class IsNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
