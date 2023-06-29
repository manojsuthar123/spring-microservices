package com.batch.management.service;

import com.batch.management.model.dto.BatchDto;

public interface BatchService {
    void createBatch(BatchDto batchDto);
    BatchDto getBatch();
    BatchDto getBatch(int batchId);

}
