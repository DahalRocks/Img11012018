package com.dhruba.reminder;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class ReminderService implements Serializable {

	private static final long serialVersionUID = 2827238317709041564L;
	@Autowired
	private ReminderDao reminderDao;
	@Autowired
	Reminder objReminder;

	public boolean setReminder(Reminder reminder) {
		boolean isCreated = true;
		try {
			reminderDao.setReminder(reminder);
		} catch (DataAccessException e) {
			isCreated = false;
		}
		return isCreated;
	}

	public Reminder getReminder() {
		List<Reminder> lstReminder = reminderDao.getReminder();
		if (lstReminder.size() != 0) {
			objReminder = lstReminder.get(lstReminder.size() - 1);
		}
		return objReminder;
	}
}
