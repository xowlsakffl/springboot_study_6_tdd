package com.fastcampus.tdd.ch02;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public ResponseEntity<String> test() throws InterruptedException {
        return new ResponseEntity<>(
                "test",
                HttpStatus.OK
        );
    }
}
