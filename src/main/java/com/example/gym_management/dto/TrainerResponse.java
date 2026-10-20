package com.example.gym_management.dto;

import java.time.LocalDate;

public class TrainerResponse {
	

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String specialization;
    private Integer experience;
    private LocalDate joiningDate;
    private String status;

    public TrainerResponse() {
    }

    public TrainerResponse(
            Long id,
            String name,
            String email,
            String phone,
            String specialization,
            Integer experience,
            LocalDate joiningDate,
            String status) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.specialization = specialization;
        this.experience = experience;
        this.joiningDate = joiningDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


