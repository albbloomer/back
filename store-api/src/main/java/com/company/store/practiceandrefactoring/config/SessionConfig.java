package com.company.store.practiceandrefactoring.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
import org.springframework.session.web.http.HttpSessionIdResolver;

import java.util.Collections;
import java.util.List;

/**
 * 세션 연습 <br>
 * 패키지 경로가 올바르지않지만 연습 겸
 *
 */

// @EnableSpringHttpSession WAS(Tomcat) JVM  내장 톰캣이 기본적으로 사용하는 세션 저장소는 일반적으로 JVM 메모리

@Configuration
@EnableRedisHttpSession
public class SessionConfig extends AbstractHttpSessionApplicationInitializer {

    @Bean
    public HttpSessionIdResolver httpSessionIdResolver() {
        return new CustomHttpSessionIdResolver();
    }

    static class CustomHttpSessionIdResolver implements HttpSessionIdResolver {

        @Override
        public List<String> resolveSessionIds(HttpServletRequest request) {
            String zuid = request.getParameter("zuid");
            if (zuid != null) {
                return Collections.singletonList("zuid:" + zuid);
            }
            return Collections.emptyList();
        }

        @Override
        public void setSessionId(HttpServletRequest request, HttpServletResponse response, String sessionId) {
            //
        }

        @Override
        public void expireSession(HttpServletRequest request, HttpServletResponse response) {
            //
        }
    }
}