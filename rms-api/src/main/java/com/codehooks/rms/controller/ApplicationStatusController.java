package com.codehooks.rms.controller;

import com.codehooks.rms.dto.ApplicationStatusDto;
import com.codehooks.rms.dto.ResponseDto;
import com.codehooks.rms.entity.ApplicationStatus;
import com.codehooks.rms.service.ApplicationStatusService;
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
@RequestMapping("/api/v1/applicationStatuss")
@Slf4j
public class ApplicationStatusController {

    @Autowired
    private ApplicationStatusService applicationStatusService;

    @PostMapping
    public ResponseEntity saveApplicationStatus(@Valid @RequestBody ApplicationStatusDto applicationStatus) {
        log.info("saveApplicationStatus");
        ApplicationStatusDto savedApplicationStatus = applicationStatusService.save(applicationStatus);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedApplicationStatus);
    }

    @GetMapping
    public ResponseEntity getAllApplicationStatuss() {
        log.info("getAllApplicationStatus");
        List<ApplicationStatusDto> jobCategories = applicationStatusService.findAll();
        return ResponseEntity.ok(jobCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDataById(@PathVariable String id) {
        log.info("getDataById");
        ApplicationStatusDto jobCategoryDto = applicationStatusService.findById(id);
        return ResponseEntity.ok(jobCategoryDto);
    }

    @PutMapping
    public ResponseEntity updateApplicationStatus(@RequestBody ApplicationStatusDto applicationStatus) {
        log.info("updateApplicationStatus");
        ApplicationStatusDto updatedApplicationStatus = applicationStatusService.update(applicationStatus);
        return ResponseEntity.ok(updatedApplicationStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteApplicationStatus(@PathVariable String id) {
        log.info("deleteApplicationStatus");
        boolean isDeleted = applicationStatusService.delete(id);
        return ResponseEntity.ok("ApplicationStatus with the id \"" + id + "\" is deleted Successfully");
    }
}
