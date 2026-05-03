package edu.isgb.school.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="t_student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_student")
    private Integer idStudent;

    @Column(name = "cl_name_student",nullable=false)
    private String name;

    @Column(name = "cl_birthdate",nullable = false)
    private LocalDate birthDate;

    // Unidirectionnel vers Address
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_PK_ADDRESS")
    private Address address;

    /*
    cas 3 one to one uniderectionel
     */

    // Bidirectionnel avec School
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_PK_school")
    @JsonBackReference
    private School school;

}
