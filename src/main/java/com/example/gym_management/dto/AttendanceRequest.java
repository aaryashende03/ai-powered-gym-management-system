package com.example.gym_management.dto;

import java.time.LocalDate;

public class AttendanceRequest {
	
	   private Long memberId;
	    private Long trainerId;
	    private LocalDate date;
	    private String status;

	    public AttendanceRequest() {
	    }

	    public Long getMemberId() {
	        return memberId;
	    }

	    public void setMemberId(Long memberId) {
	        this.memberId = memberId;
	    }

	    public Long getTrainerId() {
	        return trainerId;
	    }

	    public void setTrainerId(Long trainerId) {
	        this.trainerId = trainerId;
	    }

	    public LocalDate getDate() {
	        return date;
	    }

	    public void setDate(LocalDate date) {
	        this.date = date;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
	}


