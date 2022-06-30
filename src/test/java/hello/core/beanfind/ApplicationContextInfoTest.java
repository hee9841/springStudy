package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Project: core
 * Created by IntelliJ IDEA.
 * User: Sunghee Lee
 * Date: 2022-05-20
 * Time: 오후 4:27
 * PackageName : hello.core.beanfind
 */
public class ApplicationContextInfoTest {


    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        //빈에 정의된 이름 등록
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);

            System.out.println("name = " + beanDefinitionName + ", object = " + bean);
        }

    }


    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        //빈에 정의된 이름 등록
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            //bean에 대한 정보들
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //스프링 내부에서 등록한 빈이 아니라
            // 사용자가 아니면 외부 라이브러리 등을 등록 한 빈 들
            // ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            // ROLE_INFRASTRUCTURE : 스프링 내부에[서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + ", object = " + bean);
            }
        }

    }
}
