package fi.joonas.rekrytehtava.todoapp.dao;

public interface DAO<T> {

	public void persist(T o);
	public void delete(T o);
	public void update(T o);
}
