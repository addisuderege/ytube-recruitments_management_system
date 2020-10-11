package com.codehooks.rms.controller;

import com.codehooks.rms.dto.JobPositionDto;
import com.codehooks.rms.dto.ResponseDto;
import com.codehooks.rms.entity.JobPosition;
import com.codehooks.rms.service.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/jobPositions")
public class JobPositionController {

    @Autowired
    private JobPositionService jobPositionService;

    @PostMapping
    public ResponseEntity saveJobPosition(@Valid @RequestBody JobPositionDto jobPosition) {
        JobPositionDto savedJobPosition = jobPositionService.save(jobPosition);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedJobPosition);
    }

    @GetMapping
    public ResponseEntity getAllJobCategories() {
        List<JobPositionDto> jobCategories = jobPositionService.findAll();
        return ResponseEntity.ok(jobCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDataById(@PathVariable String id) {
        JobPositionDto jobCategoryDto = jobPositionService.findById(id);
        return ResponseEntity.ok(jobCategoryDto);
    }

    @PutMapping
    public ResponseEntity updateJobPosition(@Valid @RequestBody JobPositionDto jobPosition) {
        JobPositionDto updatedJobPosition = jobPositionService.update(jobPosition);
        return ResponseEntity.ok(updatedJobPosition);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteJobPosition(@PathVariable String id) {
        boolean isDeleted = jobPositionService.delete(id);
        return ResponseEntity.ok("JobPosition with the id \"" + id + "\" deleted Successfully");
    }
}
