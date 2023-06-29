package com.batch.management.controller;

import com.batch.management.model.dto.BatchDto;
import com.batch.management.service.BatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BatchController {

    private BatchService batchService;

    @PostMapping("/batch")
    public ResponseEntity<String> createBatch(@RequestBody BatchDto batchDto){
        batchService.createBatch(batchDto);
        return new ResponseEntity<>("batch created", HttpStatus.CREATED);
    }
}
