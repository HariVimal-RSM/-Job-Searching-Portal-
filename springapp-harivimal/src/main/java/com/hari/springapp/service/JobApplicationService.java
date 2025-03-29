package com.hari.springapp.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hari.springapp.entity.JobApplication;

import com.hari.springapp.entity.Jobs;
import com.hari.springapp.repository.JobApplicationRepo;
import com.hari.springapp.repository.JobSeekerRepo;
import com.hari.springapp.repository.JobsRepo;

import jakarta.transaction.Transactional;

@Service
public class JobApplicationService {
    @Autowired
    JobApplicationRepo obj;

    @Autowired
    private JobApplicationRepo jobApplicationRepo;

    @Autowired
    private JobsRepo jobsRepo;

    @Autowired
    private JobSeekerRepo jobseekerRepo;

    public List<JobApplication> getAll() {
        return obj.findAll();
    }

    @Transactional
    public JobApplication postJob(JobApplication mess) {
    
        return jobApplicationRepo.save(mess);
    }
    

    public Optional<JobApplication> updateData(int id, JobApplication mess) {
        Optional<JobApplication> data = obj.findById(id);
        if (data.isPresent()) {
            JobApplication message = data.get();
            if (mess.getName() != null) {
                message.setName(mess.getName());
            }
            if (mess.getCompany() != null) {
                message.setCompany(mess.getCompany());
            }
            if (mess.getStatus() != null) {
                message.setStatus(mess.getStatus());
            }

            return Optional.of(obj.save(message));
        }
        return Optional.empty();
    }

    public Optional<JobApplication> deleteItems(int id) {
        Optional<JobApplication> data = obj.findById(id);
        if (data.isPresent()) {
            obj.deleteById(id);
            return data;
        }
        return Optional.empty();
    }
    
    public Optional<JobApplication> getItem(int id) {
        Optional<JobApplication> data = obj.findById(id);
        if (data.isPresent()) {
            return data;
        }
        return Optional.empty();
    }

    public List<JobApplication> getApplicationByPage(int PageNo, int size) {
        Pageable page = PageRequest.of(PageNo, size);
        return obj.findAll(page).getContent();
    }

    public List<JobApplication> sort(String field)
    {
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        return obj.findAll(sort);
    }
    
    public JobApplication saveJobApplication(JobApplication jobApplication) {
        if (jobApplication.getJob() == null || jobApplication.getJob().getId() == 0) {
            throw new IllegalArgumentException("Job must be provided and exist.");
        }

        // Fetch existing job from DB
        Jobs existingJob = jobsRepo.findById(jobApplication.getJob().getId())
        .orElseThrow(() -> new RuntimeException("Job not found!"));
        
        // Set the job reference in the application
        jobApplication.setJob(existingJob);

        return jobApplicationRepo.save(jobApplication);
    }
}
