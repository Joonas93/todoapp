package fi.joonas.rekrytehtava.todoapp.controller;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fi.joonas.rekrytehtava.todoapp.entity.Task;
import fi.joonas.rekrytehtava.todoapp.service.TaskService;
@Named
@ViewScoped
public class ToDoListController  implements Serializable {
	private static final long serialVersionUID = -675372113049912529L;
	
	private List<Task> tasks = new LinkedList<>();
	private Task newTask = new Task();
	@Inject
	TaskService taskService;
	
    @PostConstruct
    public void init() {
		tasks = getTodayTasks();
	}
    
    public void addTask() {
    	taskService.persist(newTask);
    	tasks = getTodayTasks();
    	newTask = new Task();
    }
	
    public void deleteTask(Task task) {
    	taskService.deleteTask(task);
    	tasks = getTodayTasks();
    }
    public void finishTask(Task task) {
    	taskService.finishTask(task);
    	tasks = getTodayTasks();
    }
    
	public List<Task> getTasks() {
		return tasks;
	}

	private List<Task> getTodayTasks() {
		return taskService.findTodayTasks();
	}

	public Task getNewTask() {
		return newTask;
	}

	public void setNewTask(Task newTask) {
		this.newTask = newTask;
	}
}
