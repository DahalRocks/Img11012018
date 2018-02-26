package com.dhruba.user;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class UserDetail {
	@NotEmpty(message="Age field can not be empty!!")
	private String age;
	@NotEmpty(message="Gender field can not be empty!!")
	private String gender;
	@NotEmpty(message="Education field can not be empty!!")
	private String education;
	@NotEmpty(message="Nationality field can not be empty!!")
	@Size(min = 2, max = 50, message = "Nationality is not correct")
	@Pattern(regexp="[a-zA-Z]+", message="Nationality can not be numerical or special character")
	private String nationality;
	@NotEmpty(message="Email field can not be empty!!")
	//@Email(message="Email address is not in a proper format!!")
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Email address is not in a proper format!!")
	private String email;
	
	@NotEmpty(message="Profession field can not be empty!!")
	private String profession;
	@NotEmpty(message="English Speaker field can not be empty!!")
	private String englishspeaker;
	@NotEmpty(message="English Level field can not be empty!!")
	private String englishlevel;
	@NotEmpty(message="Experience field can not be empty!!")
	private String haveexperience;
	@NotEmpty(message="Image accessibility field can not be empty!!")
	private String isawareof;
	
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public String getEnglishlevel() {
		return englishlevel;
	}
	public void setEnglishlevel(String englishlevel) {
		this.englishlevel = englishlevel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public String getEnglishspeaker() {
		return englishspeaker;
	}
	public void setEnglishspeaker(String englishspeaker) {
		this.englishspeaker = englishspeaker;
	}
	public String getHaveexperience() {
		return haveexperience;
	}
	public void setHaveexperience(String haveexperience) {
		this.haveexperience = haveexperience;
	}
	public String getIsawareof() {
		return isawareof;
	}
	public void setIsawareof(String isawareof) {
		this.isawareof = isawareof;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}
