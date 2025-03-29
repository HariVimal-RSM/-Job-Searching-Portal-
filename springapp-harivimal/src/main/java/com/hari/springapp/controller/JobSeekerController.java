package com.hari.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.hari.springapp.entity.JobSeeker;
import com.hari.springapp.service.JobSeekerService;

@Controller
public class JobSeekerController {

    @Autowired
    JobSeekerService obj;

    // ✅ 1. Get all job seekers
    @GetMapping("/api/jobseekers/get")
    public ResponseEntity<List<JobSeeker>> getAllUsers() {
        return new ResponseEntity<>(obj.getAllSeekers(), HttpStatus.OK);
    }

    // ✅ 2. Get job seeker by ID
    @GetMapping("/api/jobseekers/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        Optional<JobSeeker> data = obj.getSingleUser(id);
        if (data.isPresent()) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("ID not found");
    }

    // ✅ 3. Create a new job seeker
    @PostMapping("/api/jobseekers/post")
    public ResponseEntity<JobSeeker> PostData(@RequestBody JobSeeker mess) {
        return new ResponseEntity<>(obj.PostData(mess), HttpStatus.OK);
    }

    // ✅ 4. Update job seeker details
    @PutMapping("/api/jobseekers/update/{id}")
    public ResponseEntity<?> UpdateData(@RequestBody JobSeeker mess, @PathVariable int id) {
        Optional<JobSeeker> data = obj.UpdateUser(mess, id);
        if (data.isPresent()) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("ID not found");
    }

    // ✅ 5. Delete job seeker by ID
    @DeleteMapping("/api/jobseekers/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        Optional<JobSeeker> data = obj.deleteUser(id);
        if (data.isPresent()) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("ID not found");
    }
}
