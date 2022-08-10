package fi.joonas.rekrytehtava.todoapp.model;

public enum TaskStatus {
	
	ONGOING("Kesken"),
	FINISHED("Valmis");
	
	private String status;

	TaskStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
}
