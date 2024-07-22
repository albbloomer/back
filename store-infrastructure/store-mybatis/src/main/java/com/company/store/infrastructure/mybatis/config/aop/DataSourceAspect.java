package com.company.store.infrastructure.mybatis.config.aop;

import com.company.store.infrastructure.mybatis.annotation.StoreV2DataSource;
import com.company.store.infrastructure.mybatis.config.database.DatabaseReplicationType;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component
@Aspect
public class DataSourceAspect {

    @Before("@annotation(storeV2DataSource)")
    public void beforeApiCall(StoreV2DataSource storeV2DataSource) {
        DataSourceContextHolder.setDataSourceKey(DatabaseReplicationType.V2);
        DatabaseReplicationType dataSourceKey = DataSourceContextHolder.getDataSourceKey();
        if (dataSourceKey != null) {
            TransactionSynchronizationManager.setCurrentTransactionName(dataSourceKey.name());
        }
    }

    @AfterReturning("@annotation(storeV2DataSource)")
    public void afterApiCall(StoreV2DataSource storeV2DataSource) {
        DataSourceContextHolder.clearDataSourceKey();
        TransactionSynchronizationManager.setCurrentTransactionName(null);
    }
}