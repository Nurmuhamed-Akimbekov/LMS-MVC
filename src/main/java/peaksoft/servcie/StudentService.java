package peaksoft.servcie;

import peaksoft.entity.Student;

import java.util.List;

public interface StudentService {
    String createStudent(Student student);

    Student getStudentById(Long studentId);

    List<Student> getAllStudents();

    String updateStudent(Long studentId, Student newStudent);

    String deleteStudentById(Long studentId);

    String assignStudentToGroup(Long studentId, Long groupId);
}
