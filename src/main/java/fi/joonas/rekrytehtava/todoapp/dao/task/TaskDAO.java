package fi.joonas.rekrytehtava.todoapp.dao.task;

import java.util.List;

import fi.joonas.rekrytehtava.todoapp.dao.DAO;
import fi.joonas.rekrytehtava.todoapp.entity.Task;


public interface TaskDAO extends DAO<Task> {
	public List<Task> findTodaysTasks();
}
