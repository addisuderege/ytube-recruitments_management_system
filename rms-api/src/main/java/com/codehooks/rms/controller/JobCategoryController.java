package com.codehooks.rms.controller;

import com.codehooks.rms.dto.JobCategoryDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/jobCategories")
public class JobCategoryController {

    @GetMapping
    public ResponseEntity<JobCategoryDto> getAllCategories() {
        JobCategoryDto jobCategoryDto = JobCategoryDto.builder()
                .id("1")
                .jobCategoryName("Development")
                .jobCategoryCode("Dev")
                .description("Some description about the development")
                .build();

        return ResponseEntity.ok().body(jobCategoryDto);
    }

    @GetMapping(path = "/filter")
    public ResponseEntity<String> filterRecords(@RequestParam Map<String, Object> filters) {
        return ResponseEntity.ok("Filtering the data with filter value : " + filters);
    }

    @PostMapping
    public ResponseEntity<JobCategoryDto> saveCategory(@RequestBody JobCategoryDto jobCategoryDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jobCategoryDto);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteJobCategory(@PathVariable("id") String jobCategoryId) {
        return ResponseEntity.ok("Job Category with id " + jobCategoryId + " is deleted successfully");
    }
}
