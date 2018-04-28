package cn.sunguolei.study.PatternTest;

import cn.sunguolei.study.PatternTest.Impl.AdvancedMember;
import cn.sunguolei.study.PatternTest.Impl.IntermediateMember;

/**
 * 策略设计模式
 */
public class BookStore {

    public static void main(String[] args) {

        //选择并创建需要使用的策略对象
        Member strategy = new AdvancedMember();
        //创建环境
        Cashier cashier = new Cashier(strategy);
        //计算价格
        double quote = cashier.quote(300);
        System.out.println("高级会员图书的最终价格为：" + quote);

        strategy = new IntermediateMember();
        cashier = new Cashier(strategy);
        quote = cashier.quote(300);
        System.out.println("中级会员图书的最终价格为：" + quote);
    }
}
