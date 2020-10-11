package com.codehooks.rms.dao;

import com.codehooks.rms.entity.Step;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StepRepo extends MongoRepository<Step, String> {
}