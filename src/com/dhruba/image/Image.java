package com.dhruba.image;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dhruba.page.Page;

@Component
@Scope("session")
public class Image {
	
	private Page page;
	
	private int imageid;
	private String imagename;
	//@NotEmpty(message="Image type can not be empty!!")
	private String imagetype;
	
	//@NotEmpty(message="Title field can not be empty!!")
	private String title;
	//@NotEmpty(message="Caption field can not be empty!!")
	private String caption;
	//@NotEmpty(message="Alt text field can not be empty!!")
	private String alttext;
	//@NotEmpty(message="Description field can not be empty!!")
	private String description;
	
	private String url;
	
	private int division;
		
	private CommonsMultipartFile file;
			
	public int getImageid() {
		return imageid;
	}
	public void setImageid(int imageid) {
		this.imageid = imageid;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getImagetype() {
		return imagetype;
	}
	public void setImagetype(String imagetype) {
		this.imagetype = imagetype;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public int getDivision() {
		return division;
	}
	public void setDivision(int division) {
		this.division = division;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public CommonsMultipartFile getFile() {
		return file;
	}
	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getAlttext() {
		return alttext;
	}
	public void setAlttext(String alttext) {
		this.alttext = alttext;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
