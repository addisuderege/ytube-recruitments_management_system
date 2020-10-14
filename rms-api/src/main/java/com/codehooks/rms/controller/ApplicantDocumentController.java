package com.codehooks.rms.controller;

import com.codehooks.rms.dto.ApplicantDocumentDto;
import com.codehooks.rms.dto.ResponseDto;
import com.codehooks.rms.entity.ApplicantDocument;
import com.codehooks.rms.service.ApplicantDocumentService;
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
@RequestMapping("/api/v1/applicantDocuments")
@Slf4j
public class ApplicantDocumentController {

    @Autowired
    private ApplicantDocumentService applicantDocumentService;

    @PostMapping
    public ResponseEntity saveApplicantDocument(@Valid @RequestBody ApplicantDocumentDto applicantDocument) {
        log.info("saveApplicantDocument");
        ApplicantDocumentDto savedApplicantDocument = applicantDocumentService.save(applicantDocument);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedApplicantDocument);
    }

    @GetMapping
    public ResponseEntity getAllApplicantDocuments() {
        log.info("getAllApplicantDocument");
        List<ApplicantDocumentDto> jobCategories = applicantDocumentService.findAll();
        return ResponseEntity.ok(jobCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDataById(@PathVariable String id) {
        log.info("getDataById");
        ApplicantDocumentDto jobCategoryDto = applicantDocumentService.findById(id);
        return ResponseEntity.ok(jobCategoryDto);
    }

    @PutMapping
    public ResponseEntity updateApplicantDocument(@RequestBody ApplicantDocumentDto applicantDocument) {
        log.info("updateApplicantDocument");
        ApplicantDocumentDto updatedApplicantDocument = applicantDocumentService.update(applicantDocument);
        return ResponseEntity.ok(updatedApplicantDocument);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteApplicantDocument(@PathVariable String id) {
        log.info("deleteApplicantDocument");
        boolean isDeleted = applicantDocumentService.delete(id);
        return ResponseEntity.ok("ApplicantDocument with the id \"" + id + "\" is deleted Successfully");
    }
}
