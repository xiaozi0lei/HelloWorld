package cn.sunguolei.study.member.Impl;

import cn.sunguolei.study.member.Member;

public class IntermediateMember implements Member {
    @Override
    public double calPrice(double bookPrice) {
        System.out.println("中级会员打9折");
        return bookPrice * 0.9;
    }
}
