package com.hari.springapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hari.springapp.entity.Admin;

import jakarta.transaction.Transactional;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

    // ✅ Insert query using named parameters for better readability
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO admin (id, name, email) VALUES (:id, :name, :email)", nativeQuery = true)
    void postPerson(int id, String name, String email);

    // ✅ Delete query with better parameter handling
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM admin WHERE id = :id", nativeQuery = true)
    int deleteAdmin(int id);

    // ✅ Retrieve all admins using JPQL (Java Persistence Query Language)
    @Query("SELECT a FROM Admin a")
    List<Admin> getUsers();

    // ✅ Retrieve a single user with JPQL
    @Query("SELECT a FROM Admin a WHERE a.id = :id")
    Optional<Admin> getSingleUser(int id);

    // ✅ Update admin name using named parameters
    @Modifying
    @Transactional
    @Query(value = "UPDATE admin SET name = :value WHERE id = :id", nativeQuery = true)
    void UpdateAdminName(int id, String value);

    // ✅ Update admin email using named parameters
    @Modifying
    @Transactional
    @Query(value = "UPDATE admin SET email = :value WHERE id = :id", nativeQuery = true)
    void UpdateAdminEmail(int id, String value);
}
