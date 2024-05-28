package peaksoft.repository;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseRepo {
    void  saveCourse(Long comId,Course course);
    List<Course> getAllCourses(Long ComId);
    Course getById(Long courseId);
    void updateCourse(Long courseId,Course newCourse);
    void  deleteCourse(Long courseId);
}
