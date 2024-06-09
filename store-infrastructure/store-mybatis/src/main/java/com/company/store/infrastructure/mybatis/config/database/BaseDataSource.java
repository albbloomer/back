package com.company.store.infrastructure.mybatis.config.database;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

abstract public class BaseDataSource {

    protected DataSource setRoutingDataSource(DataSource v1, DataSource v2) {
        Map<Object, Object> targetDataSourceMap = new HashMap<>() {{
            put(DatabaseReplicationType.V1, v1);
            put(DatabaseReplicationType.V2, v2);
        }};
        ReplicationRoutingDataSource routingDataSource = new ReplicationRoutingDataSource();
        routingDataSource.setTargetDataSources(targetDataSourceMap);
        routingDataSource.setDefaultTargetDataSource(v1);
        return routingDataSource;
    }
}
