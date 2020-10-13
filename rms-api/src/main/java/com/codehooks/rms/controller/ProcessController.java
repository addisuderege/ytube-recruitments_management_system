package com.codehooks.rms.controller;

import com.codehooks.rms.dto.ProcessDto;
import com.codehooks.rms.dto.ResponseDto;
import com.codehooks.rms.entity.Process;
import com.codehooks.rms.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/processes")
@Slf4j
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @PostMapping
    public ResponseEntity saveProcess(@Valid @RequestBody ProcessDto process) {
        log.info("saveProcess");
        ProcessDto savedProcess = processService.save(process);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProcess);
    }

    @GetMapping
    public ResponseEntity getAllProcesss() {
        log.info("getAllProcess");
        List<ProcessDto> jobCategories = processService.findAll();
        return ResponseEntity.ok(jobCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDataById(@PathVariable String id) {
        log.info("getDataById");
        ProcessDto jobCategoryDto = processService.findById(id);
        return ResponseEntity.ok(jobCategoryDto);
    }

    @PutMapping
    public ResponseEntity updateProcess(@RequestBody ProcessDto process) {
        log.info("updateProcess");
        ProcessDto updatedProcess = processService.update(process);
        return ResponseEntity.ok(updatedProcess);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProcess(@PathVariable String id) {
        log.info("deleteProcess");
        boolean isDeleted = processService.delete(id);
        return ResponseEntity.ok("Process with the id \"" + id + "\" is deleted Successfully");
    }
}
