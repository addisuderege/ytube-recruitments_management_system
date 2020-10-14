package com.codehooks.rms.dao;

import com.codehooks.rms.entity.ApplicationStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApplicationStatusRepo extends MongoRepository<ApplicationStatus, String> {
}