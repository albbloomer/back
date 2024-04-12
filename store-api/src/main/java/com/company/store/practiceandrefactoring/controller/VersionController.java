package com.company.store.practiceandrefactoring.controller;

import com.company.store.practiceandrefactoring.mimetype.ApiVersion;
import com.company.store.practiceandrefactoring.mimetype.VersionResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    @GetMapping("/api/v1/book")
    public ResponseEntity<String> uriVersion() {
        return ResponseEntity.ok("uri version");
    }

    @GetMapping("/version/book")
    @VersionResource(from = ApiVersion.V1)
    public ResponseEntity<String> mimeTypeVersion() {
        return ResponseEntity.ok("mimeType version");
    }

    @GetMapping(value = "/resolver/book", headers = {"X-API-VERSION=2.0"})
    public ResponseEntity<String> headerVersion() {
        return ResponseEntity.ok("header version");
    }

}