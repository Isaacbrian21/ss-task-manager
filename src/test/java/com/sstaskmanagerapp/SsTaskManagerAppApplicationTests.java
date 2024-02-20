package com.sstaskmanagerapp;

import com.sstaskmanagerapp.entity.Task;
import com.sstaskmanagerapp.entity.TaskStatus;
import com.sstaskmanagerapp.mapper.TaskMapper;
import com.sstaskmanagerapp.repository.TaskRepository;
import com.sstaskmanagerapp.request.TaskRequest;
import com.sstaskmanagerapp.service.TaskManagerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class SsTaskManagerAppApplicationTests {

	@Mock
	private TaskRepository repository;

	@Mock
	private TaskRequest request;

	@Mock
	private TaskMapper mapper;

	@InjectMocks
	private TaskManagerService service;
	@Test
	void shouldGetAllTasks() {

		//Arrange
		Date date = new Date();
		Task task1 = new Task(1L, "dormir", "Quando der sono", date, TaskStatus.NOVO );
		Task task2 = new Task(2L, "dormir", "Quando der sono", date, TaskStatus.NOVO );

		List<Task> mockTask = Arrays.asList(task1, task2);

		when(repository.findAll()).thenReturn(mockTask);

		//Act
		List<Task> result = service.getAll();


		//Assert
		verify(repository, times(1)).findAll();

		assertEquals(result, mockTask);
	}



	@Test
	void givenIdShouldReturnATaskWhenItIsPassed(){
		Date date = new Date();
		Optional<Task> task1 = Optional.of(new Task(1L, "dormir", "Quando der sono", date, TaskStatus.NOVO));

		when(repository.findById(anyLong())).thenReturn(task1);


		Optional<Task> task = service.findTaskById(anyLong());


		verify(repository, times(1)).findById(anyLong());
		assertEquals(task1, task);
	}


	@Test
	void shouldCreateTaskWithDefaultStatusWhenStatusIsNull() {

		TaskRequest request = new TaskRequest("Test Task", "This is a test task", null, null);

		// TaskRepository repository = mock(TaskRepository.class);
		when(repository.save(any(Task.class))).thenAnswer(invocation -> invocation.getArgument(0));

		// TaskManagerService service = new TaskManagerService(repository);


		// Calling the method under test
		Task result = service.createTask(request);

		// Verifying that the status is set to default value TaskStatus.NOVO
		assertEquals(TaskStatus.NOVO, result.getStatus());
	}

}
