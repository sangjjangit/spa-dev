package com.demo.clean.domain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CleanRepository {

    int save(Clean clean);

    List<Clean> getList(Clean clean);

    @Select("select * from user")
    List<Clean> findAll();

}
