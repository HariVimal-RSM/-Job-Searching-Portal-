package com.hari.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
// import org.springframework.data.domain.Sort;
import com.hari.springapp.entity.Admin;
import com.hari.springapp.repository.AdminRepo;

import jakarta.transaction.Transactional;

@Service
public class AdminService {
    @Autowired
    AdminRepo obj;

    public List<Admin> getAllAdmins() {
        return obj.getUsers();
    }

    public Optional<Admin> postAdmin(Admin mess) {
        obj.postPerson(mess.getId(), mess.getName(), mess.getEmail());

        Optional<Admin> data = obj.getSingleUser(mess.getId());
        
        return data;
        
    }

    public Optional<Admin> updateDetails(Admin mess, int id) {
        Optional<Admin> data = obj.getSingleUser(id);
        if (data.isPresent()) {
            if (mess.getName() != null) {
                obj.UpdateAdminName(id, mess.getName());
            }
            if (mess.getEmail() != null) {
                obj.UpdateAdminEmail(id, mess.getEmail());
            }
            return obj.getSingleUser(id);
        }
        return Optional.empty();

    }

    @Transactional
    public Optional<Admin> deleteAdmin(int id) {
        Optional<Admin> data = obj.findById(id);
        if (data.isPresent()) {
            obj.deleteAdmin(id);
            return data;
        }
        return Optional.empty();
    }

    public Optional<Admin> getUser(int id) {
        Optional<Admin> data = obj.getSingleUser(id);
        if (data.isPresent()) {
            return data;
        }
        return Optional.empty();
    }

    public List<Admin> getAdminsByPage(int PageNo, int size) {
        Pageable page = PageRequest.of(PageNo, size);
        return obj.findAll(page).getContent();
    }

    public List<Admin> sort(String field)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,field);
        return obj.findAll(sort);
    }
    
}
// Pageable page = PageRequest.of(pageNo,page);
// obj.findAll(page).getContent();

// Sort sort = Sort.by(Sort.Direction.ASC,field);
// obj.fin