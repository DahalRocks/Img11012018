package com.dhruba.text;



import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.dhruba.page.Page;

@Component
@Scope("session")
public class TextContent {
	
	@NotEmpty(message="Content field can not be empty!!")
	private String content;
	@NotEmpty(message="Content title field can not be empty!!")
	private String contenttitle;
	
	private Boolean reminder;
		
	private Page page;
	
	private int division;
	
	private int textcontentid;
	
		
	public Boolean getReminder() {
		return reminder;
	}
	public void setReminder(Boolean reminder) {
		this.reminder = reminder;
	}
	public String getContenttitle() {
		return contenttitle;
	}
	public void setContenttitle(String contenttitle) {
		this.contenttitle = contenttitle;
	}
	public int getDivision() {
		return division;
	}
	public void setDivision(int division) {
		this.division = division;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	public int getTextcontentid() {
		return textcontentid;
	}
	public void setTextcontentid(int textcontentid) {
		this.textcontentid = textcontentid;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getTextcontendid() {
		return textcontentid;
	}
	public void setTextcontendid(int textcontendid) {
		this.textcontentid = textcontendid;
	}
	
	
}
