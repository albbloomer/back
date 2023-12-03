package com.company.store.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class TestHttpUtils {

    private static final String HOST_AND_PORT = "http://localhost:8080";
    private static final Logger log = LoggerFactory.getLogger(TestHttpUtils.class);

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(1))
            .build();

    public static HttpResponse<String> send(final String path) {
        final var request = HttpRequest.newBuilder()
                .uri(URI.create(HOST_AND_PORT + path))
                .timeout(Duration.ofSeconds(1))
                .build();

        try {
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            log.error("TestHttpUtils sent method [{}]", e.getMessage(), e);
            throw new RuntimeException();
        }
    }
}