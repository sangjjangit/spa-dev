package com.demo.sample.controller;

import com.demo.common.dto.CommonRequest;
import com.demo.common.dto.CommonResponse;
import com.demo.sample.entity.Sample;
import com.demo.sample.service.SampleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
public class SampleController {

    private final SampleService sampleService;

    @GetMapping(value = "/sample")
    public ResponseEntity<CommonResponse> sample(){
        CommonResponse commonResponse = CommonResponse.builder()
                .message("hi sample")
                .build();
        return ResponseEntity.ok().body(commonResponse);
    }

    @PostMapping(value = "/sample")
    public ResponseEntity<CommonResponse> sample(@RequestBody CommonRequest<Sample> req) {

        Sample sample = req.getData();

        log.info("sample: {}", sample);
        List<Sample> list = sampleService.getList(sample);
        log.info("list: {}", list);

        CommonResponse commonResponse = CommonResponse.builder()
                .message("SUCCESS")
                .result(list)
                .build();

        return ResponseEntity.ok().body(commonResponse);
    }
}
