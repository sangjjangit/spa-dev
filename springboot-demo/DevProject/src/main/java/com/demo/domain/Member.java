package com.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
public class Member {

    @NotBlank
    private String userId;
    private String password;

    @NotBlank
    @Size(max=3)
    private String userName;

    //@Past - 과거 날짜인지 검사
    //@Future - 미래 날짜인지 검사

    @JsonFormat(pattern = "yyyyMMdd")
    private String bithday;

    private String email;
    private String gender;

    // 중첩된 자바빈즈의 입력값 검증을 지정한다.
    @Valid
    private Address address;

    // 자바빈즈 컬렉션의 입력값 검증을 지정한다.
    @Valid
    private List<Card> cardList;


    @Builder
    public Member(String userId, String userName, String password){
        super();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }
}
