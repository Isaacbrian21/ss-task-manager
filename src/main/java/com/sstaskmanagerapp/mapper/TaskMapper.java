package com.sstaskmanagerapp.mapper;

import com.sstaskmanagerapp.entity.Task;
import com.sstaskmanagerapp.request.TaskRequest;


public class TaskMapper {



        public static Task task(TaskRequest request){
            return   Task.builder()
                    .title(request.getTitle())
                    .description(request.getDescription())
                    .expirationDate(request.getExpirationDate())
                    .status(request.getStatus())
                    .build();
        }

}
