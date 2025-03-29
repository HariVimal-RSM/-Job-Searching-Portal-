package com.hari.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import com.hari.springapp.entity.Company;
import com.hari.springapp.repository.CompanyRepo;

@Service
public class CompanyService {
    @Autowired
    CompanyRepo obj;

    public List<Company> getAllCompanys() {
        return obj.findAll();
    }

    public Company postCompany(Company mess) {
        return obj.save(mess);
    }

    public Company updateDetails(Company mess, int id) {
        return obj.findById(id).map(e -> {
            if (mess.getName() != null) {
                e.setName(mess.getName());
            }
            if (mess.getLocation() != null) {
                e.setLocation(mess.getLocation());
            }
            if (mess.getIndustry() != null) {
                e.setIndustry(mess.getIndustry());
            }
            if (mess.getDesc() != null) {
                e.setDesc(mess.getDesc());
            }
            return obj.save(e);
        }).orElseThrow(() -> new RuntimeException("Id not found"));
    }

    public Optional<Company> deleteCompany(int id) {
        Optional<Company> data = obj.findById(id);
        if (data.isPresent()) {
            obj.deleteById(id);
            return data;
        }
        return Optional.empty();
    }

    public Optional<Company> getUser(int id) {
        Optional<Company> data = obj.findById(id);
        if (data.isPresent()) {
            return data;
        }
        return Optional.empty();
    }

    public List<Company> getCompanyByPage(int PageNo, int size) {
        Pageable page = PageRequest.of(PageNo, size);
        return obj.findAll(page).getContent();
    }

    public List<Company> sorted(String field)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,field);
        return obj.findAll(sort);
    }
}
