package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Project: core
 * Created by IntelliJ IDEA.
 * User: Sunghee Lee
 * Date: 2022-05-23
 * Time: 오후 3:10
 * PackageName : hello.core.beanfind
 * F
 */
public class ApplicationContextBasicFindTest {


    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈이름으로 조회")
    void findBenaByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);

//        System.out.println("memberService = " + memberService);
//        System.out.println("memberService.getClass() = " + memberService.getClass());

        //검증은 assertions로
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }


    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        //검증은 assertions로
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }


    //위에 두 테스트는 인터페이스로 조회함
    // 인터페이스로 조회하는 구체 타입으로 조회하든 상관 없음
    //appConfig 파일에 등록되어 있는 리턴되는 인스턴트 타입으로 되어있서
    //근데 구체적으로 적는 것은 안좋음
    // 역활과 구현을 구분해야 하고 역활에 의존해야 되는데
    // 아래 코드는 구현에 의존해서
    @Test
    @DisplayName("구체 타입으로으로 조회")
    void findBenaByName2() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);

        //검증은 assertions로
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    //테스트는 실패 테스트를 만들어야함
    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX() {
       // MemberService xxxxxx = ac.getBean("xxxxxx", MemberService.class);
        //예외처리가 생김
        //org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'xxxxxx' available

        assertThrows(NoSuchBeanDefinitionException.class, () ->
                ac.getBean("xxxxxx", MemberService.class));

    }

}

