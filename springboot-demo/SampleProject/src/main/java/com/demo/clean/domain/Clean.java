package com.demo.clean.domain;

import lombok.*;

@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Clean {
    private String id;
    private String name;
    private String user;

    private String contents;
    private String title;
    private String writer;

    @Builder.Default
    private long created = System.currentTimeMillis();

//    @Builder.Default
//    private long created = System.currentTimeMillis();
}
