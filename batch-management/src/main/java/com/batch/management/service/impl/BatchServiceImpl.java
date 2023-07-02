package com.batch.management.service.impl;

import com.batch.management.mapper.BatchMapper;
import com.batch.management.model.dto.BatchDto;
import com.batch.management.model.dto.ResponseCode;
import com.batch.management.model.dto.ResponseMessage;
import com.batch.management.model.entity.BatchEntity;
import com.batch.management.repository.BatchRepository;
import com.batch.management.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchRepository batchRepository;

    @Override
    public BatchDto createBatch(BatchDto batchDto) {
        BatchEntity batchEntity = BatchMapper.MAPPER.toBatchEntity(batchDto);
        BatchEntity savedBatchEntity = batchRepository.save(batchEntity);
        return BatchMapper.MAPPER.toBatchDto(savedBatchEntity);
    }

    @Override
    public List<BatchDto> getBatch() {
        List<BatchDto> batchDtoList = new ArrayList<>();
        this.batchRepository.findAll().forEach(batchEntity -> {
            batchDtoList.add(BatchMapper.MAPPER.toBatchDto(batchEntity));
        });
        return batchDtoList;
    }

    @Override
    public BatchDto getBatch(int batchId) {
        Optional<BatchEntity> batch = this.batchRepository.findById(batchId);
        return batch.map(BatchMapper.MAPPER::toBatchDto).orElse(null);
    }

    @Override
    public ResponseMessage deleteBatch(int batchId) {
        this.batchRepository.deleteById(batchId);
        return new ResponseMessage(ResponseCode.SUCCESS, "deleted");
    }

    @Override
    public ResponseMessage startBatch(int batchId) {
        Optional<BatchEntity> batch = this.batchRepository.findById(batchId);
        if (batch.isPresent()){
            BatchEntity batchEntity = batch.get();
            batchEntity.setIsRunning(true);
            this.batchRepository.save(batchEntity);
            return new ResponseMessage(ResponseCode.SUCCESS, "batch started");
        }
        return new ResponseMessage(ResponseCode.FAILED, "failed to start batch, please try again later");
    }

    @Override
    public ResponseMessage stopBatch(int batchId) {
        Optional<BatchEntity> batch = this.batchRepository.findById(batchId);
        if (batch.isPresent()){
            BatchEntity batchEntity = batch.get();
            batchEntity.setIsRunning(false);
            this.batchRepository.save(batchEntity);
            return new ResponseMessage(ResponseCode.SUCCESS, "batch stopped");
        }
        return new ResponseMessage(ResponseCode.FAILED, "failed to stop batch, please try again later");
    }
}
