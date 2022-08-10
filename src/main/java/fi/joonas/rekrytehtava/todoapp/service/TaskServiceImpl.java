package fi.joonas.rekrytehtava.todoapp.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import java.util.List;

import fi.joonas.rekrytehtava.todoapp.dao.task.TaskDAO;
import fi.joonas.rekrytehtava.todoapp.entity.Task;
import fi.joonas.rekrytehtava.todoapp.model.TaskStatus;
@Stateless
public class TaskServiceImpl implements TaskService {
	@Inject
	private TaskDAO taskDAO;
	

	@Override
	public List<Task> findTodayTasks() {
		return taskDAO.findTodaysTasks();
	}

	@Override
	public void persist(Task task) {
		taskDAO.persist(task);
	}

	@Override
	public void deleteTask(Task task) {
		taskDAO.delete(task);
	}

	@Override
	public void finishTask(Task task) {
		task.setStatus(TaskStatus.FINISHED);
		taskDAO.update(task);
	}
	
}
