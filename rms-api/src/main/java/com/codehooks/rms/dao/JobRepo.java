package com.codehooks.rms.dao;

import com.codehooks.rms.entity.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepo extends MongoRepository<Job, String> {
}