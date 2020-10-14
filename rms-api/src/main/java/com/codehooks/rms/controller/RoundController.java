package com.codehooks.rms.controller;

import com.codehooks.rms.dto.RoundDto;
import com.codehooks.rms.dto.ResponseDto;
import com.codehooks.rms.entity.Round;
import com.codehooks.rms.service.RoundService;
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
@RequestMapping("/api/v1/rounds")
@Slf4j
public class RoundController {

    @Autowired
    private RoundService roundService;

    @PostMapping
    public ResponseEntity saveRound(@Valid @RequestBody RoundDto round) {
        log.info("saveRound");
        RoundDto savedRound = roundService.save(round);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRound);
    }

    @GetMapping
    public ResponseEntity getAllRounds() {
        log.info("getAllRound");
        List<RoundDto> jobCategories = roundService.findAll();
        return ResponseEntity.ok(jobCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDataById(@PathVariable String id) {
        log.info("getDataById");
        RoundDto jobCategoryDto = roundService.findById(id);
        return ResponseEntity.ok(jobCategoryDto);
    }

    @PutMapping
    public ResponseEntity updateRound(@RequestBody RoundDto round) {
        log.info("updateRound");
        RoundDto updatedRound = roundService.update(round);
        return ResponseEntity.ok(updatedRound);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRound(@PathVariable String id) {
        log.info("deleteRound");
        boolean isDeleted = roundService.delete(id);
        return ResponseEntity.ok("Round with the id \"" + id + "\" is deleted Successfully");
    }
}
