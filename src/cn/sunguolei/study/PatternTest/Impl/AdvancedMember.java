package cn.sunguolei.study.PatternTest.Impl;

import cn.sunguolei.study.PatternTest.Member;

public class AdvancedMember implements Member {
    @Override
    public double calPrice(double bookPrice) {
        System.out.println("高级会员打8折");
        return bookPrice * 0.8;
    }
}
