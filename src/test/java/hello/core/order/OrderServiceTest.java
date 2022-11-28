package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderServiceTest {

//    MemberService memberService = new MemberSeiviceImpl();
//    OrderService orderService = new OrderServiceImpl();

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();

        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }



    @Test
    void createOrder(){
        Long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    void tttt() {

        //te


        Map <String, String> map1 = new HashMap<>();
        map1.put("map1", "map1");

        Map <String, String> map2 = new HashMap<>();
        map2.put("map2", "map2");

        Map <String, String> map3 = new HashMap<>();
        map2.put("map3", "map3");

        List<Map<String, String>> tt = new ArrayList<>(){
            {
                add(map1);
                add(map2);
            }
        };

        System.out.println("tt.toString() = " + tt.toString());

        tt.add(0, map2);

        System.out.println("tt.toString() = " + tt.toString());
    }
}
