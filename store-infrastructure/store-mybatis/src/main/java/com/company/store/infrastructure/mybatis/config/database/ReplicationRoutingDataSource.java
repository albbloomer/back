package com.company.store.infrastructure.mybatis.config.database;

import com.company.store.infrastructure.mybatis.config.ApiPath;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class ReplicationRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        String currentTransactionName = TransactionSynchronizationManager.getCurrentTransactionName();
        if (ApiPath.isAyo(currentTransactionName)) {
            return DatabaseReplicationType.V1;
        }
        return DatabaseReplicationType.V2;
    }
}
