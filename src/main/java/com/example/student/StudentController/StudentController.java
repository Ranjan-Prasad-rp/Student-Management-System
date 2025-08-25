package com.example.student.StudentController;

import com.example.student.DTO.StudentDTO;
import com.example.student.StudentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/student")
// This annotation indicates that this class is a REST controller
// and will handle HTTP requests for student-related operations.
// The base path for this controller is set to "/student".
// The @RestController annotation combines @Controller and @ResponseBody,
// meaning that the methods in this class will return data directly
// in the response body, typically in JSON format.
public class StudentController {

    // constructor injection is used to inject the StudentService dependency into the StudentController.
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;

    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<StudentDTO>> getStudents() {
        List<StudentDTO> studentList = studentService.studentList();
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(studentList, HttpStatus.OK);

    }

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<?> studentHello(@PathVariable Long id) {
        try {
            StudentDTO student = studentService.getStudentById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            // return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>("No Student in DB  with id: " + id, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/url")
    // this method is used to check @Controller  vs @RestController (@ResponseBody)
    public ResponseEntity<Void> url() {
        return  ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
                .header("Location", "/urlChanged")
                .build();
}

    // This method is used to demonstrate a redirect to a new URL.
    // It returns a response with a message indicating that the URL has changed.
    // The @GetMapping annotation maps this method to the "/urlChanged" endpoint.

    @GetMapping("/urlChanged")
    public ResponseEntity<String> redirected(){
        return ResponseEntity.ok( "redirected to new site");
    }


    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO) {
        // Assuming you have a method in StudentService to add a student
        try {
            studentService.addStudent(studentDTO);
            return new ResponseEntity<>("Student added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding student: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        try {
            StudentDTO updatedStudent = studentService.updateStudent(id, studentDTO);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating student: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/updateField/{id}")
    public ResponseEntity<?> updateField(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        try {
            StudentDTO updatedStudent = studentService.updateStudent(id, studentDTO);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating student: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        try {
            studentService.deleteStudent(id);
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting student: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
