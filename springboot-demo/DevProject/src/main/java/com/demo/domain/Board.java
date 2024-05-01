package com.demo.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString // toString()
@EqualsAndHashCode(of = "boardNo") // equals(), hashCode()

@NoArgsConstructor // 인자없는 기본 생성자
//@RequiredArgsConstructor // @NonNull , final 선언된 필드값만 인자로 받는 생성자
@AllArgsConstructor // 모든 필드값을 인자로 받는 생성자

@Data // ToString, Getter, Setter, EqualsAndHashCode, RequiredArgsConstructor 합쳐놓은 어노테이션
@Builder // 빌더 패턴
@Slf4j // 자동 log 변수
public class Board {

    private long boardNo;

    @NotBlank
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;

//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + boardNo;
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        Board other = (Board) obj;
//        if (boardNo != other.boardNo)
//            return false;
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "Board(boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regDate=" + regDate + ")";
//    }
}
