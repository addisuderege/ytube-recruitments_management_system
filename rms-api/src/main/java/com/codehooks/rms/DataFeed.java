package com.codehooks.rms;

import com.codehooks.rms.entity.JobCategory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

public class DataFeed {

    public static List<JobCategory> jobCategories = Arrays.asList(
            JobCategory.builder().id("1").jobCategoryCode("FULL_STACK_DEV").jobCategoryName("Full Stack Developer").description("Full Stack Developer").build(),
            JobCategory.builder().id("2").jobCategoryCode("ANGULAR_DEV").jobCategoryName("Angular Developer").description("Angular Developer").build(),
            JobCategory.builder().id("3").jobCategoryCode("JAVA_DEV").jobCategoryName("Java Developer").description("Java Developer").build(),
            JobCategory.builder().id("4").jobCategoryCode("DB_ADMIN").jobCategoryName("Database Admin").description("Database Admin").build()
    );
}
