package com.codehooks.rms.dao;

import com.codehooks.rms.entity.ApplicantDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApplicantDocumentRepo extends MongoRepository<ApplicantDocument, String> {
}