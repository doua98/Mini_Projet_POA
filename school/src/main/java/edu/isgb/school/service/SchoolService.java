package edu.isgb.school.service;


import edu.isgb.school.repository.*;
import edu.isgb.school.entities.Course;
import edu.isgb.school.entities.Instructor;
import edu.isgb.school.entities.School;
import edu.isgb.school.entities.Student;
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

    public School createSchool(School school) {

        return schoolRepo.save(school);
    }

    public School getSchoolById(Integer id){
        return schoolRepo.findById(id).orElseThrow(() -> new RuntimeException("School not found id: " + id));
    }

    public Student CreateStudent(Student student){
        return studentRepo.save(student);
    }

    public List<Student> Affiche_Students(){

        return studentRepo.findAll();
    }

    public Instructor createInstructor(Instructor instructor){

        return instructorRepo.save(instructor);
    }

    public List<Instructor> GetInstructorsByName(String name){

        return instructorRepo.getInstructorsByName(name);
    }

    public Instructor getInstructorById(Integer id){
        return instructorRepo.findById(id).orElseThrow(() -> new RuntimeException("Instructor not found with id: " + id));
    }

    public Course getCourseById(Integer id){
        return courseRepo.findById(id).orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    public List<Course> getCourseByInstructorId(Integer id){
        Instructor instructor=getInstructorById(id);
        return instructor.getCourses();

    }

    public Course RajouteCourse(Course c,Integer instructorId){
        Instructor instructor = getInstructorById(instructorId);

        instructor.getCourses().add(c);
        c.getInstructors().add(instructor);

        return courseRepo.save(c);

    }


}
