package com.dhruba.page;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.dhruba.reminder.Reminder;
import com.dhruba.user.User;

@Component
@Scope("session")
public class Page {
	
	private User user;
	
	private Reminder reminder;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Reminder getReminder() {
		return reminder;
	}
	public void setReminder(Reminder reminder) {
		this.reminder = reminder;
	}
	@NotEmpty(message="Page title can not be empty!!")
	private String pagename;
	private int pageid;
	public String getPagename() {
		return pagename;
	}
	public void setPagename(String pagename) {
		this.pagename = pagename;
	}
	public int getPageid() {
		return pageid;
	}
	public void setPageid(int pageid) {
		this.pageid = pageid;
	}
	public Page(int pageid) {
			this.pageid = pageid;
	}
	public Page(){
		
	}
	
	
	
		

}
