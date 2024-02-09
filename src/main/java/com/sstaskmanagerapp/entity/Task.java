package com.sstaskmanagerapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "PROTOCOL")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;


    @Column(name = "EXPIRATION_DATE")
    private Date expirationDate;

    @Column(name = "STATUS")
    private TaskStatus status;
}
