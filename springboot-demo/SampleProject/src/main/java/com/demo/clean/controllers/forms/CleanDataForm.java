package com.demo.clean.controllers.forms;

import com.demo.clean.domain.Clean;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CleanDataForm {
    private String id;
    private String name;

    public Clean toCondition(){
        return Clean.builder()
                .name(name)
                .build();
    }

    public Clean toClean(){
        return Clean.builder()
                .id(id)
                .name(name)
                .build();
    }

}
