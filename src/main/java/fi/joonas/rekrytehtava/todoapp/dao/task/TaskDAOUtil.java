package fi.joonas.rekrytehtava.todoapp.dao.task;

import java.util.Calendar;
import java.util.Date;

public class TaskDAOUtil {

	/**
	 * construct date object which represent current day as 00:00:00:0000 (hh:mm:ss:SSSS)
	 * @return {@link Date}date
	 */
	public static Date createTodayStart() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	/**
	 * construct date object which represent current day as 23:59:59:0000 (hh:mm:ss:SSSS)
	 * @return {@link Date}date
	 */
	public static Date createTodayEnd() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
}
