package com.example.gym_management.dto;

import java.time.LocalDate;

public class TrainerRequest {
	
	  private String name;
	    private String email;
	    private String phone;
	    private String specialization;
	    private Integer experience;
	    private LocalDate joiningDate;
	    private String status;

	    public TrainerRequest() {
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

	    public String getSpecialization() {
	        return specialization;
	    }

	    public void setSpecialization(String specialization) {
	        this.specialization = specialization;
	    }

	    public Integer getExperience() {
	        return experience;
	    }

	    public void setExperience(Integer experience) {
	        this.experience = experience;
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


