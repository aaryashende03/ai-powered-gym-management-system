package com.example.gym_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gym_management.dto.MembershipRequest;
import com.example.gym_management.dto.MembershipResponse;
import com.example.gym_management.service.MembershipService;

@RestController
@RequestMapping("/memberships")
public class MembershipController {

	
	  private final MembershipService membershipService;

	    public MembershipController(
	            MembershipService membershipService) {
	        this.membershipService = membershipService;
	    }

	    // Get all memberships
	    @GetMapping
	    public List<MembershipResponse> getAllMemberships() {
	        return membershipService.getAllMemberships();
	    }

	    // Get membership by ID
	    @GetMapping("/{id}")
	    public MembershipResponse getMembershipById(
	            @PathVariable("id") Long id) {
	        return membershipService.getMembershipById(id);
	    }

	    // Create membership
	    @PostMapping
	    public MembershipResponse saveMembership(
	            @RequestBody MembershipRequest request) {
	        return membershipService.saveMembership(request);
	    }

	    // Update membership
	    @PutMapping("/{id}")
	    public MembershipResponse updateMembership(
	            @PathVariable("id") Long id,
	            @RequestBody MembershipRequest request) {
	        return membershipService.updateMembership(id, request);
	    }

	    // Delete membership
	    @DeleteMapping("/{id}")
	    public String deleteMembership(@PathVariable("id") Long id) {
	        membershipService.deleteMembership(id);
	        return "Membership deleted successfully";
	    }
	}