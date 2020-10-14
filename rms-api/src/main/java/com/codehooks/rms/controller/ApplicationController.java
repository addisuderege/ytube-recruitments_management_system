package com.codehooks.rms.controller;

import com.codehooks.rms.dto.ApplicationDto;
import com.codehooks.rms.dto.ResponseDto;
import com.codehooks.rms.entity.Application;
import com.codehooks.rms.service.ApplicationService;
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
@RequestMapping("/api/v1/applications")
@Slf4j
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping
    public ResponseEntity saveApplication(@Valid @RequestBody ApplicationDto application) {
        log.info("saveApplication");
        ApplicationDto savedApplication = applicationService.save(application);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedApplication);
    }

    @GetMapping
    public ResponseEntity getAllApplications() {
        log.info("getAllApplication");
        List<ApplicationDto> jobCategories = applicationService.findAll();
        return ResponseEntity.ok(jobCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDataById(@PathVariable String id) {
        log.info("getDataById");
        ApplicationDto jobCategoryDto = applicationService.findById(id);
        return ResponseEntity.ok(jobCategoryDto);
    }

    @PutMapping
    public ResponseEntity updateApplication(@RequestBody ApplicationDto application) {
        log.info("updateApplication");
        ApplicationDto updatedApplication = applicationService.update(application);
        return ResponseEntity.ok(updatedApplication);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteApplication(@PathVariable String id) {
        log.info("deleteApplication");
        boolean isDeleted = applicationService.delete(id);
        return ResponseEntity.ok("Application with the id \"" + id + "\" is deleted Successfully");
    }
}
