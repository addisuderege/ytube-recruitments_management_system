package com.codehooks.rms.dao;

import com.codehooks.rms.entity.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApplicationRepo extends MongoRepository<Application, String> {
}