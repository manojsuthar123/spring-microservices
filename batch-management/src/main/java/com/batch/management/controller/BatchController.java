package com.batch.management.controller;

import com.batch.management.model.dto.BatchDto;
import com.batch.management.model.dto.ResponseMessage;
import com.batch.management.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BatchController {

    @Autowired
    private BatchService batchService;

    @PostMapping("/batch")
    public ResponseEntity<BatchDto> createBatch(@RequestBody BatchDto batchDto) {
        return new ResponseEntity<>(batchService.createBatch(batchDto), HttpStatus.CREATED);
    }

    @GetMapping("/batch/{id}")
    public ResponseEntity<BatchDto> getBatchById(@PathVariable(value = "id") Integer id){
        BatchDto batchDto = batchService.getBatch(id);
        if(batchDto == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(batchDto, HttpStatus.OK);
    }

    @DeleteMapping("/batch/{id}")
    public ResponseEntity<ResponseMessage> deleteBatch(@PathVariable(value = "id") Integer id){
        return new ResponseEntity<>(batchService.deleteBatch(id), HttpStatus.OK);
    }

    @GetMapping("/batch")
    public ResponseEntity<List<BatchDto>> getAllBatch(){
        return new ResponseEntity<>(batchService.getBatch(), HttpStatus.OK);
    }

    @GetMapping("/batch/{id}/start")
    public ResponseEntity<ResponseMessage> startBatch(@PathVariable(value = "id") Integer id){
        return new ResponseEntity<>(batchService.startBatch(id), HttpStatus.OK);
    }

    @GetMapping("/batch/{id}/stop")
    public ResponseEntity<ResponseMessage> stopBatch(@PathVariable(value = "id") Integer id){
        return new ResponseEntity<>(batchService.stopBatch(id), HttpStatus.OK);
    }
}
