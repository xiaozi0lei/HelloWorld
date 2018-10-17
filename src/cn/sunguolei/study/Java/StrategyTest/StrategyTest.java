package src.cn.sunguolei.study.Java.StrategyTest;

import src.cn.sunguolei.study.Java.StrategyTest.Impl.IsAllLowerCase;
import src.cn.sunguolei.study.Java.StrategyTest.Impl.IsNumeric;

/**
 * @author GuoLei Sun
 * Date: 2018/10/11 5:57 PM
 */
public class StrategyTest {
    private ValidationStrategy strategy;

    public StrategyTest(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }

    public static void main(String[] args) {
        StrategyTest numericValidator = new StrategyTest(new IsNumeric());
        System.out.println(numericValidator.validate("啊啊啊啊"));

        StrategyTest lowerValidator = new StrategyTest(new IsAllLowerCase());
        System.out.println(lowerValidator.validate("bbbbb"));

        StrategyTest numericLamda = new StrategyTest((String s) -> s.matches("\\d+"));
        System.out.println(numericLamda.validate("123"));
    }
}
