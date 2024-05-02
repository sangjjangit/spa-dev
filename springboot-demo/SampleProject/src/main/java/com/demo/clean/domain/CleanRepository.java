package com.demo.clean.domain;

import java.util.List;

public interface CleanRepository {

    int save(Clean clean);

    List<Clean> getList(Clean clean);


}
