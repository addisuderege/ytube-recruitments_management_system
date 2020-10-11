package com.codehooks.rms.dao;

import com.codehooks.rms.entity.JobCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface JobCategoryRepo extends MongoRepository<JobCategory, String> {

    Optional<JobCategory> findByJobCategoryCode(String value); // jobcategoryCode like 'value%'

    @Query("{ 'jobCategoryCode' : {$regex : ?0} }")
    Optional<JobCategory> findNames(String value);
}
