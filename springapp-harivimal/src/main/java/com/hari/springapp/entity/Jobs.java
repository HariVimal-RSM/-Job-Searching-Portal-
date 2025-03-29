package com.hari.springapp.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "Jobs")
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "title")
    private String name;

    @Column(name = "company")
    private String company;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String desc;

    @Column(name = "salary")
    private int salary;

    @OneToMany(mappedBy = "job", cascade = CascadeType.MERGE, orphanRemoval = true)
    @JsonIgnore
    private List<JobApplication> jobApplications = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<JobApplication> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(List<JobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }

    public Jobs(Integer id, String name, String company, String location, String desc, int salary,
            List<JobApplication> jobApplications) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.location = location;
        this.desc = desc;
        this.salary = salary;
        this.jobApplications = jobApplications;
    }

    public Jobs() {
    }

    
    
}
