package com.example.student.StudentRepository;

import com.example.student.Entity.StudentLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StudentLoginRepo extends JpaRepository<StudentLogin, Long> {
   Optional<StudentLogin> findByUsername(String username);
}
