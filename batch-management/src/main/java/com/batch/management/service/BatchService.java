package com.batch.management.service;

import com.batch.management.model.dto.BatchDto;

import java.util.List;

public interface BatchService {
    BatchDto createBatch(BatchDto batchDto);
    List<BatchDto> getBatch();
    BatchDto getBatch(int batchId);
    String deleteBatch(int batchId);

}
