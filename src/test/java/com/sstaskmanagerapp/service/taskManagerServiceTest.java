package com.sstaskmanagerapp.service;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class taskManagerServiceTest {

    @Test
    public void ShouldGetAllTasksWhenTheGetMethodIsCalling(){
        //Arrange
        TaskManagerService service = new TaskManagerService();
        private final Task task;


        //Act
        Task taskToTest = service.getAll();


        //Assert
        AssertEquals(task, taskToTest);
    }
}
