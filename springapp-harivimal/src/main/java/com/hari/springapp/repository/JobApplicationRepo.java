package com.hari.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.springapp.entity.JobApplication;

public interface JobApplicationRepo extends JpaRepository<JobApplication,Integer>{

}
