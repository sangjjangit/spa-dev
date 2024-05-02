package com.demo.clean.repository;

import com.demo.clean.domain.Clean;
import com.demo.clean.domain.CleanRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CleanMyBatisReopsitory extends CleanRepository {
}
