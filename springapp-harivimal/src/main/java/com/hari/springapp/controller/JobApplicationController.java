package com.hari.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.hari.springapp.entity.JobApplication;
import com.hari.springapp.service.JobApplicationService;

@Controller
public class JobApplicationController {

    @Autowired
    JobApplicationService obj;

    // ✅ 1. Get all job applications
    @GetMapping("/api/JobApplication/getAll")
    public ResponseEntity<List<JobApplication>> getAllJobApplication() {
        return new ResponseEntity<>(obj.getAll(), HttpStatus.OK);
    }

    // ✅ 2. Get job application by ID
    @GetMapping("/api/JobApplication/get/{id}")
    public ResponseEntity<?> getItem(@PathVariable int id) {
        Optional<JobApplication> data = obj.getItem(id);
        if (data.isPresent()) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("Job with ID " + id + " not found");
    }

    // ✅ 3. Create a new job application
    @PostMapping("/api/JobApplication/post")
    public ResponseEntity<JobApplication> postJob(@RequestBody JobApplication mess) {
        return new ResponseEntity<>(obj.postJob(mess), HttpStatus.OK);
    }

    // ✅ 4. Update job application details
    @PutMapping("/api/JobApplication/update/{id}")
    public ResponseEntity<?> updateData(@PathVariable int id, @RequestBody JobApplication mess) {
        Optional<JobApplication> item = obj.updateData(id, mess);
        if (item.isPresent()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("ID not found!");
    }

    // ✅ 5. Delete job application by ID
    @DeleteMapping("/api/JobApplication/delete/{id}")
    public ResponseEntity<?> deleteData(@PathVariable int id) {
        Optional<JobApplication> item = obj.deleteItems(id);
        if (item.isPresent()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("ID not found");
    }

    // ✅ 6. Get paginated job applications
    @GetMapping("api/JobApplication/getPage/{size}/{PageNo}")
    public ResponseEntity<?> getByPage(@PathVariable int PageNo, @PathVariable int size) {
        List<JobApplication> item = obj.getApplicationByPage(PageNo, size);
        if (!item.isEmpty()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("No items present");
    }

    // ✅ 7. Sort job applications by field
    @GetMapping("admin/sortBy/{field}")
    public ResponseEntity<List<JobApplication>> getSored(@PathVariable String field) {
        return new ResponseEntity<>(obj.sort(field), HttpStatus.OK);
    }
}
