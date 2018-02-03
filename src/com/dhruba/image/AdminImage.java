package com.dhruba.image;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class AdminImage {
	private int imageid;
	private String imagename;
	@NotNull(message="Specify if it has sub image!!")
	private boolean haveSubimage;
	private CommonsMultipartFile file;
	private CommonsMultipartFile randomimagefile;
	private CommonsMultipartFile similarimagefile;
	private String randomimage;
	private String similarimage;
	private int parentid;
	private String imagetype;
	private String subimagename;
	private int subimageid;
	private String imagedescription;
	private String randomimagedescription;
	private String similarimagedescription;
	@NotEmpty(message="Parent image description can not be empty")
	private String parentimagedescription;
	private String evaluationstring;
	private int imagedescriptionid;
	private boolean isEvaluated;
	@NotEmpty(message="Parent image description can not be empty")
	private String parentimagetype;
	
	public String getParentimagetype() {
		return parentimagetype;
	}
	public void setParentimagetype(String parentimagetype) {
		this.parentimagetype = parentimagetype;
	}
	public boolean isEvaluated() {
		return isEvaluated;
	}
	public void setEvaluated(boolean isEvaluated) {
		this.isEvaluated = isEvaluated;
	}
	public String getEvaluationstring() {
		return evaluationstring;
	}
	public void setEvaluationstring(String evaluationstring) {
		this.evaluationstring = evaluationstring;
	}
	public int getImagedescriptionid() {
		return imagedescriptionid;
	}
	public void setImagedescriptionid(int imagedescriptionid) {
		this.imagedescriptionid = imagedescriptionid;
	}
	public String getParentimagedescription() {
		return parentimagedescription;
	}
	public void setParentimagedescription(String parentimagedescription) {
		this.parentimagedescription = parentimagedescription;
	}
	public String getRandomimagedescription() {
		return randomimagedescription;
	}
	public void setRandomimagedescription(String randomimagedescription) {
		this.randomimagedescription = randomimagedescription;
	}
	public String getSimilarimagedescription() {
		return similarimagedescription;
	}
	public void setSimilarimagedescription(String similarimagedescription) {
		this.similarimagedescription = similarimagedescription;
	}
	public String getImagedescription() {
		return imagedescription;
	}
	public void setImagedescription(String imagedescription) {
		this.imagedescription = imagedescription;
	}
	public int getSubimageid() {
		return subimageid;
	}
	public void setSubimageid(int subimageid) {
		this.subimageid = subimageid;
	}
	public String getSubimagename() {
		return subimagename;
	}
	public void setSubimagename(String subimagename) {
		this.subimagename = subimagename;
	}
	public String getImagetype() {
		return imagetype;
	}
	public void setImagetype(String imagetype) {
		this.imagetype = imagetype;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getRandomimage() {
		return randomimage;
	}
	public void setRandomimage(String randomimage) {
		this.randomimage = randomimage;
	}
	public String getSimilarimage() {
		return similarimage;
	}
	public void setSimilarimage(String similarimage) {
		this.similarimage = similarimage;
	}
	public CommonsMultipartFile getRandomimagefile() {
		return randomimagefile;
	}
	public void setRandomimagefile(CommonsMultipartFile randomimagefile) {
		this.randomimagefile = randomimagefile;
	}
	public CommonsMultipartFile getSimilarimagefile() {
		return similarimagefile;
	}
	public void setSimilarimagefile(CommonsMultipartFile similarimagefile) {
		this.similarimagefile = similarimagefile;
	}
	public CommonsMultipartFile getFile() {
		return file;
	}
	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
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
	public boolean isHaveSubimage() {
		return haveSubimage;
	}
	public void setHaveSubimage(boolean haveSubimage) {
		this.haveSubimage = haveSubimage;
	}
	
	

}
