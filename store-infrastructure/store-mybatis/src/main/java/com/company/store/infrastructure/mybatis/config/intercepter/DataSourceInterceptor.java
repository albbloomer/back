package com.company.store.infrastructure.mybatis.config.intercepter;

import com.company.store.infrastructure.mybatis.config.ApiPath;
import com.company.store.infrastructure.mybatis.config.aop.DataSourceContextHolder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

public class DataSourceInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if (ApiPath.isAyo(request.getQueryString())) {
            DataSourceContextHolder.setDataSourceKey(requestURI);
        }
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        DataSourceContextHolder.clearDataSourceKey();
    }
}
