package com.codehooks.rms.service.impl;

import com.codehooks.rms.dto.ApplicationStatusDto;
import com.codehooks.rms.dao.ApplicationStatusRepo;
import com.codehooks.rms.entity.ApplicationStatus;
import com.codehooks.rms.exceptions.DataNotFoundException;
import com.codehooks.rms.exceptions.RecordDeleteException;
import com.codehooks.rms.mappers.ApplicationStatusMapper;
import com.codehooks.rms.service.ApplicationStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationStatusServiceImpl implements ApplicationStatusService {

    @Autowired
    private ApplicationStatusRepo applicationStatusRepo;
    @Autowired
    private ApplicationStatusMapper applicationStatusMapper;

    @Override
    public List<ApplicationStatusDto> findAll() {
        List<ApplicationStatus> categories = applicationStatusRepo.findAll();
        if (categories == null || categories.isEmpty()) {
            throw new DataNotFoundException("Records Not Found");
        }
        return applicationStatusMapper.toDtoList(categories);
    }

    @Override
    public ApplicationStatusDto findById(String id) {
        Optional<ApplicationStatus> category = applicationStatusRepo.findById(id);
        category.orElseThrow(() -> new DataNotFoundException("Record Not Found with the id : " + id));
        return applicationStatusMapper.toDto(category.get());
    }

    @Override
    public ApplicationStatusDto save(ApplicationStatusDto applicationStatus) {
        ApplicationStatus category = applicationStatusRepo.save(applicationStatusMapper.fromDto(applicationStatus));
        return applicationStatusMapper.toDto(category);
    }

    @Override
    public ApplicationStatusDto update(ApplicationStatusDto applicationStatus) {
        ApplicationStatus category = applicationStatusRepo.save(applicationStatusMapper.fromDto(applicationStatus));
        return applicationStatusMapper.toDto(category);
    }

    @Override
    public boolean delete(String id) {
        Optional<ApplicationStatus> record = applicationStatusRepo.findById(id);
        record.orElseThrow(() -> new RecordDeleteException("Record not found with id : " + id));
        try {
            applicationStatusRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecordDeleteException("Error occurred while deleting the record with id : " + "id");
        }
    }


}