package com.sstaskmanagerapp.controller;

import com.sstaskmanagerapp.entity.Task;
import com.sstaskmanagerapp.request.TaskRequest;
import com.sstaskmanagerapp.service.TaskManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/v1")
public class TaskController {


    private final TaskManagerService taskManagerService;


    @GetMapping("/taskList")
    public ResponseEntity<List<Task>> getTasksAvailable(){
        return ResponseEntity.ok(taskManagerService.getAll());
    }

    @GetMapping("/task/{protocol}")
    public ResponseEntity<Optional<Task>> getTaskByProtocol(@PathVariable Long protocol) {
        return ResponseEntity.ok(taskManagerService.findTaskById(protocol));
    }

    @PostMapping("/createTaks")
    public ResponseEntity<Task> createTaks(@RequestBody TaskRequest request){
        taskManagerService.createTask(request);
        log.info(request.getExpirationDate());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{protocol}")
    public ResponseEntity<Task> updateTask(@RequestBody TaskRequest request, @PathVariable Long protocol){
        taskManagerService.updateTask(protocol, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete/{protocol}")
    public void deleteTask(@PathVariable Long protocol) {
        taskManagerService.deleteTask(protocol);
    }

}
