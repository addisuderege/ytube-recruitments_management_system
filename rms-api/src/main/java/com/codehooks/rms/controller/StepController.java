package com.codehooks.rms.controller;

import com.codehooks.rms.dto.StepDto;
import com.codehooks.rms.dto.ResponseDto;
import com.codehooks.rms.entity.Step;
import com.codehooks.rms.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/steps")
public class StepController {

    @Autowired
    private StepService stepService;

    @PostMapping
    public ResponseEntity saveStep(@Valid @RequestBody StepDto step) {
        StepDto savedStep = stepService.save(step);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStep);
    }

    @GetMapping
    public ResponseEntity getAllJobCategories() {
        List<StepDto> jobCategories = stepService.findAll();
        return ResponseEntity.ok(jobCategories);
    }
    /*
    @GetMapping("/{id}")
    public ResponseEntity getDataById(@PathVariable String id) {
        StepDto jobCategoryDto = stepService.findById(id);
        return ResponseEntity.ok(jobCategoryDto);
    }
    */

    @PutMapping
    public ResponseEntity updateStep(@RequestBody StepDto step) {
        StepDto updatedStep = stepService.update(step);
        return ResponseEntity.ok(updatedStep);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStep(@PathVariable String id) {
        boolean isDeleted = stepService.delete(id);
        return ResponseEntity.ok(isDeleted);
    }
}
