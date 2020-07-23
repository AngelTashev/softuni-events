package com.demo.events.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students-all")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/students-update")
    public ResponseEntity<List<Student>> updateAllStudents() {
        return ResponseEntity.ok(studentService.updateAllStudents());
    }

    @GetMapping("/students-delete")
    public ResponseEntity<List<Student>> deleteAllStudents() {
        studentService.evictCache();
        return ResponseEntity.ok().build();
    }
}
