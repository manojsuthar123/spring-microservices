package com.batch.management.service;

import com.batch.management.model.dto.BatchDto;
import com.batch.management.model.dto.ResponseMessage;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface BatchService {
    BatchDto createBatch(BatchDto batchDto);
    List<BatchDto> getBatch();
    BatchDto getBatch(int batchId);
    ResponseMessage deleteBatch(int batchId);
    ResponseMessage startBatch(int batchId);
    ResponseMessage stopBatch(int batchId);

}
