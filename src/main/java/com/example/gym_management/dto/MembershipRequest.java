package com.example.gym_management.dto;

import java.time.LocalDate;

import jakarta.persistence.Id;

public class MembershipRequest {
	

	 private Long memberId;
	    private String membershipType;
	    private LocalDate startDate;
	    private LocalDate endDate;
	    private String status;

	    public MembershipRequest() {
	    }

	    public Long getMemberId() {
	        return memberId;
	    }

	    public void setMemberId(Long memberId) {
	        this.memberId = memberId;
	    }

	    public String getMembershipType() {
	        return membershipType;
	    }

	    public void setMembershipType(String membershipType) {
	        this.membershipType = membershipType;
	    }

	    public LocalDate getStartDate() {
	        return startDate;
	    }

	    public void setStartDate(LocalDate startDate) {
	        this.startDate = startDate;
	    }

	    public LocalDate getEndDate() {
	        return endDate;
	    }

	    public void setEndDate(LocalDate endDate) {
	        this.endDate = endDate;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
	}