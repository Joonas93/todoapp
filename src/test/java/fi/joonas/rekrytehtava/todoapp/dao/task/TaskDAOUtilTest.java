package fi.joonas.rekrytehtava.todoapp.dao.task;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

class TaskDAOUtilTest {
	
	@SuppressWarnings("deprecation")
	@Test
	void testCreateTodayStart() {
		Date today = Calendar.getInstance().getTime();
		Date date = TaskDAOUtil.createTodayStart();
		assertEquals(today.getYear(), date.getYear());
		assertEquals(today.getMonth(), date.getMonth());
		assertEquals(today.getDay(), date.getDay());
		assertEquals(0, date.getHours());
		assertEquals(0, date.getMinutes());
		assertEquals(0, date.getSeconds());
	}
	@SuppressWarnings("deprecation")
	@Test
	void testCreateTodayEnd() {
		Date today = Calendar.getInstance().getTime();
		Date date = TaskDAOUtil.createTodayEnd();
		assertEquals(today.getYear(), date.getYear());
		assertEquals(today.getMonth(), date.getMonth());
		assertEquals(today.getDay(), date.getDay());
		assertEquals(23, date.getHours());
		assertEquals(59, date.getMinutes());
		assertEquals(59, date.getSeconds());
	}

}
