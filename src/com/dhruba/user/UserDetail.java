package com.dhruba.user;

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
	private String nationality;
	@NotEmpty(message="Email field can not be empty!!")
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
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
