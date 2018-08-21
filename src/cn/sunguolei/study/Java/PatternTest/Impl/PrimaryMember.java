package cn.sunguolei.study.PatternTest.Impl;


import cn.sunguolei.study.PatternTest.Member;

public class PrimaryMember implements Member {
    @Override
    public double calPrice(double bookPrice) {
        System.out.println("初级会员没有打折");
        return bookPrice;
    }
}
