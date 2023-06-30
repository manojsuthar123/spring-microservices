package com.batch.management.service.impl;

import com.batch.management.model.dto.BatchDto;
import com.batch.management.model.entity.BatchEntity;
import com.batch.management.repository.BatchRepository;
import com.batch.management.service.BatchService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BatchServiceImpl implements BatchService {

    private BatchRepository batchRepository;
    private ObjectMapper objectMapper;

    @Override
    public BatchDto createBatch(BatchDto batchDto) {
        BatchEntity batchEntity = this.objectMapper.convertValue(batchDto, BatchEntity.class);
        BatchEntity savedBatchEntity = batchRepository.save(batchEntity);
        return this.objectMapper.convertValue(savedBatchEntity, BatchDto.class);
    }

    @Override
    public List<BatchDto> getBatch() {
        List<BatchDto> batchDtoList = new ArrayList<>();
        this.batchRepository.findAll().forEach(batchEntity -> {
            batchDtoList.add(this.objectMapper.convertValue(batchEntity, BatchDto.class));
        });
        return batchDtoList;
    }

    @Override
    public BatchDto getBatch(int batchId) {
        Optional<BatchEntity> batch = this.batchRepository.findById(batchId);
        return batch.map(batchEntity -> this.objectMapper.convertValue(batchEntity, BatchDto.class)).orElse(null);
    }

    @Override
    public String deleteBatch(int batchId) {
        this.batchRepository.deleteById(batchId);
        return "batch deleted";
    }
}
