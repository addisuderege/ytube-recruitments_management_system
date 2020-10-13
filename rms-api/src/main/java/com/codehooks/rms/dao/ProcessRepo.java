package com.codehooks.rms.dao;

import com.codehooks.rms.entity.Process;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProcessRepo extends MongoRepository<Process, String> {
}