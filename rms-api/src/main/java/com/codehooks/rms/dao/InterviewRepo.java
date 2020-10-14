package com.codehooks.rms.dao;

import com.codehooks.rms.entity.Interview;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterviewRepo extends MongoRepository<Interview, String> {
}