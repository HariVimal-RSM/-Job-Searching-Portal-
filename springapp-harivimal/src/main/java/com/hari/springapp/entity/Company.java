package com.hari.springapp.entity;

import jakarta.persistence.*;  // ✅ Importing JPA annotations

// ✅ Declares this class as a JPA entity and maps it to the "Company" table
@Entity
@Table(name = "Company")
public class Company {

    // ✅ Primary key with auto-generation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int id;

    // ✅ Fields mapped to table columns
    @Column(name = "name")
    public String name;

    @Column(name = "location")
    public String location;

    @Column(name = "industry")
    public String industry;

    @Column(name = "description")
    public String desc;

    // ✅ No-args constructor (needed by JPA)
    public Company() {
    }

    // ✅ All-args constructor
    public Company(int id, String name, String location, String industry, String desc) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.industry = industry;
        this.desc = desc;
    }

    // ✅ Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
