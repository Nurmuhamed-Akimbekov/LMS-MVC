package peaksoft.repository;

import peaksoft.entity.Student;

import java.util.List;

public interface StudentRepo {
    String createStudent(Student student);

    Student getStudentById(Long studentId);

    List<Student> getAllStudents();

    String updateStudent(Long studentId, Student newStudent);

    String deleteStudentById(Long studentId);

    String assignStudentToGroup(Long studentId, Long groupId);
}
