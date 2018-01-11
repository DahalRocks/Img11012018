package com.dhruba.reminder;



import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class Reminder {
	
	private Boolean check;

	public Boolean getCheck() {
		return check;
	}

	public void setCheck(Boolean check) {
		this.check = check;
	}

	public Reminder(Boolean check) {
		this.check = check;
	}

	public Reminder() {

	}

}
