package edu.isgb.school.entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="t_course")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_course")
    private Integer idCourse;

    @Column(name = "name_course",nullable=false)
    private String name;

    // Bidirectionnel avec School
    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private List<Instructor> instructors;

}
