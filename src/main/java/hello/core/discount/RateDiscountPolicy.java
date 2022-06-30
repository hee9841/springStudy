package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * Project: core
 * Created by IntelliJ IDEA.
 * User: Sunghee Lee
 * Date: 2022-03-14
 * Time: 오후 12:04
 */
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercetnt = 10; //10%센트 활인


    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP){
            return price * discountPercetnt / 100;
        } else {
            return 0;
        }

    }
}
