package com.senipiper.solutions.liv2train.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "courses_offered")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoursesOffered {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "course_name")
    private String courseName;


}