package com.hari.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.springapp.entity.Company;

public interface CompanyRepo extends JpaRepository<Company,Integer>{
    
}
