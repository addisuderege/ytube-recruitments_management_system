package com.codehooks.rms.dao;

import com.codehooks.rms.entity.Round;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoundRepo extends MongoRepository<Round, String> {
}