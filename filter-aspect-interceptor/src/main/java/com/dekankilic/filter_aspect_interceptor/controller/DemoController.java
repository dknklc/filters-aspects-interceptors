package com.dekankilic.filter_aspect_interceptor.controller;

import com.dekankilic.filter_aspect_interceptor.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {
    private final DemoService demoService;

    @GetMapping("/demo")
    public ResponseEntity<String> demo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(demoService.demo());
    }
}
