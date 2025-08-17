package com.example.student.StudentService;
import com.example.student.DTO.StudentDTO;
import com.example.student.Entity.Student;
import com.example.student.StudentRepository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // The @Service annotation indicates that this class is a service component in the Spring framework.
// It is typically used to define business logic and service layer operations.
// This class can be used to implement methods that handle student-related operations,
// such as creating, updating, deleting, and retrieving student records.

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentDTO> studentList() {
        List<Student> studentList = studentRepository.findAll();
        return studentList.stream()
                .map(student -> new StudentDTO(student.getId(), student.getName(), student.getEmail()))
                .toList();
    }


    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow( ()-> new RuntimeException("Student not found with id: + id"));
        if (student != null) {
            return new StudentDTO(student.getId(), student.getName(), student.getEmail());
        }
        return null;
    }

    public void addStudent(StudentDTO studentDTO) {
        Student student = new Student();
        List<Student> studentList = studentRepository.findAll();
        if(studentList.stream().anyMatch(s -> s.getEmail().equals(studentDTO.getEmail()))) {
            throw new RuntimeException("Student with email " + studentDTO.getEmail() + " already exists.");
        }
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        studentRepository.save(student);
    }



}
