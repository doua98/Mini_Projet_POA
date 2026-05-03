package edu.isgb.school.entities;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="t_department")
@Data  //generate getter setter tostring equals
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_department")
    private Integer idDepartment;

    @Column(name = "cl_name",nullable = false)
    private String name;

    // Bidirectionnel avec School
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_PK_school")
    private School school;

}
