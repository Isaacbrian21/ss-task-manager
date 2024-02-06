package com.sstaskmanagerapp.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private Integer id;

    private String title;

    private String description;

    private Date validateDate;

    private TaskStatus status;
}
