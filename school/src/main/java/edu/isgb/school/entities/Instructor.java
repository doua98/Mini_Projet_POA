package edu.isgb.school.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@JsonIgnoreProperties({"school"})
@Entity
@Table(name="t_instructor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_instructor")
    private Integer idInstructor;

    @Column(name = "name_instructor",nullable = false)
    private String name;

    // Bidirectionnel avec Course
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "t_instructor_t_course",
            joinColumns = @JoinColumn(name = "instructors_pk_Instructor"),
            inverseJoinColumns = @JoinColumn(name = "courses_pk_course")
    )
    private List<Course> courses;

    // Bidirectionnel avec School
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="school_PK_school")
    @JsonIgnore
    private School school;

    /*
    cas 2bidirectionnel manytomany
     */
}
