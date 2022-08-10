package fi.joonas.rekrytehtava.todoapp.service;

import java.util.List;

import fi.joonas.rekrytehtava.todoapp.entity.Task;
public interface TaskService {

	public List<Task> findTodayTasks();
	public void persist(Task task);
	public void deleteTask(Task task);
	public void finishTask(Task task);
}
