package edu.isgb.school.test;

import edu.isgb.school.entities.Course;
import edu.isgb.school.entities.Instructor;
import edu.isgb.school.entities.School;
import edu.isgb.school.entities.Student;
import edu.isgb.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestSchoolController {

    @Autowired
    private SchoolService schoolService;

    // School endpoints
    @PostMapping("/schools")
    public School createSchool(@RequestBody School school) {
        return schoolService.createSchool(school);
    }

    @GetMapping("/schools/{id}")
    public School getSchool(@PathVariable Integer id) {
        return schoolService.getSchoolById(id);
    }

    // Student endpoints
    @PostMapping("/schools/{schoolId}/students")
    public Student createStudent(@RequestBody Student student, @PathVariable Integer schoolId) {
        return schoolService.createStudent(student, schoolId);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return schoolService.listStudents();
    }

    // Instructor endpoints
    @PostMapping("/schools/{schoolId}/instructors")
    public Instructor createInstructor(@RequestBody Instructor instructor, @PathVariable Integer schoolId) {
        return schoolService.createInstructor(instructor, schoolId);
    }

    @GetMapping("/instructors/name/{name}")
    public List<Instructor> getInstructorsByName(@PathVariable String name) {
        return schoolService.getInstructorsByName(name);
    }

    @GetMapping("/instructors/{id}")
    public Instructor getInstructor(@PathVariable Integer id) {
        return schoolService.getInstructorById(id);
    }

    @GetMapping("/instructors/{id}/courses")
    public List<Course> getInstructorCourses(@PathVariable Integer id) {
        return schoolService.getCoursesByInstructorId(id);
    }

    @PostMapping("/instructors/{id}/courses")
    public Course addCourseToInstructor(@RequestBody Course course, @PathVariable Integer id) {
        return schoolService.addCourseToInstructor(course, id);
    }
}