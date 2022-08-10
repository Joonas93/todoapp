package fi.joonas.rekrytehtava.todoapp.service;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import fi.joonas.rekrytehtava.todoapp.dao.task.TaskDAO;
import fi.joonas.rekrytehtava.todoapp.entity.Task;
import fi.joonas.rekrytehtava.todoapp.model.TaskStatus;
@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {
	@InjectMocks
	private TaskServiceImpl taskService;
	@Mock
	private TaskDAO taskDAO;
	
	Task task;
	
	@BeforeEach
	public void beforeEach() {
		task = createValidTask();
	}
	

	@Test
	void testPersist() {
		taskService.persist(task);
		Mockito.verify(taskDAO).persist(task);
	}
	@Test
	void testDelete() {
		taskService.deleteTask(task);
		Mockito.verify(taskDAO).delete(task);
	}
	@Test
	void testFinishTask() {
		taskService.finishTask(task);
		assertEquals(TaskStatus.FINISHED, task.getStatus());
		Mockito.verify(taskDAO).update(task);
	}
	
	private Task createValidTask() {
		Task task = new Task();
		task.setId(1l);
		task.setDescription("testi");
		return task;
	}

}
