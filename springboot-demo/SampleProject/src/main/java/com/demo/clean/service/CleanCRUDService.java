package com.demo.clean.service;

import com.demo.clean.controllers.forms.CleanDataForm;
import com.demo.clean.domain.Clean;
import com.demo.clean.domain.CleanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
//@Transactional
public class CleanCRUDService {

    private final CleanRepository cleanRepository;

    public List<Clean> getList(CleanDataForm cleanDataForm){

        CleanDataForm cleanDataForm1 = new CleanDataForm();
        cleanDataForm1.setContents("nono");
        cleanDataForm1.setName("mysql.sys");
        Clean clean1 = cleanDataForm1.toClean();
        List<Clean> cleanList1 = cleanRepository.getList(clean1);
        log.info("cleanList1: {}", cleanList1);

        List<Clean> cleanList2 = cleanRepository.findAll();
        log.info("cleanList2: {}", cleanList2);

        cleanDataForm.setContents("service setContents");
        Clean clean = cleanDataForm.toClean();
        List<Clean> cleanList = cleanRepository.getList(clean);
        return cleanList;
    }

    public int save(CleanDataForm cleanDataForm){

        Clean clean = cleanDataForm.toClean();
        return cleanRepository.save(clean);
    }
}
