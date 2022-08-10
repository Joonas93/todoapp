package fi.joonas.rekrytehtava.todoapp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import fi.joonas.rekrytehtava.todoapp.model.TaskStatus;

@Entity
@Table(name = "TASK")
public class Task implements Serializable{
	private static final long serialVersionUID = 3870671282324591899L;
	@Id
	@GeneratedValue
	@Column
	private long id;
	@Column(length = 50)
	private String description;
	@Column
	@Enumerated(EnumType.STRING)
	private TaskStatus status = TaskStatus.ONGOING;
	@Column
	private Date created;

	@PrePersist
	public void prePersist() {
		created = new Date();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}



}
