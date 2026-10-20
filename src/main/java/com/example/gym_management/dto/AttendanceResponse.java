package com.example.gym_management.dto;

import java.time.LocalDate;

public class AttendanceResponse {

	 private Long id;
	    private Long memberId;
	    private String memberName;
	    private Long trainerId;
	    private String trainerName;
	    private LocalDate date;
	    private String status;

	    public AttendanceResponse() {
	    }

	    public AttendanceResponse(
	            Long id,
	            Long memberId,
	            String memberName,
	            Long trainerId,
	            String trainerName,
	            LocalDate date,
	            String status) {

	        this.id = id;
	        this.memberId = memberId;
	        this.memberName = memberName;
	        this.trainerId = trainerId;
	        this.trainerName = trainerName;
	        this.date = date;
	        this.status = status;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Long getMemberId() {
	        return memberId;
	    }

	    public void setMemberId(Long memberId) {
	        this.memberId = memberId;
	    }

	    public String getMemberName() {
	        return memberName;
	    }

	    public void setMemberName(String memberName) {
	        this.memberName = memberName;
	    }

	    public Long getTrainerId() {
	        return trainerId;
	    }

	    public void setTrainerId(Long trainerId) {
	        this.trainerId = trainerId;
	    }

	    public String getTrainerName() {
	        return trainerName;
	    }

	    public void setTrainerName(String trainerName) {
	        this.trainerName = trainerName;
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

