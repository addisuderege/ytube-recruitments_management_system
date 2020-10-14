package com.codehooks.rms.controller;

import com.codehooks.rms.dto.ApplicantDto;
import com.codehooks.rms.dto.ResponseDto;
import com.codehooks.rms.entity.Applicant;
import com.codehooks.rms.service.ApplicantService;
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
@RequestMapping("/api/v1/applicants")
@Slf4j
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @PostMapping
    public ResponseEntity saveApplicant(@Valid @RequestBody ApplicantDto applicant) {
        log.info("saveApplicant");
        ApplicantDto savedApplicant = applicantService.save(applicant);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedApplicant);
    }

    @GetMapping
    public ResponseEntity getAllApplicants() {
        log.info("getAllApplicant");
        List<ApplicantDto> jobCategories = applicantService.findAll();
        return ResponseEntity.ok(jobCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDataById(@PathVariable String id) {
        log.info("getDataById");
        ApplicantDto jobCategoryDto = applicantService.findById(id);
        return ResponseEntity.ok(jobCategoryDto);
    }

    @PutMapping
    public ResponseEntity updateApplicant(@RequestBody ApplicantDto applicant) {
        log.info("updateApplicant");
        ApplicantDto updatedApplicant = applicantService.update(applicant);
        return ResponseEntity.ok(updatedApplicant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteApplicant(@PathVariable String id) {
        log.info("deleteApplicant");
        boolean isDeleted = applicantService.delete(id);
        return ResponseEntity.ok("Applicant with the id \"" + id + "\" is deleted Successfully");
    }
}
