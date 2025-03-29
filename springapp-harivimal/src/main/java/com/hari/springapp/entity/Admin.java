package com.hari.springapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")                     // ✅ Table mapping
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // ✅ Use IDENTITY for MySQL efficiency
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)             // ✅ Added nullable constraint
    private String name;

    @Column(name = "email", unique = true, nullable = false)  // ✅ Email should be unique
    private String email;

    // ✅ No-args constructor
    public Admin() {
    }

    // ✅ All-args constructor
    public Admin(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // ✅ Override toString() for easy debugging
    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
