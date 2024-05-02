package com.demo.sample.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class Sample {
    private String id;
    private String name;
    private SubData subData;
    private List<SubData> subDataList;

    @Setter
    @Getter
    class SubData {
        private String subId;
        private String subName;
    }
}
