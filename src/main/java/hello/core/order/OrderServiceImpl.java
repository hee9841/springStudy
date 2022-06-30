package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{
    
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    
    //RateDiscountPlicy class를 의존하기 때문에 DIP를 위반함
    //OCP 변경없이 확장?
    //현제 코드는 기능을 확장해 변경하면, 클라이언트 코드에 영향을 줌 -> OCP를 위반
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private DiscountPolicy discountPolicy;

    private final MemberRepository memberRepository;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    private final DiscountPolicy discountPolicy;


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
