package com.sstaskmanagerapp.controller;

import com.sstaskmanagerapp.entity.Task;
import com.sstaskmanagerapp.service.TaskManagerService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class TaskController {

    private final TaskManagerService taskManagerService;


    @GetMapping("/taskList")
    public ResponseEntity<List<Task>> getTasksAvailable(){
        return ResponseEntity.ok(taskManagerService.getAll());
    }

}
