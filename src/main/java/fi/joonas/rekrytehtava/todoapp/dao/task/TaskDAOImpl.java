package fi.joonas.rekrytehtava.todoapp.dao.task;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import fi.joonas.rekrytehtava.todoapp.entity.Task;

@Stateless
public class TaskDAOImpl implements TaskDAO {

	@PersistenceContext(unitName = "taskUnit") 
    private EntityManager entityManager;
	
	@Override
	public List<Task> findTodaysTasks() {
		Date todayStart = TaskDAOUtil.createTodayStart();
		Date todayEnd = TaskDAOUtil.createTodayEnd();
		//TODO figure out how to use equal compare of DD/MM/YY with jpql and h2.
		TypedQuery<Task> query = entityManager.createQuery("select t from Task t where created > :todayStart and created < :todayEnd", Task.class);
		query.setParameter("todayStart", todayStart, TemporalType.DATE);
		query.setParameter("todayEnd", todayEnd, TemporalType.DATE);
		return query.getResultList();
	}

	@Override
	public void persist(Task o) {
		entityManager.persist(o);
	}

	@Override
	/**
	 * Attach entity back to entitymanager if it is detached before deleting
	 */
	public void delete(Task o) {
		entityManager.remove(entityManager.contains(o) ? o : entityManager.merge(o));
	}

	@Override
	public void update(Task o) {
		entityManager.merge(o);
	}

}
