package peaksoft.repository.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Group;
import peaksoft.entity.Student;
import peaksoft.repository.StudentRepo;

import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class StudentRepoImpl implements StudentRepo {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public String createStudent(Student student) {
        entityManager.persist(student);
        return "Student created";
    }

    @Override
    public Student getStudentById(Long studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public String updateStudent(Long studentId, Student newStudent) {
        Student student = getStudentById(studentId);
        student.setFirstName(newStudent.getFirstName());
        student.setLastName(newStudent.getLastName());
        student.setEmail(newStudent.getEmail());
        student.setPhoneNumber(newStudent.getPhoneNumber());
        student.setFormatStudy(newStudent.getFormatStudy());
        entityManager.merge(student);
        return "Student updated";
    }

    @Override
    public String deleteStudentById(Long studentId) {
        Student student = getStudentById(studentId);
        entityManager.remove(student);
        return "Student deleted";
    }

    @Override
    public String assignStudentToGroup(Long studentId, Long groupId) {
        Student student = getStudentById(studentId);
        Group group = entityManager.find(Group.class, groupId);

        student.setGroup(group);
        group.getStudents().add(student);

        entityManager.merge(group);
        return "Student assigned to group";
    }
}
