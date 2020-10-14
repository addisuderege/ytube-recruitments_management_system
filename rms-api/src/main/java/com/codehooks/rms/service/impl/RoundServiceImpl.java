package com.codehooks.rms.service.impl;

import com.codehooks.rms.dto.RoundDto;
import com.codehooks.rms.dao.RoundRepo;
import com.codehooks.rms.entity.Round;
import com.codehooks.rms.exceptions.DataNotFoundException;
import com.codehooks.rms.exceptions.RecordDeleteException;
import com.codehooks.rms.mappers.RoundMapper;
import com.codehooks.rms.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoundServiceImpl implements RoundService {

    @Autowired
    private RoundRepo roundRepo;
    @Autowired
    private RoundMapper roundMapper;

    @Override
    public List<RoundDto> findAll() {
        List<Round> categories = roundRepo.findAll();
        if (categories == null || categories.isEmpty()) {
            throw new DataNotFoundException("Records Not Found");
        }
        return roundMapper.toDtoList(categories);
    }

    @Override
    public RoundDto findById(String id) {
        Optional<Round> category = roundRepo.findById(id);
        category.orElseThrow(() -> new DataNotFoundException("Record Not Found with the id : " + id));
        return roundMapper.toDto(category.get());
    }

    @Override
    public RoundDto save(RoundDto round) {
        Round category = roundRepo.save(roundMapper.fromDto(round));
        return roundMapper.toDto(category);
    }

    @Override
    public RoundDto update(RoundDto round) {
        Round category = roundRepo.save(roundMapper.fromDto(round));
        return roundMapper.toDto(category);
    }

    @Override
    public boolean delete(String id) {
        Optional<Round> record = roundRepo.findById(id);
        record.orElseThrow(() -> new RecordDeleteException("Record not found with id : " + id));
        try {
            roundRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecordDeleteException("Error occurred while deleting the record with id : " + "id");
        }
    }


}