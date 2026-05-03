package edu.isgb.school.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonIgnoreProperties({"hibernateLazyInitializer"})

@Entity
@Table(name="t_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ADDRESS")
    private Integer idAddress;

    @Column(nullable = false,name = "cl_street")
    private String street;

    @Column(nullable = false,name = "cl_city")
    private String city;

    @Column(nullable = false,name = "cl_postal_Code")
    private String postalCode;

}
