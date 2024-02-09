package com.sstaskmanagerapp.repository;

import com.sstaskmanagerapp.entity.Task;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


}
