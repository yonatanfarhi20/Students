package org.example.students.service;

import org.example.students.dto.StudentDTO;
import org.example.students.model.Student;
import org.example.students.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // הזרקת ה-Repository דרך הקונסטרקטור
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // יצירת סטודנט - כאן מתבצעת ההמרה מהמחלקת עזר (DTO) לישות
    public Student createStudent(StudentDTO dto) {
        Student student = new Student();
        student.setUsername(dto.getUsername());
        student.setAge(dto.getAge());
        return studentRepository.save(student);
    }

    // קריאת כל הסטודנטים
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // קריאת סטודנט לפי ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    // עדכון סטודנט קיים באמצעות ה-DTO
    public Student updateStudent(Long id, StudentDTO dto) {
        Student student = getStudentById(id);
        student.setUsername(dto.getUsername());
        student.setAge(dto.getAge());
        return studentRepository.save(student);
    }

    // מחיקת סטודנט
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}