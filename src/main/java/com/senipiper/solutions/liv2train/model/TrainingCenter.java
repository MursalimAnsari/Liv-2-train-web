package com.senipiper.solutions.liv2train.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "training_center")
public class TrainingCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long centerId;

    @Column(name = "center_name")
    @Size(max = 40)
    private String centerName;

    @Column(name = "center_code")
    @Size(min = 12, max = 12)
    private String centerCode;

    @Column(name = "student_capacity")
    private Long studentCapacity;


    @Column(name = "contact_email")
    @NotBlank(message = "Email can not be blank")
    @Email
    @Pattern(regexp ="[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
    private String contactEmail;

    @Column(name = "created_on")
    @Builder.Default
    private Instant createdOn =  Instant.now();

    @Column(name = "contact_phone")
    @Size(max = 10)
    @NotBlank(message = "Contact can not be blank")
    private String contactPhone;

    @Embedded
    @Column(name = "address")
    private Address address;


    @Column(name = "courses_offered")
    @OneToMany(targetEntity = CoursesOffered.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "tc_fk", referencedColumnName = "centerId")
    private List<CoursesOffered> coursesOffered;



}

