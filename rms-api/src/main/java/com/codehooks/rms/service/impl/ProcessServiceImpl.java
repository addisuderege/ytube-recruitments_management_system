package com.codehooks.rms.service.impl;

import com.codehooks.rms.dto.ProcessDto;
import com.codehooks.rms.dao.ProcessRepo;
import com.codehooks.rms.entity.Process;
import com.codehooks.rms.exceptions.DataNotFoundException;
import com.codehooks.rms.exceptions.RecordDeleteException;
import com.codehooks.rms.mappers.ProcessMapper;
import com.codehooks.rms.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ProcessRepo processRepo;
    @Autowired
    private ProcessMapper processMapper;

    @Override
    public List<ProcessDto> findAll() {
        List<Process> categories = processRepo.findAll();
        if (categories == null || categories.isEmpty()) {
            throw new DataNotFoundException("Records Not Found");
        }
        return processMapper.toDtoList(categories);
    }

    @Override
    public ProcessDto findById(String id) {
        Optional<Process> category = processRepo.findById(id);
        category.orElseThrow(() -> new DataNotFoundException("Record Not Found with the id : " + id));
        return processMapper.toDto(category.get());
    }

    @Override
    public ProcessDto save(ProcessDto process) {
        Process category = processRepo.save(processMapper.fromDto(process));
        return processMapper.toDto(category);
    }

    @Override
    public ProcessDto update(ProcessDto process) {
        Process category = processRepo.save(processMapper.fromDto(process));
        return processMapper.toDto(category);
    }

    @Override
    public boolean delete(String id) {
        Optional<Process> record = processRepo.findById(id);
        record.orElseThrow(() -> new RecordDeleteException("Record not found with id : " + id));
        try {
            processRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecordDeleteException("Error occurred while deleting the record with id : " + "id");
        }
    }


}