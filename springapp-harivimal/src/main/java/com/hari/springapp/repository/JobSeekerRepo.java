package com.hari.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.springapp.entity.JobSeeker;

public interface JobSeekerRepo extends JpaRepository<JobSeeker,Integer>{
    
}
