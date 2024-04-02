package com.company.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 어노테이션은 전체 애플리케이션 컨텍스트를 로드하므로, 모든 빈들이 스프링 부트의 자동 구성 및 환경 설정에 따라 로드 <br>
 * 테스트용으로 만든 빈 외에도 @SpringBootTest를 사용하면 스프링 부트가 제공하는 여러 가지 기능과 관련된 빈들도 함께 로드 <br>
 */
@SpringBootTest
public class MyBeanProduct {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testApplicationContext() {
        assertNotNull(context);
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            Object bean = context.getBean(beanName);
            if (!bean.getClass().getPackage().getName().startsWith("com.company")) {
                System.out.println(beanName);
            }
        }
    }
}