package com.demo.clean.controllers;

import com.demo.clean.controllers.forms.CleanDataForm;
import com.demo.clean.domain.Clean;
import com.demo.clean.service.CleanCRUDService;
import com.demo.common.dto.CommonResponse;
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
public class CleanController {

    private final CleanCRUDService cleanCRUDService;

    private final SampleService sampleService;

    @GetMapping(value = "/clean")
    public ResponseEntity<CommonResponse> clean(){
        CommonResponse commonResponse = CommonResponse.builder()
                .message("hi clean")
                .build();
        return ResponseEntity.ok().body(commonResponse);
    }

    @PostMapping(value = "/clean/list")
    public ResponseEntity<CommonResponse> list(@RequestBody CleanDataForm cleanDataForm) {

        log.info("list cleanDataForm: {}", cleanDataForm);
        log.info("list cleanDataForm.toCondition(): {}", cleanDataForm.toCondition());

        List<Clean> cleanList = cleanCRUDService.getList(cleanDataForm.toCondition());

        log.info("list cleanList: {}", cleanList);

        CommonResponse commonResponse = CommonResponse.builder()
                .message("SUCCESS")
                .result(cleanList)
                .build();

        return ResponseEntity.ok().body(commonResponse);
    }

    @PostMapping(value = "/clean/save")
    public ResponseEntity<CommonResponse> save(@RequestBody CleanDataForm cleanDataForm) {

        log.info("save cleanDataForm: {}", cleanDataForm);

//        Clean clean = cleanCRUDService.save(cleanDataForm.toClean());
        Clean clean = cleanDataForm.toClean();
        int i = cleanCRUDService.save(clean);
        log.info("save i: {}", i);

        List<Clean> resultList = cleanCRUDService.getList(clean);

        CommonResponse commonResponse = CommonResponse.builder()
                .message("SUCCESS")
                .result(resultList)
                .build();

        return ResponseEntity.ok().body(commonResponse);
    }
}
