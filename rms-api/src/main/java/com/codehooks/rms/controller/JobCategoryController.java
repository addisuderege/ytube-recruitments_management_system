package com.codehooks.rms.controller;

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

    @GetMapping
    public ResponseEntity<List<JobCategory>> getAllCategories() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/filter")
    public ResponseEntity<String> filterRecords(@RequestParam Map<String, Object> filters) {
        return ResponseEntity.ok("Filtering the data with filter value : " + filters);
    }

    @PostMapping
    public ResponseEntity<JobCategory> saveCategory(@RequestBody JobCategory JobCategory) {
        return null;
    }

    @PutMapping
    public ResponseEntity<JobCategory> updateCategory(@RequestBody JobCategory JobCategory) {
        return null;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteJobCategory(@PathVariable("id") String jobCategoryId) {
        return null;
    }
}
