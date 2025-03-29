package com.hari.springapp.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.hari.springapp.entity.Admin;
import com.hari.springapp.service.AdminService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/")
public class AdminController {

    @Autowired
    AdminService obj;

    // ✅ 1. Get all admins
    @GetMapping("admins/get")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        return new ResponseEntity<>(obj.getAllAdmins(), HttpStatus.OK);
    }

    // ✅ 2. Get admin by ID
    @GetMapping("admins/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        Optional<Admin> item = obj.getUser(id);
        if (item.isPresent()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("Id not found");
    }

    // ✅ 3. Create a new admin
    @PostMapping("admins/post")
    public ResponseEntity<Optional<Admin>> postAdmin(@RequestBody Admin mess) {
        return new ResponseEntity<>(obj.postAdmin(mess), HttpStatus.OK);
    }

    // ✅ 4. Update admin details
    @PutMapping("admins/update/{id}")
    public ResponseEntity<?> updateAdmin(@RequestBody Admin mess, @PathVariable int id) {
        Optional<Admin> item = obj.updateDetails(mess, id);
        if (item.isPresent()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("Not found");
    }

    // ✅ 5. Delete admin by ID
    @DeleteMapping("admins/delete/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable int id) {
        Optional<Admin> item = obj.deleteAdmin(id);
        if (item.isPresent()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("not found");
    }

    // ✅ 6. Get paginated admins
    @GetMapping("getPage/{size}/{PageNo}")
    public ResponseEntity<?> getByPage(@PathVariable int PageNo, @PathVariable int size) {
        List<Admin> item = obj.getAdminsByPage(PageNo, size);
        if (!item.isEmpty()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("No items present");
    }

    // ✅ 7. Sort admins by field
    @GetMapping("admin/sortBy/{field}")
    public ResponseEntity<List<Admin>> getSored(@PathVariable String field) {
        return new ResponseEntity<>(obj.sort(field), HttpStatus.OK);
    }
}
