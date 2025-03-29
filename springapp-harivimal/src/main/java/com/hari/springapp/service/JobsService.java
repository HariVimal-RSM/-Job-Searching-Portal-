package com.hari.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hari.springapp.entity.Jobs;
import com.hari.springapp.repository.JobsRepo;

//Alex Benedict Selva
@Service
public class JobsService {
    @Autowired
    JobsRepo obj;

    public List<Jobs> getAll() {
        return obj.findAll();
    }

    public Jobs postJob(Jobs mess) {
        return obj.save(mess);
    }

    public Optional<Jobs> updateData(int id, Jobs mess) {
        Optional<Jobs> data = obj.findById(id);
        if (data.isPresent()) {
            Jobs message = data.get();
            if (mess.getName() != null) {
                message.setName(mess.getName());
            }
            if (mess.getCompany() != null) {
                message.setCompany(mess.getCompany());
            }
            if (mess.getDesc() != null) {
                message.setDesc(mess.getDesc());
            }
            if (mess.getLocation() != null) {
                message.setLocation(mess.getLocation());
            }

            return Optional.of(obj.save(message));
        }
        return Optional.empty();
    }

    public Optional<Jobs> deleteItems(int id) {
        Optional<Jobs> data = obj.findById(id);
        if (data.isPresent()) {
            obj.deleteById(id);
            return data;
        }
        return Optional.empty();
    }
    
    public Optional<Jobs> getItem(int id) {
        Optional<Jobs> data = obj.findById(id);
        if (data.isPresent()) {
            return data;
        }
        return Optional.empty();
    }
}