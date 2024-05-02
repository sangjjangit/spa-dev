package com.demo.clean.service;

import com.demo.clean.domain.Clean;
import com.demo.clean.domain.CleanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CleanCRUDService {

    private final CleanRepository cleanRepository;

    public List<Clean> getList(Clean clean){
        List<Clean> cleanList = cleanRepository.getList(clean);
        return cleanList;
    }

    public int save(Clean clean){
        return cleanRepository.save(clean);
    }
}
