package com.codehooks.rms.dao;

import com.codehooks.rms.entity.JobPosition;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobPositionRepo extends MongoRepository<JobPosition, String> {
}