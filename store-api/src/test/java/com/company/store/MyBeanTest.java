package com.company.store;


import com.company.store.config.TestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = TestConfiguration.class)
public class MyBeanTest {

    @Autowired
    private ApplicationContext context;

    /**
     * Todo : 테스트용으로 등록된 빈
     *
     * testConfiguration: @ContextConfiguration을 사용하여 테스트를 위한 구성 클래스로 등록한 빈
     * myTestBean: TestConfiguration 클래스에서 정의한 빈으로, 테스트할 때만 필요한 빈
     *
     * Todo : 다른 빈들
     *
     * org.springframework.boot.test.mock.mockito.MockitoPostProcessor$SpyPostProcessor: Mockito 테스트용 포스트 프로세서
     * org.springframework.boot.test.mock.mockito.MockitoPostProcessor: Mockito 테스트용 포스트 프로세서
     * org.springframework.context.annotation.internalConfigurationAnnotationProcessor: 구성 어노테이션을 처리하기 위한 내부 빈
     * org.springframework.context.annotation.internalAutowiredAnnotationProcessor: 자동 와이어링 어노테이션을 처리하기 위한 내부 빈
     * org.springframework.context.annotation.internalCommonAnnotationProcessor: 공통 어노테이션을 처리하기 위한 내부 빈
     * org.springframework.context.annotation.internalPersistenceAnnotationProcessor: 지속성 어노테이션을 처리하기 위한 내부 빈
     * org.springframework.context.event.internalEventListenerProcessor: 이벤트 리스너를 처리하기 위한 내부 빈
     * org.springframework.context.event.internalEventListenerFactory: 이벤트 리스너를 생성하기 위한 내부 빈
     * org.springframework.boot.autoconfigure.internalCachingMetadataReaderFactory: 자동 구성을 위한 내부 메타데이터 리더 팩토리
     *
     * Todo : "프로세서"와 "팩토리"는 스프링에서 빈을 생성하고 구성하기 위해 사용되는 특수한 유형의 빈이며, 보통 "Bean"으로 분류
     */

    @Test
    public void testApplicationContext() {
        assertNotNull(context);
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

}