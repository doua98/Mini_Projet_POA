package edu.isgb.school.service;

import edu.isgb.school.entities.*;
import edu.isgb.school.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepo;

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private InstructorRepository instructorRepo;

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private DepartmentRepository departmentRepo;

    // a. Créer une nouvelle School avec Students, Instructors et Departments
    public School createSchool(School school) {
        return schoolRepo.save(school);
    }

    // b. Retourner une School par id
    public School getSchoolById(Integer id) {
        return schoolRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("School not found id: " + id));
    }

    // c. Créer un Student
    public Student createStudent(Student student, Integer schoolId) {
        School school = schoolRepo.findById(schoolId)
                .orElseThrow(() -> new RuntimeException("School not found id: " + schoolId));
        student.setSchool(school);
        return studentRepo.save(student);
    }

    // d. Lister tous les Students
    public List<Student> listStudents() {
        return studentRepo.findAll();
    }

    public Instructor createInstructor(Instructor instructor, Integer schoolId) {
        School school = schoolRepo.findById(schoolId)
                .orElseThrow(() -> new RuntimeException("School not found id: " + schoolId));
        instructor.setSchool(school);

        if (instructor.getCourses() != null) {
            for (Course c : instructor.getCourses()) {
                c.getInstructors().add(instructor);
            }
        }
        return instructorRepo.save(instructor);
    }

    // f. Lister les Instructors par nom
    public List<Instructor> getInstructorsByName(String name) {
        return instructorRepo.findByName(name);
    }

    // g. Retourner un Instructor par id
    public Instructor getInstructorById(Integer id) {
        return instructorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found id: " + id));
    }

    // h. Retourner un Course par id
    public Course getCourseById(Integer id) {
        return courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found id: " + id));
    }

    // i. Lister les Courses d’un Instructor par id
    public List<Course> getCoursesByInstructorId(Integer id) {
        Instructor instructor = getInstructorById(id);
        return instructor.getCourses();
    }

    // j. Ajouter un nouveau Course à un Instructor existant
    public Course addCourseToInstructor(Course course, Integer instructorId) {
        Instructor instructor = getInstructorById(instructorId);
        instructor.getCourses().add(course);
        course.getInstructors().add(instructor);
        return courseRepo.save(course);
    }
}