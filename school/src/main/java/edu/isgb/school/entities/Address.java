package edu.isgb.school.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="t_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ADDRESS")
    private Integer idAddress;

    @Column(name = "cl_street",nullable = false)
    private String street;

    @Column(name = "cl_city",nullable = false)
    private String city;

    @Column(name = "cl_postal_Code",nullable = false)
    private String postalCode;

}
