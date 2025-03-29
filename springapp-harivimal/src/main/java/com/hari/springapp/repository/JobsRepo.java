package com.hari.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.springapp.entity.Jobs;

public interface JobsRepo extends JpaRepository<Jobs,Integer>{
    
}
