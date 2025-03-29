package com.hari.springapp.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.hari.springapp.entity.Company;
import com.hari.springapp.service.CompanyService;

@Controller
public class CompanyController {

    @Autowired
    CompanyService obj;

    // ✅ 1. Get all companies
    @GetMapping("api/Companys/get")
    public ResponseEntity<List<Company>> getAllCompanys() {
        return new ResponseEntity<>(obj.getAllCompanys(), HttpStatus.OK);
    }

    // ✅ 2. Get company by ID
    @GetMapping("/api/Companys/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        Optional<Company> item = obj.getUser(id);
        if (item.isPresent()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("Id not found");
    }

    // ✅ 3. Create a new company
    @PostMapping("api/Companys/post")
    public ResponseEntity<Company> postCompany(@RequestBody Company mess) {
        return new ResponseEntity<>(obj.postCompany(mess), HttpStatus.OK);
    }

    // ✅ 4. Update company details
    @PutMapping("/api/Companys/update/{id}")
    public ResponseEntity<Company> updateCompany(@RequestBody Company mess, @PathVariable int id) {
        return new ResponseEntity<>(obj.updateDetails(mess, id), HttpStatus.OK);
    }

    // ✅ 5. Delete company by ID
    @DeleteMapping("/api/Companys/delete/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable int id) {
        Optional<Company> item = obj.deleteCompany(id);
        if (item.isPresent()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        // Custom error message using Map
        Map<String, String> response = new LinkedHashMap<>();
        response.put("Success", "false");
        response.put("Message", "id not found");
        return ResponseEntity.status(404).body(response);
    }

    // ✅ 6. Get paginated companies
    @GetMapping("/api/company/pagination/{size}/{PageNo}")
    public ResponseEntity<?> getByPage(@PathVariable int PageNo, @PathVariable int size) {
        List<Company> item = obj.getCompanyByPage(PageNo, size);
        if (!item.isEmpty()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("No items present");
    }

    // ✅ 7. Sort companies by field
    @GetMapping("/company/sortBy/{field}")
    public ResponseEntity<List<Company>> getSored(@PathVariable String field) {
        return new ResponseEntity<>(obj.sorted(field), HttpStatus.OK);
    }
}
