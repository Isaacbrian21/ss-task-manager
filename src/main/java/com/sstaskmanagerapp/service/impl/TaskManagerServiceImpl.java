package com.sstaskmanagerapp.service.impl;

import com.sstaskmanagerapp.entity.Task;
import com.sstaskmanagerapp.entity.TaskStatus;
import com.sstaskmanagerapp.mapper.TaskMapper;
import com.sstaskmanagerapp.repository.TaskRepository;
import com.sstaskmanagerapp.request.TaskRequest;
import com.sstaskmanagerapp.service.TaskManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskManagerServiceImpl implements TaskManagerService {

    private final TaskRepository repository;
    @Override
    public Optional<Task> findTaskById(Long protocol) {
        return repository.findById(protocol);
    }

    @Override
    public List<Task> getAll() {
        return repository.findAll();
    }

    @Override
    public Task createTask(TaskRequest request) {
        Task task = TaskMapper.task(request);
        if (task.getStatus() == null){
            task.setStatus(TaskStatus.NOVO);
        }
        return repository.save(task);
    }

    @Override
    public Task updateTask(Long protocol, TaskRequest request) {
        Optional<Task> task = repository.findById(protocol);
        Task taskToBeSaved = null;
        if (task.isPresent()){
            task.get().setTitle(request.getTitle());
            task.get().setDescription(request.getDescription());
            task.get().setExpirationDate(request.getExpirationDate());
            if (request.getStatus() == null){
                task.get().setStatus(task.get().getStatus());
            }
        }

        if (task.isPresent()) {
            taskToBeSaved = repository.save(task.get());
        }

        return taskToBeSaved;
    }

    @Override
    public void deleteTask(Long protocol) {
        Optional<Task> task = repository.findById(protocol);
        task.ifPresent(repository::delete);
    }
}
