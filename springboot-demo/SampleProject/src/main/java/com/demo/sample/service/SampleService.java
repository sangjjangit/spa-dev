package com.demo.sample.service;

import com.demo.common.dto.CommonRequest;
import com.demo.sample.entity.Sample;
import com.demo.sample.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class SampleService {

    private final SampleRepository sampleRepository;

    public List<Sample> getList(Sample conditionSample){
        List<Sample> sampleList = new ArrayList<>();

        Sample sample = Sample.builder()
                .id("sampleID")
                .name("sample_name")
                .build();

        sampleList.add(sample);
        log.info("getList: {}", sample);

        return sampleList;
    }

    public List<Sample> getList(CommonRequest commonRequest){

        return List.of((Sample) commonRequest.getData());
    }
}
