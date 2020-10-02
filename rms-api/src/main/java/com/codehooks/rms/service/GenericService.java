package com.codehooks.rms.service;

import com.codehooks.rms.entity.JobCategory;

import java.util.List;

public interface GenericService<T> {

    // Reading all the records from DB
    List<T> findAll();

    // Save the record to DB
    T save(T object);

    // Update the record
    T update(T object);

    // Delete the record
    boolean delete(String id);
}
