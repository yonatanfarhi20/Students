package org.example.students.controller;

import jakarta.validation.Valid;
import org.example.students.dto.StudentDTO;
import org.example.students.model.Student;
import org.example.students.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    // הזרקת ה-Service דרך הקונסטרקטור
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // יצירת סטודנט (Create)
    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDTO dto) {
        return ResponseEntity.ok(studentService.createStudent(dto));
    }

    // קבלת כל הסטודנטים (Read All)
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // קבלת סטודנט לפי מזהה (Read One)
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    // עדכון סטודנט (Update)
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentDTO dto) {
        return ResponseEntity.ok(studentService.updateStudent(id, dto));
    }

    // מחיקת סטודנט (Delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}