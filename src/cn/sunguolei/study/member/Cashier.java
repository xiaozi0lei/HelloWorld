package cn.sunguolei.study.member;

public class Cashier {
    private Member member;

    public Cashier(Member member) {
        this.member = member;
    }

    public double quote(double bookPrice) {
        return this.member.calPrice(bookPrice);
    }
}
