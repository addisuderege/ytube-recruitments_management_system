package com.codehooks.rms.dao;

import com.codehooks.rms.entity.Applicant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApplicantRepo extends MongoRepository<Applicant, String> {
}