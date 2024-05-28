package peaksoft.servcie.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Student;
import peaksoft.repository.StudentRepo;
import peaksoft.servcie.StudentService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    @Override
    public String createStudent(Student student) {
        return studentRepo.createStudent(student);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepo.getStudentById(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.getAllStudents();
    }

    @Override
    public String updateStudent(Long studentId, Student newStudent) {
        return studentRepo.updateStudent(studentId, newStudent);
    }

    @Override
    public String deleteStudentById(Long studentId) {
        return studentRepo.deleteStudentById(studentId);
    }

    @Override
    public String assignStudentToGroup(Long studentId, Long groupId) {
        return studentRepo.assignStudentToGroup(studentId, groupId);
    }
}
