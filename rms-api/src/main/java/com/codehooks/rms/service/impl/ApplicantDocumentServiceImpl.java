package com.codehooks.rms.service.impl;

import com.codehooks.rms.dto.ApplicantDocumentDto;
import com.codehooks.rms.dao.ApplicantDocumentRepo;
import com.codehooks.rms.entity.ApplicantDocument;
import com.codehooks.rms.exceptions.DataNotFoundException;
import com.codehooks.rms.exceptions.RecordDeleteException;
import com.codehooks.rms.mappers.ApplicantDocumentMapper;
import com.codehooks.rms.service.ApplicantDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantDocumentServiceImpl implements ApplicantDocumentService {

    @Autowired
    private ApplicantDocumentRepo applicantDocumentRepo;
    @Autowired
    private ApplicantDocumentMapper applicantDocumentMapper;

    @Override
    public List<ApplicantDocumentDto> findAll() {
        List<ApplicantDocument> categories = applicantDocumentRepo.findAll();
        if (categories == null || categories.isEmpty()) {
            throw new DataNotFoundException("Records Not Found");
        }
        return applicantDocumentMapper.toDtoList(categories);
    }

    @Override
    public ApplicantDocumentDto findById(String id) {
        Optional<ApplicantDocument> category = applicantDocumentRepo.findById(id);
        category.orElseThrow(() -> new DataNotFoundException("Record Not Found with the id : " + id));
        return applicantDocumentMapper.toDto(category.get());
    }

    @Override
    public ApplicantDocumentDto save(ApplicantDocumentDto applicantDocument) {
        ApplicantDocument category = applicantDocumentRepo.save(applicantDocumentMapper.fromDto(applicantDocument));
        return applicantDocumentMapper.toDto(category);
    }

    @Override
    public ApplicantDocumentDto update(ApplicantDocumentDto applicantDocument) {
        ApplicantDocument category = applicantDocumentRepo.save(applicantDocumentMapper.fromDto(applicantDocument));
        return applicantDocumentMapper.toDto(category);
    }

    @Override
    public boolean delete(String id) {
        Optional<ApplicantDocument> record = applicantDocumentRepo.findById(id);
        record.orElseThrow(() -> new RecordDeleteException("Record not found with id : " + id));
        try {
            applicantDocumentRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecordDeleteException("Error occurred while deleting the record with id : " + "id");
        }
    }


}