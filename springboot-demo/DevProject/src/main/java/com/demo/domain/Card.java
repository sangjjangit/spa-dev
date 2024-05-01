package com.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.YearMonth;

@Getter
@Setter
@ToString
public class Card {

    // 문자열이 null이 아니고 trim한 길이가 0보다 크다는 것을 검사한다.
    @NotBlank
    private String no;

    // 미래 날짜인지를 검사한다.
    @JsonFormat(pattern = "yyyy-MM")
    @Future
    private YearMonth validMonth;

}
