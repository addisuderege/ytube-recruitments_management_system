package com.codehooks.rms.service.impl;

import com.codehooks.rms.dto.ApplicationDto;
import com.codehooks.rms.dao.ApplicationRepo;
import com.codehooks.rms.entity.Application;
import com.codehooks.rms.exceptions.DataNotFoundException;
import com.codehooks.rms.exceptions.RecordDeleteException;
import com.codehooks.rms.mappers.ApplicationMapper;
import com.codehooks.rms.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepo applicationRepo;
    @Autowired
    private ApplicationMapper applicationMapper;

    @Override
    public List<ApplicationDto> findAll() {
        List<Application> categories = applicationRepo.findAll();
        if (categories == null || categories.isEmpty()) {
            throw new DataNotFoundException("Records Not Found");
        }
        return applicationMapper.toDtoList(categories);
    }

    @Override
    public ApplicationDto findById(String id) {
        Optional<Application> category = applicationRepo.findById(id);
        category.orElseThrow(() -> new DataNotFoundException("Record Not Found with the id : " + id));
        return applicationMapper.toDto(category.get());
    }

    @Override
    public ApplicationDto save(ApplicationDto application) {
        Application category = applicationRepo.save(applicationMapper.fromDto(application));
        return applicationMapper.toDto(category);
    }

    @Override
    public ApplicationDto update(ApplicationDto application) {
        Application category = applicationRepo.save(applicationMapper.fromDto(application));
        return applicationMapper.toDto(category);
    }

    @Override
    public boolean delete(String id) {
        Optional<Application> record = applicationRepo.findById(id);
        record.orElseThrow(() -> new RecordDeleteException("Record not found with id : " + id));
        try {
            applicationRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecordDeleteException("Error occurred while deleting the record with id : " + "id");
        }
    }


}