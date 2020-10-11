package com.codehooks.rms.controller;

import com.codehooks.rms.dto.JobCategoryDto;
import com.codehooks.rms.dto.ResponseDto;
import com.codehooks.rms.entity.JobCategory;
import com.codehooks.rms.service.JobCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/jobCategories")
@Slf4j
public class JobCategoryController {

    @Autowired
    private JobCategoryService service;

    @PostMapping
    public ResponseEntity<?> saveJobCategory(@Valid @RequestBody JobCategoryDto jobCategory) {
        log.info("saveJobCategory");
        JobCategoryDto savedJobCategory = service.save(jobCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedJobCategory);
    }

    @GetMapping
    public ResponseEntity<?> getAllJobCategories() {
        List<JobCategoryDto> jobCategories = service.findAll();
        return ResponseEntity.ok(jobCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDataById(@PathVariable String id) {
        log.info("getDataById {}", id);
        JobCategoryDto jobCategoryDto = service.findById(id);
        return ResponseEntity.ok(jobCategoryDto);
    }

    @PutMapping
    public ResponseEntity<?> updateJobCategory(@RequestBody JobCategoryDto jobCategory) {
        JobCategoryDto updatedJobCategory = service.update(jobCategory);
        return ResponseEntity.ok(updatedJobCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJobCategory(@PathVariable String id) {
        boolean isDeleted = service.delete(id);
        return ResponseEntity.ok(isDeleted);
    }
}
