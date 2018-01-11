package com.dhruba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhruba.reminder.Reminder;
import com.dhruba.reminder.ReminderService;

@Controller
@Scope("session")
public class ReminderController {
	
	@Autowired
	ReminderService reminderService;
	
	@RequestMapping("/createreminderform")
	public String getReminder(Model model) {
		Reminder rem=reminderService.getReminder();
		model.addAttribute("reminder", rem);
		return "form_setreminder";
	}

	@RequestMapping("/setreminder")
	public String setReminder(Model model, Reminder reminder) {
		reminderService.setReminder(reminder);
		return "form_setreminder";
	}

}
