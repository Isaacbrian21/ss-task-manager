package com.sstaskmanagerapp.service;

import com.sstaskmanagerapp.mapper.TaskMapper;
import com.sstaskmanagerapp.entity.TaskStatus;
import com.sstaskmanagerapp.repository.TaskRepository;
import com.sstaskmanagerapp.entity.Task;
import com.sstaskmanagerapp.request.TaskRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskManagerService {

    private final TaskRepository repository;
    public List<Task> getAll() {
        return repository.findAll();
    }

    public Optional<Task> findTaskById(Long protocol) {
        return repository.findById(protocol);
    }


    public Task createTask(TaskRequest request) {
        Task task = TaskMapper.task(request);
        if (task.getStatus() == null){
            task.setStatus(TaskStatus.NOVO);
        }
        return repository.save(task);
    }

    public Task updateTask(Long protocol, TaskRequest request){
        Optional<Task> task = repository.findById(protocol);

        if (task.isPresent()){
            task.get().setTitle(request.getTitle());
            task.get().setDescription(request.getDescription());
            task.get().setExpirationDate(request.getExpirationDate());
            if (request.getStatus() == null){
                task.get().setStatus(task.get().getStatus());
            }else {
                task.get().setStatus(request.getStatus());
            }
        }



        return repository.save(task.get());

    }

    public void deleteTask(Long protocol){
        Optional<Task> task = repository.findById(protocol);
        task.ifPresent(repository::delete);
    }
}
