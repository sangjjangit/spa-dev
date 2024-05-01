package com.demo.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberTest {

    @Test
    public void testMemberBuilder() {
        Member member = Member.builder()
                .userId("userId1")
                .userName("userName1")
                .password("password1")
                .build();

        System.out.println(member);
    }
}