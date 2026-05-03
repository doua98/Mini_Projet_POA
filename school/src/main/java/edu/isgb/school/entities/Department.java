package edu.isgb.school.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(nullable = false,name = "cl_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_PK_school")
    @JsonBackReference
    private School school;

}
