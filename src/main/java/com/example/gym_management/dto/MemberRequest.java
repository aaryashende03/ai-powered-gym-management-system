package com.example.gym_management.dto;

import java.time.LocalDate;

public class MemberRequest {

	 private String name;
	    private String email;
	    private String phone;
	    private Integer age;
	    private String gender;
	    private LocalDate joiningDate;
	    private String status;

	    public MemberRequest() {
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public Integer getAge() {
	        return age;
	    }

	    public void setAge(Integer age) {
	        this.age = age;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }

	    public LocalDate getJoiningDate() {
	        return joiningDate;
	    }

	    public void setJoiningDate(LocalDate joiningDate) {
	        this.joiningDate = joiningDate;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
}



