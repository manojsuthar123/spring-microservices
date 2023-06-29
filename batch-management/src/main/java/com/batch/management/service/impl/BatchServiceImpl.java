package com.batch.management.service.impl;

import com.batch.management.model.dto.BatchDto;
import com.batch.management.model.entity.BatchEntity;
import com.batch.management.repository.BatchRepository;
import com.batch.management.service.BatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BatchServiceImpl implements BatchService {

    private BatchRepository batchRepository;

    @Override
    public void createBatch(BatchDto batchDto) {
        BatchEntity batchEntity = new BatchEntity();
        batchRepository.save(batchEntity);
    }

    @Override
    public BatchDto getBatch() {
        return null;
    }

    @Override
    public BatchDto getBatch(int batchId) {
        Optional<BatchEntity> batch = batchRepository.findById(batchId);

        return null;
    }
}
