package com.sstaskmanagerapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Tasks")
@Entity
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "PROTOCOL")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Lob
    @Column(name = "TASK_DESCRIPTION")
    private String description;


    @Column(name = "EXPIRATION_DATE")
    private Date expirationDate;

    @Column(name = "TASK_STATUS")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

}


























