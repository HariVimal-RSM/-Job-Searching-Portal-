package com.hari.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hari.springapp.entity.JobSeeker;
import com.hari.springapp.repository.JobSeekerRepo;

@Service
public class JobSeekerService {
    @Autowired
    JobSeekerRepo obj;

    public List<JobSeeker> getAllSeekers() {
        return obj.findAll();
    }

    public JobSeeker PostData(JobSeeker mess) {
        return obj.save(mess);
    }
    
    public Optional<JobSeeker> UpdateUser(JobSeeker mess, int id) {

        Optional<JobSeeker> data = obj.findById(id);
        if (data.isPresent()) {
            JobSeeker message = data.get();

            if (mess.getName() != null) {
                message.setName(mess.getName());
            }
            if (mess.getPhoneNumber() != null) {
                message.setPhoneNumber(mess.getPhoneNumber());
            }
            if (mess.getEmail() != null) {
                message.setEmail(mess.getEmail());
            }
            if (mess.getResumeUrl() != null) {
                message.setResumeUrl(mess.getResumeUrl());
            }
            if (mess.getSkills() != null) {
                message.setSkills(mess.getSkills());
            }

            return Optional.of(obj.save(message));
        }
        return Optional.empty();
    }

    public Optional<JobSeeker> deleteUser(int id) {
        Optional<JobSeeker> findUser = obj.findById(id);
        if (findUser.isPresent()) {
            obj.deleteById(id);
            return findUser;
        }
        return Optional.empty();
    }

    public Optional<JobSeeker> getSingleUser(int id) {
        Optional<JobSeeker> data = obj.findById(id);
        return data;
    }
}

