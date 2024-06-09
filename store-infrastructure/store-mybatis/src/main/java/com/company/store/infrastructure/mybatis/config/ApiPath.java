package com.company.store.infrastructure.mybatis.config;

import java.util.Arrays;

public enum ApiPath {

    AYO("/separation/v1")
    ;

    ApiPath(String path) {
        this.path = path;
    }

    private final String path;

    public static boolean isAyo(final String path) {
        return Arrays.stream(values())
                .anyMatch(apiPath -> apiPath.getPath().equals(path));
    }

    public String getPath() {
        return path;
    }
}
