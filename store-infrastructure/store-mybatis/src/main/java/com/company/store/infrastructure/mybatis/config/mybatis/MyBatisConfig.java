package com.company.store.infrastructure.mybatis.config.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(
        sqlSessionFactoryRef = "sqlSessionFactory",
        basePackages = "com.company.store.infrastructure.mybatis.repository.point",
        annotationClass = Mapper.class
)
public class MyBatisConfig {

    private final String MAPPER_LOCATION ="classpath*:sqlmap/**/*.xml";
    private final String TYPE_HANDLERS_PACKAGE = "com.company.store.infrastructure.mybatis.config.mybatis.handler";

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("v0DataSource")DataSource v0DataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(v0DataSource);
        sqlSessionFactoryBean.setConfiguration(getMybatisConfiguration());
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        sqlSessionFactoryBean.setTypeHandlersPackage(TYPE_HANDLERS_PACKAGE);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    public org.apache.ibatis.session.Configuration getMybatisConfiguration() {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setDefaultExecutorType(ExecutorType.REUSE);
        configuration.setUseGeneratedKeys(true);
        configuration.setMapUnderscoreToCamelCase(true);
        return configuration;
    }
}
