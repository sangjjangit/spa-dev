/*
16. 컨트롤러 요청 매핑
1. 요청 경로 매핑
- @RequestMapping(value = "/boards/register")

2. 경로 패턴 매핑 - 동적표현
- @RequestMapping("/read/{boardNo}")

3. Http 메서드 매핑
- @GetMapping
- @PostMapping
- @PutMapping
- @DeleteMapping
- @PatchMapping

4. Header 매핑
- headers 속성을 사용해서 요청을 매핑한다.
- @PutMapping(path = "/{boardNo}", headers = "X-HTTP-Method-Override=PUT")

5. Content Type 매핑
- consumes 속성값을 지정하지 않으면 기본값인 "application/json" 미디어 타입으로 지정된다.
- @PutMapping(path = "/{boardNo}", consumes = "application/json")

6. Accept 매핑
- produces 속성값을 지정하지 않으면 기본값인 "application/json" 미디어 타입으로 지정된다.
- produces 속성값에 "application/json" 미디어 타입을 지정한다.
- @GetMapping(path = "/{boardNo}", produces = "application/json")
*/
package com.demo.controller;

import com.demo.domain.Board;
import com.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService service;

    @GetMapping("/{boardNo}")
    public ResponseEntity<Board> read(@PathVariable("boardNo") long boardNo) throws Exception {
        log.info("read");

// 게시판의 글이 존재하지 않으면 사용자가 정의한 예외를 발생시킨다.
        Board board = service.read(boardNo);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Board>> list() throws Exception {
        log.info("list");

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody Board board) {
        log.info("register");

        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);

        return entity;
    }

    @DeleteMapping("/{boardNo}")
    public ResponseEntity<String> remove(@PathVariable("boardNo") int boardNo) {
        log.info("remove");

        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);

        return entity;
    }

    @PutMapping("/{boardNo}")
    public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
        log.info("modify");

        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);

        return entity;
    }

}
