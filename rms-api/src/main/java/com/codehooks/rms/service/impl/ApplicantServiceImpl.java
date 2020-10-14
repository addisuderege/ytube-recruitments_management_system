package com.codehooks.rms.service.impl;

import com.codehooks.rms.dto.ApplicantDto;
import com.codehooks.rms.dao.ApplicantRepo;
import com.codehooks.rms.entity.Applicant;
import com.codehooks.rms.exceptions.DataNotFoundException;
import com.codehooks.rms.exceptions.RecordDeleteException;
import com.codehooks.rms.mappers.ApplicantMapper;
import com.codehooks.rms.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantRepo applicantRepo;
    @Autowired
    private ApplicantMapper applicantMapper;

    @Override
    public List<ApplicantDto> findAll() {
        List<Applicant> categories = applicantRepo.findAll();
        if (categories == null || categories.isEmpty()) {
            throw new DataNotFoundException("Records Not Found");
        }
        return applicantMapper.toDtoList(categories);
    }

    @Override
    public ApplicantDto findById(String id) {
        Optional<Applicant> category = applicantRepo.findById(id);
        category.orElseThrow(() -> new DataNotFoundException("Record Not Found with the id : " + id));
        return applicantMapper.toDto(category.get());
    }

    @Override
    public ApplicantDto save(ApplicantDto applicant) {
        Applicant category = applicantRepo.save(applicantMapper.fromDto(applicant));
        return applicantMapper.toDto(category);
    }

    @Override
    public ApplicantDto update(ApplicantDto applicant) {
        Applicant category = applicantRepo.save(applicantMapper.fromDto(applicant));
        return applicantMapper.toDto(category);
    }

    @Override
    public boolean delete(String id) {
        Optional<Applicant> record = applicantRepo.findById(id);
        record.orElseThrow(() -> new RecordDeleteException("Record not found with id : " + id));
        try {
            applicantRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecordDeleteException("Error occurred while deleting the record with id : " + "id");
        }
    }


}