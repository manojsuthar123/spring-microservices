package com.batch.management.controller;

import com.batch.management.model.dto.BatchDto;
import com.batch.management.service.BatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BatchController {

    private BatchService batchService;

    @PostMapping("/batch")
    public ResponseEntity<BatchDto> createBatch(@RequestBody BatchDto batchDto){
        return new ResponseEntity<>(batchService.createBatch(batchDto), HttpStatus.CREATED);
    }

    @GetMapping("/batch")
    public ResponseEntity<List<BatchDto>> getAllBatch(){
        return new ResponseEntity<>(batchService.getBatch(), HttpStatus.OK);
    }

    @GetMapping("/batch/{id}")
    public ResponseEntity<BatchDto> getBatchById(@RequestParam(name = "id") int id){
        return new ResponseEntity<>(batchService.getBatch(id), HttpStatus.OK);
    }

    @DeleteMapping("/batch/{id}")
    public ResponseEntity<String> deleteBatch(@RequestParam(name = "id") int id){
        return new ResponseEntity<>(batchService.deleteBatch(id), HttpStatus.OK);
    }
}
