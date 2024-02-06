package com.sstaskmanagerapp.service;

import com.sstaskmanagerapp.repository.TaskRepository;
import com.sstaskmanagerapp.entity.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskManagerService {

    private final TaskRepository repository;
    public List<Task> getAll() {
        return repository.findAll();
    }
}
