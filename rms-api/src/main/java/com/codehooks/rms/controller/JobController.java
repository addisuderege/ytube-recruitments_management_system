package com.codehooks.rms.controller;

import com.codehooks.rms.dto.JobDto;
import com.codehooks.rms.dto.ResponseDto;
import com.codehooks.rms.entity.Job;
import com.codehooks.rms.service.JobService;
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
@RequestMapping("/api/v1/jobs")
@Slf4j
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public ResponseEntity saveJob(@Valid @RequestBody JobDto job) {
        log.info("saveJob");
        JobDto savedJob = jobService.save(job);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedJob);
    }

    @GetMapping
    public ResponseEntity getAllJobs() {
        log.info("getAllJob");
        List<JobDto> jobCategories = jobService.findAll();
        return ResponseEntity.ok(jobCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDataById(@PathVariable String id) {
        log.info("getDataById");
        JobDto jobCategoryDto = jobService.findById(id);
        return ResponseEntity.ok(jobCategoryDto);
    }

    @PutMapping
    public ResponseEntity updateJob(@RequestBody JobDto job) {
        log.info("updateJob");
        JobDto updatedJob = jobService.update(job);
        return ResponseEntity.ok(updatedJob);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteJob(@PathVariable String id) {
        log.info("deleteJob");
        boolean isDeleted = jobService.delete(id);
        return ResponseEntity.ok("Job with the id \"" + id + "\" is deleted Successfully");
    }
}
