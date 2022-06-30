package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {


        //스프링 사용하기 전
//        AppConfig appConfig = new AppConfig();
//
//        MemberService memberService = appConfig.memberService();

        //스프링 컨테이너라고 보면 됨
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); //(이름, 반환타입)


        //MemberService memberService = new MemberSeiviceImpl();


        //1L은 long타입이라서 L를 붙여줘야함, 그냥 1하면 컴파일 오류남
        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1l);

        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }

}