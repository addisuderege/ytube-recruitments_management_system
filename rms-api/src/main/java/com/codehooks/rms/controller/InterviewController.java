package com.codehooks.rms.controller;

import com.codehooks.rms.dto.InterviewDto;
import com.codehooks.rms.dto.ResponseDto;
import com.codehooks.rms.entity.Interview;
import com.codehooks.rms.service.InterviewService;
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
@RequestMapping("/api/v1/interviews")
@Slf4j
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @PostMapping
    public ResponseEntity saveInterview(@Valid @RequestBody InterviewDto interview) {
        log.info("saveInterview");
        InterviewDto savedInterview = interviewService.save(interview);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInterview);
    }

    @GetMapping
    public ResponseEntity getAllInterviews() {
        log.info("getAllInterview");
        List<InterviewDto> jobCategories = interviewService.findAll();
        return ResponseEntity.ok(jobCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDataById(@PathVariable String id) {
        log.info("getDataById");
        InterviewDto jobCategoryDto = interviewService.findById(id);
        return ResponseEntity.ok(jobCategoryDto);
    }

    @PutMapping
    public ResponseEntity updateInterview(@RequestBody InterviewDto interview) {
        log.info("updateInterview");
        InterviewDto updatedInterview = interviewService.update(interview);
        return ResponseEntity.ok(updatedInterview);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteInterview(@PathVariable String id) {
        log.info("deleteInterview");
        boolean isDeleted = interviewService.delete(id);
        return ResponseEntity.ok("Interview with the id \"" + id + "\" is deleted Successfully");
    }
}
