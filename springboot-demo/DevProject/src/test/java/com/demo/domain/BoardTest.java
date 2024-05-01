package com.demo.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class BoardTest {

    @Test
    public void testNoArgsConstructor() {
        Board board = new Board();

        System.out.println(board);
    }

    @Test
    public void testRequiredArgsConstructor() {
        Board board = new Board("테스트 제목");

        System.out.println(board);
        System.out.println(board.toString());
    }

    @Test
    public void testBoardBuilder() {
        Board board = Board.builder()
                .boardNo(1)
                .title("title1")
                .content("content1")
                .writer("writer1")
                .regDate(LocalDateTime.now())
                .build();

        System.out.println(board);
    }

}