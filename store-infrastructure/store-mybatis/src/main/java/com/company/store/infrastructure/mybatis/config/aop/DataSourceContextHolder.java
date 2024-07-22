package com.company.store.infrastructure.mybatis.config.aop;

import com.company.store.infrastructure.mybatis.config.database.DatabaseReplicationType;

public class DataSourceContextHolder {

    private static final ThreadLocal<DatabaseReplicationType> contextHolder = new ThreadLocal<>();

    public static void setDataSourceKey(DatabaseReplicationType dataSourceKey) {
        contextHolder.set(dataSourceKey);
    }

    public static DatabaseReplicationType getDataSourceKey() {
        return contextHolder.get();
    }

    public static void clearDataSourceKey() {
        contextHolder.remove();
    }
}
