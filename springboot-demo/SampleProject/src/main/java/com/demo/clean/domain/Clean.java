package com.demo.clean.domain;

import lombok.*;

@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clean {
    private String id;
    private String name;

    private String contents;
    private String title;
    private String writer;

    @Builder.Default
    private long created = System.currentTimeMillis();

//    @Builder.Default
//    private long created = System.currentTimeMillis();
}
