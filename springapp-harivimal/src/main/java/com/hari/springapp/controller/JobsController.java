package com.hari.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.hari.springapp.entity.Jobs;
import com.hari.springapp.service.JobsService;

@Controller
@RequestMapping("api/jobs")
public class JobsController {

    @Autowired
    JobsService obj;

    // ✅ 1. Get all jobs
    @GetMapping
    public ResponseEntity<List<Jobs>> getAllJobs() {
        return new ResponseEntity<>(obj.getAll(), HttpStatus.OK);
    }

    // ✅ 2. Get job by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getItem(@PathVariable int id) {
        Optional<Jobs> data = obj.getItem(id);
        if (data.isPresent()) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("Job with ID " + id + " not found");
    }

    // ✅ 3. Create a new job
    @PostMapping
    public ResponseEntity<Jobs> postJob(@RequestBody Jobs mess) {
        return new ResponseEntity<>(obj.postJob(mess), HttpStatus.OK);
    }

    // ✅ 4. Update job details
    @PutMapping("/{id}")
    public ResponseEntity<?> updateData(@PathVariable int id, @RequestBody Jobs mess) {
        Optional<Jobs> item = obj.updateData(id, mess);
        if (item.isPresent()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("ID not found!");
    }

    // ✅ 5. Delete job by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteData(@PathVariable int id) {
        Optional<Jobs> item = obj.deleteItems(id);
        if (item.isPresent()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("ID not found");
    }
}
