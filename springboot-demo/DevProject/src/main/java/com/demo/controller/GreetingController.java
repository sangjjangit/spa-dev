package com.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/greetings")
public class GreetingController {

    private final MessageSource messageSource;

    @GetMapping(path = "/welcome", produces="text/plain;charset=UTF-8")
    public ResponseEntity<String> welcome() {
// 미리 정의된 메시지에 값을 넘겨준다.
        String[] args = { "홍길동" };

// 스프링 프레임워크로 부터 MessageSource를 주입받은 다음 getMessage 메서드를 호출한다.
        String message = messageSource.getMessage("welcome.message", args, Locale.KOREAN);

        log.info("Welcome message : " + message);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }
}
