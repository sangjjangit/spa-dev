package com.demo.sample.domain;

import java.util.List;

public interface SampleRepository {

    Sample save(Sample sample);

    List<Sample> getList();
}
