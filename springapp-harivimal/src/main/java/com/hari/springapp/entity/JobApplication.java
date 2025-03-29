package com.hari.springapp.entity;

import jakarta.persistence.*;  // ✅ Importing JPA annotations

// ✅ Declares this class as a JPA entity and maps it to the "JobApplication" table
@Entity
@Table(name = "JobApplication")
public class JobApplication {

    // ✅ Primary key with auto-generation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    // ✅ Fields mapped to table columns
    @Column(name = "seekerName")
    private String name;

    @ManyToOne
    @JoinColumn(name = "jobSeeker_id", referencedColumnName = "id", nullable = false)   // ✅ Many-to-One relationship with JobSeeker
    private JobSeeker jobseeker;

    @ManyToOne(optional = false)
    @JoinColumn(name = "job_id", referencedColumnName = "id", nullable = false)         // ✅ Many-to-One relationship with Jobs
    private Jobs job;

    @Column(name = "company")
    private String company;

    @Column(name = "ApplicationStatus")
    private String status;

    // ✅ No-args constructor (needed by JPA)
    public JobApplication() {
    }

    // ✅ All-args constructor
    public JobApplication(int id, String name, JobSeeker jobseeker, Jobs job, String company, String status) {
        this.id = id;
        this.name = name;
        this.jobseeker = jobseeker;
        this.job = job;
        this.company = company;
        this.status = status;
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

    public JobSeeker getJobseeker() {
        return jobseeker;
    }

    public void setJobseeker(JobSeeker jobseeker) {
        this.jobseeker = jobseeker;
    }

    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ✅ Override toString() for easy debugging
    @Override
    public String toString() {
        return "JobApplication{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jobseeker=" + jobseeker +
                ", job=" + job +
                ", company='" + company + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
