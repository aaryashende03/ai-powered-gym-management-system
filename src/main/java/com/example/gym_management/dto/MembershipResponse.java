package com.example.gym_management.dto;

import java.time.LocalDate;

public class MembershipResponse {
	
	   private Long id;
	    private Long memberId;
	    private String memberName;
	    private String membershipType;
	    private LocalDate startDate;
	    private LocalDate endDate;
	    private String status;

	    public MembershipResponse() {
	    }

	    public MembershipResponse(
	            Long id,
	            Long memberId,
	            String memberName,
	            String membershipType,
	            LocalDate startDate,
	            LocalDate endDate,
	            String status) {

	        this.id = id;
	        this.memberId = memberId;
	        this.memberName = memberName;
	        this.membershipType = membershipType;
	        this.startDate = startDate;
	        this.endDate = endDate;
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