package com.example.gym_management.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "/memberships")
public class Membership {
	

	     @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "member_id", nullable = false)
	    private Member member;

	 
	    private String membershipType;

	  
	    private LocalDate startDate;

	  
	    private LocalDate endDate;

	    private String status;

	    public Membership() {
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Member getMember() {
	        return member;
	    }

	    public void setMember(Member member) {
	        this.member = member;
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