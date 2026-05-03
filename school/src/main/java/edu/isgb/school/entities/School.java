package edu.isgb.school.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@JsonIgnoreProperties({"students", "instructors"})
@Entity
@Table(name = "t_school")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_school")
    private Integer idSchool;

    @Column(nullable = false,name = "cl_name_school")
    private String name;

    @Column(nullable = false)
    private Integer phone;

    // Bidirectionnel avec Department
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Department> departments;

    // Bidirectionnel avec Instructor
    @OneToMany(mappedBy = "school",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Instructor> instructors;

    // Bidirectionnel avec Student
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students;
    /*
    cas 3 bidirectionnel
     */


}
