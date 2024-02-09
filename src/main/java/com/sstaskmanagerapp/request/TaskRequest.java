package com.sstaskmanagerapp.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sstaskmanagerapp.entity.TaskStatus;
import lombok.*;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {


        private String title;

        private String description;

        @JsonFormat(pattern="dd-MM-yyyy")
        private Date expirationDate;

        private TaskStatus status;





    }

