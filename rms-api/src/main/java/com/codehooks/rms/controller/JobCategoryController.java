package com.codehooks.rms.controller;

import com.codehooks.rms.dto.JobCategoryDto;
import com.codehooks.rms.entity.JobCategory;
import com.codehooks.rms.service.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/jobCategories")
public class JobCategoryController {

    @Autowired
    private JobCategoryService service;

    // Save data
    @PostMapping
    public ResponseEntity<?> saveJobCategory(@RequestBody JobCategoryDto jobCategory) {
        JobCategoryDto savedJobCategory = service.save(jobCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedJobCategory);
    }

    // Get data
    @GetMapping
    public ResponseEntity<?> getAllJobCategories() {
        List<JobCategoryDto> jobCategories = service.findAll();
        return ResponseEntity.ok(jobCategories);
    }

    //Get data by its id
    @GetMapping("/{id}")
    public ResponseEntity getDataById(@PathVariable String id) {
        return null;
    }

    // update Data
    @PutMapping
    public ResponseEntity<?> updateJobCategory(@RequestBody JobCategoryDto jobCategory) {
        JobCategoryDto updatedJobCategory = service.update(jobCategory);
        return ResponseEntity.ok(updatedJobCategory);
    }

    // Read Data
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJobCategory(@PathVariable String id) {
        boolean isDeleted = service.delete(id);
        return ResponseEntity.ok(isDeleted);
    }
}
