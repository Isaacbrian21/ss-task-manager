package com.sstaskmanagerapp.service;
import com.sstaskmanagerapp.entity.Task;
import com.sstaskmanagerapp.request.TaskRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskManagerService {

    public Optional<Task> findTaskById(Long protocol);


    public List<Task> getAll();

    public Task createTask(TaskRequest request);


    public Task updateTask(Long protocol, TaskRequest request);


    public void deleteTask(Long protocol);

}
